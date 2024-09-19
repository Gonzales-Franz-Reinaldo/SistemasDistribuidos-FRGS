/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadorautpmultihilo;

/**
 *
 * @author Franz Gonzales
 */
import java.io.*;
import java.net.*;

public class ServidorTCP {

    public static void main(String[] args) {
        int port = 5000;

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Servidor escuchando en el puerto " + port);

            // Bucle infinito para aceptar múltiples conexiones
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente conectado: " + clientSocket.getInetAddress());

                // Crear un hilo para manejar la conexión con el cliente
                new ClientHandler(clientSocket).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
