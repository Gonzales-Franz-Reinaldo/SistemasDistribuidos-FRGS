package Ejer2_Soquets;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    
    public static void main(String[] args) {
        int puerto = 12345;
        
        Scanner sc = new Scanner(System.in);
        try {

            Socket socket = new Socket("localhost", puerto);
            System.out.println("Conectado a " + socket.getInetAddress() + " en el puerto " + puerto);

            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter toServer = new PrintWriter(socket.getOutputStream(), true);

            while (true) {
                
                System.out.println("Menú principal ");
                System.out.println("1. Introduce un número y una cadena a|b|c.");
                System.out.println("2. Pedir resultado.");
                System.out.println("3. Salir");

                System.out.print("Seleccione una opción: ");

                int opcion = sc.nextInt();
                sc.nextLine();

                String mensaje = ""; 

                switch (opcion) {
                    case 1:
                        System.out.print("Introduzca un número: ");
                        int numero = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Introduzca una cadena: ");
                        String cadena = sc.nextLine();

                        mensaje = numero + ";" + cadena;
                        toServer.println(mensaje);

                        System.out.println("Respuesta del Servidor: " + entrada.readLine());
                        break;
                    case 2:
                        mensaje = "resultado";
                        toServer.println(mensaje);
                        System.out.println("Respuesta del Servidor: " + entrada.readLine());
                        break;
                    case 3:
                        toServer.println("salir");
                        System.out.println("Conexión cerrada");
                        return;
                    default:
                        break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
