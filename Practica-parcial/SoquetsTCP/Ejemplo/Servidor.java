import java.io.*;
import java.net.*;

public class Servidor {

    public static void main(String[] args) {
        int puerto = 5000;  // Puerto donde el server escuchará conexiones

        try {
            ServerSocket server = new ServerSocket(puerto);
            System.out.println("Servidor iniciado en el puerto " + puerto);

            // Espera a que un client se conecte
            Socket client = server.accept();
            System.out.println("Cliente conectado desde " + client.getInetAddress() + ":" + client.getPort());

            // Flujo de entrada y salida
            BufferedReader entrada = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter salida = new PrintWriter(client.getOutputStream(), true);

            // Comunicación con el client
            String mensaje;
            while((mensaje = entrada.readLine()) != null) {
                System.out.println("Cliente: " + mensaje);

                // Responde al Cliente
                salida.println("Servidor recibió: " + mensaje);

                // Finaliza la comunicación si el client envía "Salir"
                if(mensaje.equals("Salir")) {
                    System.out.println("Conexión cerrada por el client.");
                    break;
                }
            }

            // Cierra flujos y sockets
            client.close();
            System.out.println("Conexion cerrada.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}