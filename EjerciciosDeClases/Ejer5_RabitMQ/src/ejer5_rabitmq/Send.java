
package ejer5_rabitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.nio.charset.StandardCharsets;
import java.util.Random;

public class Send {

    private final static String QUEUE_NAME = "operaciones";

    public static void main(String[] argv) throws Exception {
        
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
//        Datos del usuario
        factory.setUsername("franz");
        factory.setPassword("gonzales");
        
        try (Connection connection = factory.newConnection();
            Channel channel = connection.createChannel()) {
            
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            
            for(int i = 1; i <= 500; i++){
                
                String operacion = generarOperacion(i);
                channel.basicPublish("", QUEUE_NAME, null, operacion.getBytes(StandardCharsets.UTF_8));
                System.out.println(" [x] Sent '" + operacion + "'");
            }
        }
    }
    
    
    private static String generarOperacion(int num){
        Random random = new Random();
        char[] operaciones = {'+', '-', '*', '/'};
        
        int numero1 = random.nextInt(100) + 1;
        int numero2 = random.nextInt(100) + 1;
        int posicion = random.nextInt(operaciones.length);
        char operacion = operaciones[posicion];
        
        return num + " " + numero1 + " " + operacion + " " + numero2;
    }
}