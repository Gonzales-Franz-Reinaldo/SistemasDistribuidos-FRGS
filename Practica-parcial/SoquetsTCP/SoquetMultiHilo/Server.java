package SoquetsTCP.SoquetMultiHilo;

import java.io.*;
import java.net.*;

public class Server {
    
    public static void main(String[] args) {
        int port = 12345;

        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Servidor iniciado en el puerto " + port);

            while(true){
                // Espera una conexión y delega la comunicación a un nuevo hilo
                Socket client = server.accept();
                System.out.println("Cliente conectado desde: " + client.getInetAddress());

                // Crear un hilo para manejar al cliente
                new ClientHandler(client).start();
            }
        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }
}
