
package soquetstcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;


/**
 *
 * @author Franz Gonzales
 */
public class Cliente {
    public static void main(String[] args) {
        int port = 5002;  // Puerto por el cual el cliente se conectará al servidor
        
        try {
            Socket client = new Socket("localhost", port); // Conectarse al servidor
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
//            Enviamos datos al servidor, un mensaje
            toServer.println("Hola mundo desde el cliente");
            
//            Recinir la respuesta del servidor 
            String result = fromServer.readLine();
            System.out.println("Cadena devuelta por el servidor es: "+ result);
            
        } catch (IOException ex) {
            System.out.print(ex.getMessage());
        }
    }
}
