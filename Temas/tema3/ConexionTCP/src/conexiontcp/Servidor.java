package conexiontcp;

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
        
        Operaciones operaciones = new Operaciones();

        ServerSocket server;

        try {
            server = new ServerSocket(port);  // escucha el puerto específico, para aceptar conexiones
            System.out.println("Se inicio el seridor con exito");
            System.out.println("Servidor escuchando en el puerto " + port);

            while (true) {

//              bloquea hasta que el  cliente se conecte al servidor
                Socket client = server.accept();  
                System.out.println("Cliente conectado");
                
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintStream toClient = new PrintStream(client.getOutputStream());
               
//              Leemos los datos enviados por el cliente
                String recibido = fromClient.readLine();
                int n = Integer.parseInt(recibido);
                System.out.println("El número recibido es: " + n);
                
                int factorial = operaciones.factorial(n);
                int fibonacci = operaciones.fibonacci(n);              

//            Enviamos mensaje al cliente desde el servidor
                toClient.println("El factorial de " + n + "es: " + factorial);
                toClient.println("El Fibonacci de " + n + "es: " + fibonacci);
                
                client.close();
            }
        } catch (IOException ex) {
            System.out.print(ex.getMessage());
        }
    }
}
