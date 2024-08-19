
package ejer1.factorialtcp;

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
        int port = 5002;
        Scanner scanner = new Scanner(System.in);
        int numero = 0;
        
        try{
            Socket client = new Socket("localhost", port);
            
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
            
            int opcion = 0;
            
            while(opcion!=5){
                System.out.println("\nMENÚ PRINCIPAL");
                System.out.println("1. Insertar un valor de n: ");
                System.out.println("2. Calcualr Factorial");
                System.out.println("3. Calcualr Fibonacci");
                System.out.println("4. Calcualr Sumatoria");
                System.out.println("5. Salir.");
                System.out.print("Selecciona una opción: ");
                
                opcion = scanner.nextInt();
                scanner.nextLine();
                
                switch(opcion){
                    case 1:
                        System.out.print("Introduce el valor de n: ");
                        numero = scanner.nextInt();
                        scanner.nextLine();
                        break;               
                    case 2:
                        toServer.println("fac");
                        String respuestaFac = fromServer.readLine();
                        
                        if(respuestaFac.equals("ok")){
                            toServer.println(String.valueOf(numero));
                            String resultadoFac = fromServer.readLine();
                            System.out.println("Factorial de " + numero + " es: "+resultadoFac);
                        }
                        break;
                    case 3:
                        toServer.println("fib");
                        
                        String respuestsFib = fromServer.readLine();
                        if(respuestsFib.equals("ok")){
                            toServer.println(String.valueOf(numero));
                            String resultadoFib = fromServer.readLine();
                            System.out.println("Fibonacci de " + numero + " es: " + resultadoFib);
                        }
                        break;
                    case 4:
                        
                        toServer.println("sum");
                        String respuestaSum = fromServer.readLine();
                        if (respuestaSum.equals("ok")) {
                            toServer.println(String.valueOf(numero));
                            String resultadoSum = fromServer.readLine();
                            System.out.println("Sumatoria de " + numero + " es: " + resultadoSum);
                        }
                        break;
                        
                    case 5:
                        
                        System.out.println("Salienod..");
                        break;
                     default:
                        System.out.println("Opción no válida.");
                        break;
                }
            }
                        
            client.close();
            
        }catch(IOException ex){
            System.out.print(ex.getMessage());
        }
    }
}
