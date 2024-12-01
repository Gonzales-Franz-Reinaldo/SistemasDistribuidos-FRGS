package SoquetsTCP.Operaciones;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        
        int puerto = 12345;
        Scanner sc = new Scanner(System.in);

        try {
            Socket socket = new Socket("localhost", puerto);
            System.out.println("Conectado al servidor en el puerto " + puerto);


            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter toServer = new PrintWriter(socket.getOutputStream(), true);

            System.out.println("Introduzca una Operación valida fac/sum/fibo/serieFibo: ");

            String operacion = sc.nextLine();
            toServer.println(operacion);

            String mensaje = entrada.readLine();
            System.out.println(mensaje);

            if(mensaje.contains("invalida")){
                socket.close();
                return;
            }

            // System.out.println("Introduzca un numero: ");
            String numero = sc.nextLine();

            toServer.println(numero);
            
            String resultado = entrada.readLine();
            System.out.println(resultado);

            socket.close();
            sc.close();
            System.out.println("Conexión cerrada");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
