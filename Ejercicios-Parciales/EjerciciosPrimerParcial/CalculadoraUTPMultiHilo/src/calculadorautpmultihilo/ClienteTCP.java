/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadorautpmultihilo;
import java.io.*;
import java.net.*;
import java.util.Scanner;
/**
 *
 * @author Franz Gonzales
 */
public class ClienteTCP {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 5000;
        
        try {
            
            Socket client = new Socket(host, port);
            System.out.println("Conectado al servidor en " + host + ":" + port);

            // Flujos de entrada y salida
            DataInputStream fromServer = new DataInputStream(client.getInputStream());
            DataOutputStream toServer = new DataOutputStream(client.getOutputStream());
            Scanner sc = new Scanner(System.in);

            // Menú
            while (true) {
                System.out.println("Seleccione una operación:");
                System.out.println("1. Suma");
                System.out.println("2. Resta");
                System.out.println("3. Multiplicación");
                System.out.println("4. División");
                System.out.println("5. Factorial");
                System.out.println("6. Fibonacci");
                System.out.println("7. Salir");
                System.out.println("Opcion: ");

                int opcion = sc.nextInt();
                toServer.writeInt(opcion);  // Enviar la opción seleccionada al servidor

                if (opcion == 7) {
                    System.out.println("Saliendo...");
                    break;
                }

                // Pedir valores según la operación
                if (opcion >= 1 && opcion <= 4) {
                    System.out.print("Ingrese el primer número: ");
                    int num1 = sc.nextInt();
                    System.out.print("Ingrese el segundo número: ");
                    int num2 = sc.nextInt();
                    toServer.writeInt(num1);  // Enviar primer número
                    toServer.writeInt(num2);  // Enviar segundo número
                } else if (opcion == 5 || opcion == 6) {
                    System.out.print("Ingrese un número: ");
                    int num = sc.nextInt();
                    toServer.writeInt(num);  // Enviar número para factorial o fibonacci
                }

                // Leer y mostrar el resultado
                String resultado = fromServer.readUTF();
                System.out.println("Resultado: " + resultado);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
