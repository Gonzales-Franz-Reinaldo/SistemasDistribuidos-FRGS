package Ejer2_Soquets;

import java.io.*;
import java.net.*;
import java.net.Socket;

public class ClientHandler extends Thread {

    private Socket client;
    private int a = 0;
    private int b = 0;
    private int c = 0;

    public ClientHandler(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {

        try {

            BufferedReader entrada = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter toClient = new PrintWriter(client.getOutputStream(), true);

            String mensaje = "";
            while (true) {

                mensaje = entrada.readLine();

                if (mensaje.equals("salir")) {
                    System.out.println("Cliente desconectado");
                    client.close();
                    return;
                }

                if(mensaje.equals("resultado")){
                    int menor = Math.min(a, Math.min(b, c));
                    toClient.println("El menor de los tres números es: " + menor);
                    continue;
                }
            
                // System.out.println("Mensaje del cliente: " + mensaje);

                String[] datos = mensaje.split(";");


                int numero = Integer.parseInt(datos[0]);

                String cadena = datos[1];

                String respuesta = "";

                if (cadena.equalsIgnoreCase("a")) {

                    a = numero;
                    respuesta = "El valor de a es: " + a + " 'Ok'";
                } else if (cadena.equalsIgnoreCase("b")) {
                    b = numero;
                    respuesta = "El valor de b es: " + b + " 'Ok'";
                } else if (cadena.equalsIgnoreCase("c")) {
                    c = numero;
                    respuesta = "El valor de c es: " + c + " 'Ok'";
                } else {
                    System.out.println("Cadena invalida");
                }

                toClient.println(respuesta);
            }

        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }
}
