
package soquetstcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Franz Gonzales
 */
public class Servidor {

    public static void main(String[] args) {
        // Puerto por el cual escuchará las conexiones entrantes
        int port = 5002;
        ServerSocket server;
        
        try {
            server = new ServerSocket(port);  // Escucha el puerto específico, para aceptar conexiones
            System.out.println("Se inicio el seridor con exito");
            
            Socket client;
            PrintStream toClient;
//            Bloquea hasta que el  cliente se conecte al servidor
            client = server.accept();  // Conexion entre cliente y servidor para comunicación bidimensional
            
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
            System.out.println("El cliente se conectó");
//            Leemos los datos enviados por el cliente
            String recibido = fromClient.readLine();
            System.out.println("El cliente envio el mensaje: " + recibido);
            
//            Enviamos mensaje al cliente desde el servidor
            toClient = new PrintStream(client.getOutputStream());
            toClient.println("Hola mundo desde el servidor.");
        } catch (IOException ex) {
            System.out.print(ex.getMessage());
        }
    }
}
