package main

// Importamos las librerias y paquetes
import (
	"context"
	"log"
	"strconv"
	"time"

	amqp "github.com/rabbitmq/amqp091-go"
)

// Funcion para simplificar el manejo de errores
func failOnError(err error, msg string){
	if err != nil {
		log.Panicf("%s: %s", msg, err)
	}
}

// Funcion para calcular el fibonacci de un numero
func fibonacci(n int) int {
	if n == 0{
		return 0
	}else if n == 1{
		return 1
	} else{
		return fibonacci(n-1) + fibonacci(n-2)
	}
}

func factorial(n int) int {

	if n == 0 {
		return 1
	} else if n == 1{
		return 1
	}

	var fac = 1

	for i := 1; i <= n; i++{
		fac *= i
	}

	return fac
}



func main(){

	conexion, err := amqp.Dial("amqp://franz:gonzales@localhost:5672/")
	failOnError(err, "Fallo en la conexión a RabbitMQ")
	defer conexion.Close()

	canal, err := conexion.Channel()
	failOnError(err, "Fallo en abrir el canal")
	defer canal.Close()

	cola, err := canal.QueueDeclare(
		"rpc_cola",  // name
		false,     // durable
		false,     // eliminar  cuando no se use
		false,     // exclusive
		false,     // no-wait
		nil,		//anrgumentos
	)
	failOnError(err, "Fallo en declarar la cola")
	
	
	err = canal.Qos(
		1, // prefetch count
		0, // prefetch size
		false, // global
	)
	failOnError(err, "No se pudo establecer QoS")

	mensaje, err := canal.Consume(
		cola.Name,   // queue
		"",         // conusmidor
		false,      // auto-ack
		false,	// exclusive
		false,	// no-local
		false,	// no-wait
		nil,	// args
	)
	failOnError(err, "No se pudo registrar a un consumidor")

	var forever chan struct {}


	go func ()  {

		contexto, cancel := context.WithTimeout(context.Background(), 5 * time.Second)
		defer cancel()

		for d := range mensaje {
			numero, err := strconv.Atoi(string(d.Body))
			failOnError(err, "Fallo al convertir el mensaje a numero entero.")

			log.Printf("[.] fibonacci(%d)", numero)
			respuesta := fibonacci(numero)

			err = canal.PublishWithContext(
				contexto,	
				"",	// exchange
				d.ReplyTo, // routing key
				false, // mandatory
				false, // mandatory
				amqp.Publishing{
					ContentType: "text/plain",
					CorrelationId: d.CorrelationId,
					Body: 		[]byte(strconv.Itoa(respuesta)),
				})
			failOnError(err, "Fallo en publicar el mensage")
			d.Ack(false)
		}
	}()

	log.Printf(" [*] A la espera de solicitudes de RPC")
	<-forever
} 