package SoquetsUDP.Ejemplo;

import java.net.*;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        
        String host = "localhost";
        int port = 8000;
        byte[] buffer = new byte[1024];

        try {
            
            Scanner scanner = new Scanner(System.in);

            DatagramSocket socket = new DatagramSocket();
            System.out.println("Conectado al servidor UDP en " + host + ":" + port);

            // Leer mensaje desde la consola
            System.out.print("Escribe un número entero: ");
            String mensaje = scanner.nextLine();

            // Enviar mensaje al servidor
            byte[] bufferMensaje = mensaje.getBytes();
            InetAddress address = InetAddress.getByName(host);

            DatagramPacket peticion = new DatagramPacket(bufferMensaje, bufferMensaje.length, address, port);
            socket.send(peticion);

            // Recibir respuesta del servidor
            DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length);
            socket.receive(respuesta);

            String respuestaServidor = new String(respuesta.getData(), 0, respuesta.getLength());
            System.out.println("Respuesta del servidor: " + respuestaServidor);

            socket.close();
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
