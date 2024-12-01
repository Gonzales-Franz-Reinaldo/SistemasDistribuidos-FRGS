import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) {
        String servidor = "localhost"; // Dirección del servidor
        int puerto = 5000; // Puerto del servidor

        try {
            
            Socket socket = new Socket(servidor, puerto);
            System.out.println("Conectado al servidor en " + servidor + ":" + puerto);

            // Flujos de entrada y salida
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);

            // Leer mensajes desde la consola
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            String mensaje;

            System.out.println("Escribe un mensaje (escribe 'salir' para terminar):");

            while ((mensaje = teclado.readLine()) != null) {
                // Enviar mensaje al servidor
                salida.println(mensaje);

                // Leer respuesta del servidor
                String respuesta = entrada.readLine();
                System.out.println("Servidor: " + respuesta);

                // Finaliza si el usuario escribe "salir"
                if (mensaje.equalsIgnoreCase("salir")) {
                    System.out.println("Conexión cerrada.");
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
