package main

import (
	"context"
	"log"
	"math/rand"
	"os"
	"strconv"
	"strings"
	"time"

	amqp "github.com/rabbitmq/amqp091-go"
)

func failOnError(err error, msg string){
	if err != nil {
		log.Panicf("%s: %s", msg, err)
	}	
}

func generarCorrelationId(longitud int) string{
	bytes := make([]byte, longitud)

	for i := 0; i < longitud; i++ {
		bytes[i] = byte(randInt(65, 90))
	}
	return string(bytes)
}

func randInt(min int, max int) int{
	return min + rand.Intn(max - min)
}


// Conexion a rabbitMQ 
func fibonacciRPC(n int) (res int, err error){

	conexion, err := amqp.Dial("amqp://franz:gonzales@localhost:5672/")
	failOnError(err, "Fallo al conectar al servidor RabbitMQ")
	defer conexion.Close()

	// Abrimos el canal 
	canal, err := conexion.Channel()
	failOnError(err, "Fallo al abrir el canal")
	defer canal.Close()

	// Declaramos la cola exclusiva para el cliente 
	cola_client, err := canal.QueueDeclare(
		"", // name
		false, 	// durable
		false, // delete when unused
		true,  // exclusive
		false, //noWait
		nil,  //arguments
	)
	failOnError(err, "Fallo al declarar una cola")


	// Concumir mensaje 
	mensaje, err := canal.Consume(
		cola_client.Name,  // queue
		"",
		true,
		false,
		false,
		false,
		nil,
	)
	failOnError(err, "Fallo al registrar un consumidor")

	corrId := generarCorrelationId(32)


	// Limite de tiempo 
	contexto, cancel := context.WithTimeout(context.Background(), 5 * time.Second)
	defer cancel()

	err = canal.PublishWithContext(
		contexto,
		"",
		"rpc_cola", // routing key
		false,
		false,
		amqp.Publishing{
			ContentType: "text/plain",
			CorrelationId: corrId,
			ReplyTo: cola_client.Name,
			Body: 	[]byte(strconv.Itoa(n)),
		})
	failOnError(err, "Fallo al publicar el mensaje")


	// Esperar la respuesta 
	for d := range mensaje {
		if corrId == d.CorrelationId{
			res, err = strconv.Atoi(string(d.Body))
			failOnError(err, "Fallo al convertir a un numero a entero.")
			break
		}
	}

	return
}



func main(){
	rand.Seed(time.Now().UTC().UnixNano())

	numero := bodyFrom(os.Args)

	log.Printf(" [x] Requesting fibonacci(%d)", numero)
	respuesta, err := fibonacciRPC(numero)
	failOnError(err, "No se pudo controlar la solicitud RPC")

	log.Printf(" [.] Got %d", respuesta)
}


func bodyFrom(args []string) int{
	var s string
	if (len(args) < 2) || os.Args[1] == ""{
		s = "30"
	}else{
		s = strings.Join(args[1:], " ")
	}

	numero, err := strconv.Atoi(s)
	failOnError(err, "Fallo de convertir arg a entero")

	return numero
}


