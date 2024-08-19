
package ejer1.factorialtcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Franz Gonzales
 */
public class Servidor {
    
    public static void main(String[] args) {
        int port = 5002;
        ServerSocket server;
        Operaciones operaciones = new Operaciones();
        
        try{
            server = new ServerSocket(port);
            System.out.println("Se inicio el servidor correctamente.");
            
            String respuesta1;
            String respuesta2;
            String resultado = "";
            
            while(true){
                Socket client;
                PrintStream toClient;
                
                client = server.accept();
                
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
                System.out.println("El cliente se conecto..");
                
                String operacion = fromClient.readLine();
                System.out.println("Operacion enviada es: "+ operacion);
                
                toClient = new PrintStream(client.getOutputStream());
                
                if(operacion.equalsIgnoreCase("fac") || operacion.equalsIgnoreCase("fib") || operacion.equalsIgnoreCase("sum")){
                    respuesta1 = "ok";
                }else {
                    respuesta1 = "Error operación no valida";
                }
                
                toClient.println(respuesta1);
                
                String respuesta = fromClient.readLine();
                Integer numero = Integer.parseInt(respuesta);
                operaciones.setNumero(numero);
                
                switch(operacion){
                    case "fac":
                        resultado = String.valueOf(operaciones.factorial());
                        break;
                    case "fib":
                        resultado = String.valueOf(operaciones.fibonacci());
                        break;
                    case "sum":
                        resultado = String.valueOf(operaciones.sumatoria());
                        break;
                    default :
                        System.out.println("Operación inválida.");
                        break;
                }
                
                toClient.println(resultado);
            }
        }catch(IOException ex){
            System.out.print(ex.getMessage());
        }
    }
}
