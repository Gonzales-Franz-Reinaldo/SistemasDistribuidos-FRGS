package ejer1.factorialtcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Franz Gonzales
 */
public class Servidor {

    public static void main(String[] args) {
        int port = 5002;
        ServerSocket server;
        Operaciones operaciones = new Operaciones();

        try {
            server = new ServerSocket(port);
            System.out.println("Se inicio el servidor correctamente.");

            while (true) {

                Socket client = server.accept();
                System.out.println("El cliente se conecto..");

                BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintStream toClient = new PrintStream(client.getOutputStream());

                while (true) {
                    String operacion = fromClient.readLine();
                    System.out.println("Operacion enviada es: " + operacion);

                    if (operacion == null || operacion.equalsIgnoreCase("salir")) {
                        break;
                    }

                    String respuesta1 = "";

                    if (operacion.equalsIgnoreCase("fac") || operacion.equalsIgnoreCase("fib") || operacion.equalsIgnoreCase("sum")) {
                        respuesta1 = "ok";
                    } else {
                        respuesta1 = "Error operación no valida";
                    }

                    toClient.println(respuesta1);

                    if (respuesta1.equals("ok")) {

                        String respuesta = fromClient.readLine();
                        Integer numero = Integer.parseInt(respuesta);
                        operaciones.setNumero(numero);

                        String resultado = "";
                        switch (operacion) {
                            case "fac":
                                resultado = String.valueOf(operaciones.factorial());
                                break;
                            case "fib":
                                resultado = String.valueOf(operaciones.fibonacci());
                                break;
                            case "sum":
                                resultado = String.valueOf(operaciones.sumatoria());
                                break;
                            default:
                                System.out.println("Operación inválida.");
                                break;
                        }

                        toClient.println(resultado);
                    }
                }
                client.close(); 
                System.out.println("Cliente desconectado.");
            }
        } catch (IOException ex) {
            System.out.print(ex.getMessage());
        }
    }
}
