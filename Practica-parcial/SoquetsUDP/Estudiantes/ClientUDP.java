package SoquetsUDP.Estudiantes;

import java.net.*;
import java.util.Scanner;

public class ClientUDP {
    public static void main(String[] args) {
        int port = 8000;
        byte[] buffer = new byte[1024];
        String host = "localhost";

        try {

            Scanner scanner = new Scanner(System.in);

            DatagramSocket socket = new DatagramSocket();
            System.out.println("Conectado al servidor UDP en " + host + ":" + port);

            while (true) {
                // Mostrar menú
                System.out.println("Menu de Opciones:");
                System.out.println("1. Registrar estudiante");
                System.out.println("2. Consultar estudiante");
                System.out.println("3. Eliminar estudiante");
                System.out.println("4. Listar estudiantes");
                System.out.println("5. Salir");

                System.out.print("Seleccione una opción: ");

                int opcion = scanner.nextInt();
                scanner.nextLine();

                String mensaje = "";
                switch (opcion) {
                    case 1:
                        System.out.print("Introduzca el nombre del estudiante: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Introduzca el apellido del estudiante: ");
                        String apellido = scanner.nextLine();
                        System.out.print("Introduzca la edad del estudiante: ");
                        int edad = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Introduzca la carrera: ");
                        String carrera = scanner.nextLine();

                        mensaje = "registrar;" + nombre + ";" + apellido + ";" + edad + ";" + carrera;
                        break;
                    case 2:
                        System.out.print("Introduzca el nombre del estudiante: ");
                        nombre = scanner.nextLine();

                        mensaje = "consultar;" + nombre;
                        break;
                    case 3:
                        System.out.print("Introduzca el nombre del estudiante: ");
                        nombre = scanner.nextLine();
                        mensaje = "eliminar;" + nombre;
                        break;
                    case 4:
                        mensaje = "listar_estudiantes";
                        break;
                    case 5:
                        mensaje = "salir";
                        break;
                    default:
                        System.out.println("Opción inválida.");
                        continue;
                }

                // Enviar mensaje al servidor
                byte[] bufferMensaje = mensaje.getBytes();
                InetAddress address = InetAddress.getByName(host);

                DatagramPacket peticion = new DatagramPacket(
                    bufferMensaje, 
                    bufferMensaje.length, 
                    address, 
                    port
                );

                socket.send(peticion);

                if (mensaje.equals("salir")) {
                    break;
                }

                // Recibir respuesta del servidor
                DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length);
                socket.receive(respuesta);

                String mensajeRespuesta = new String(respuesta.getData(), 0, respuesta.getLength());
                System.out.println("\nRespuesta del servidor: ");
                System.out.println(mensajeRespuesta);

                // scanner.close();
            }
            // socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
