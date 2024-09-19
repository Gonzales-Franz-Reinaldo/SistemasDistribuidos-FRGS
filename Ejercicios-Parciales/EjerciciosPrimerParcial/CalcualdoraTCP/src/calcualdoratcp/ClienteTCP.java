/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calcualdoratcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Franz Gonzales
 */
public class ClienteTCP {
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        
        int port = 5000;   // Puerto en el que escucha el servidor
        String hostname = "localhost";  // Dirección del servidor (localhost)
        
        while(true){
            
            Socket client = new Socket(hostname, port);

            DataOutputStream toServer = new DataOutputStream(client.getOutputStream());
            DataInputStream fromServer = new DataInputStream(client.getInputStream());


            // Mostrar menú
            System.out.println("Seleccione una operación:");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicación");
            System.out.println("4. División");
            System.out.println("5. Factorial");
            System.out.println("6. Fibonacci");
            System.out.print("Opción: ");

            int opcion = scanner.nextInt();
            toServer.writeInt(opcion);

            switch (opcion) {
                case 1: // Suma
                case 2: // Resta
                case 3: // Multiplicación
                case 4: // División
                    System.out.print("Ingrese el primer número: ");
                    int a = scanner.nextInt();
                    System.out.print("Ingrese el segundo número: ");
                    int b = scanner.nextInt();
                    toServer.writeInt(a);
                    toServer.writeInt(b);

                    if (opcion == 4) {
                        String response = fromServer.readUTF();
                        System.out.println("Resultado: " + response);
                    } else {
                        int result = fromServer.readInt();
                        System.out.println("Resultado: " + result);
                    }
                    break;

                case 5: // Factorial
                    System.out.print("Ingrese un número: ");
                    int n = scanner.nextInt();
                    toServer.writeInt(n);
                    long factorial = fromServer.readLong();
                    System.out.println("Factorial: " + factorial);
                    break;

                case 6: // Fibonacci
                    System.out.print("Ingrese un número: ");
                    n = scanner.nextInt();
                    toServer.writeInt(n);
                    int fibonacci = fromServer.readInt();
                    System.out.println("Fibonacci: " + fibonacci);
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
            client.close();
        }
    }
}
