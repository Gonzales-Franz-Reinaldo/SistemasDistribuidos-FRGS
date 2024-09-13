package ejer5_rabitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import java.nio.charset.StandardCharsets;

public class Recv {

    private final static String QUEUE_NAME = "operaciones";

    public static void main(String[] argv) throws Exception {
        
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("franz");
        factory.setPassword("gonzales");
        
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Esperando mensajes. Para salir, presiona CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String operacion = new String(delivery.getBody(), StandardCharsets.UTF_8);
            
            String resultado = resolverOperaciones(operacion);
            System.out.println(" [x] Received '" + resultado + "'");
        };
        
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });
    }
    
    private static String resolverOperaciones(String operaciones){
        String[] valores = operaciones.split(" ");
        
        int numero_veces = Integer.parseInt(valores[1]);
        int numero1 = Integer.parseInt(valores[1]);
        char operacion = valores[2].charAt(0);
        int numero2 = Integer.parseInt(valores[3]);
        
        double resultado;
        
        switch(operacion){
            case '+':
                resultado = numero1 + numero2;
                break;
            case '-':
                resultado = numero1 - numero2;
                break;
            case '*':
                resultado = numero1 * numero2;
                break;
            case '/':
                if(numero2 != 0){
                    double division = (double) numero1 / numero2;
                    resultado = Math.round(division * 100.0) / 100.0;
                }else{
                    return operacion + "division por sero";
                }
                break;
            default:
                return "Operacion ivalidada";
        }
        
        return "Ope: " + numero_veces + "=> " + numero1 + " " + operacion + " " + numero2 + " = " + resultado; 
    }
}