
package conexiontcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;


/**
 *
 * @author Franz Gonzales
 */
public class Cliente {
    public static void main(String[] args) {
        int port = 5002;  // Puerto por el cual el cliente se conectará al servidor
        String direccionServer = "";  // Direccion de IP del servidor
        
        try {
            Socket client = new Socket(direccionServer, port); // Conectarse al servidor
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
            
            
//            Enviamos datos al servidor, un mensaje
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese un numero n: ");
            int n = scanner.nextInt();
            
//            Enviamos el número n al servidor
            toServer.println(n);
            
//            Recinir la respuesta del servidor 
            String factorial = fromServer.readLine();
            String fibonacci = fromServer.readLine();
            
            System.out.println(factorial);
            System.out.println(fibonacci);
            
        } catch (IOException ex) {
            System.out.print(ex.getMessage());
        }
    }
}