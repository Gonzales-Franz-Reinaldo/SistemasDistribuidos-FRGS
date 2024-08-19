
package ejer2.juego.ahorcado;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 *
 * @author Franz Gonzales
 */
public class ServidorAhorcado {
    
    private static final String[] palabras = {"facultad", "sistemas", "ciencias", "cliente", "materia", "tecnologia"};
    
    public static void main(String[] args) {
        int port = 5002;
        
        try{
            ServerSocket server = new ServerSocket(port);
            System.out.println("Servido Ahorcado inciando correctamente..");
            
            while(true){
                Socket client = server.accept();
                System.out.println("Cliente conectado");
                
                String palabraAleatoria = palabras[new Random().nextInt(palabras.length)];
                
               // creamos hilos para manejar a cada cliente
               new HiloCliente(client, palabraAleatoria).start();
            }
            
        }catch(IOException ex){
            System.out.println("Error en el servidor: " + ex.getMessage());
        }
    }
}
