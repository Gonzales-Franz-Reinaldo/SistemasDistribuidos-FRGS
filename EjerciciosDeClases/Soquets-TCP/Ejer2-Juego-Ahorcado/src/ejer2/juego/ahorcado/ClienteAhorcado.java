
package ejer2.juego.ahorcado;

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
public class ClienteAhorcado {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 5002;
        
        try{
            Socket client = new Socket(host, port);
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
            
            Scanner scanner = new Scanner(System.in);
            
            String respuestaServer;

            while ((respuestaServer = fromServer.readLine()) != null) {
                System.out.println(respuestaServer);
                
                if (respuestaServer.equals("Introduce una letra: ")) {
                    String input = scanner.nextLine();
                    toServer.println(input);
                }
            }
            
            client.close();
            
        }catch(IOException ex){
            System.out.println("Error en el cliente: " + ex.getMessage());
        }
    }
}
