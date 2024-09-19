/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestioestudianteudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 *
 * @author Franz Gonzales
 */
public class DocenteUDP {
    
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        // Creamos el socket UDP
        DatagramSocket socketUDP = new DatagramSocket();
        InetAddress host = InetAddress.getByName("localhost");
        
        while(true){
            System.out.println("Menú:");
            System.out.println("1. Buscar estudiante");
            System.out.println("2. Eliminar estudiante");
            System.out.println("3. Mostrar todos los estudiantes");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine();
            
            String mensaje = "";

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el CI del estudiante: ");
                    String ciBuscar = scanner.nextLine();
                    mensaje = "buscar;" + ciBuscar;
                    break;
                case 2:
                    System.out.print("Ingrese el CI del estudiante a eliminar: ");
                    String ciEliminar = scanner.nextLine();
                    mensaje = "eliminar;" + ciEliminar;
                    break;
                case 3:
                    mensaje = "mostrar;";
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    socketUDP.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
                    continue;
            }
            
            
            byte[] mensajeBytes = mensaje.getBytes();
            DatagramPacket peticion = new DatagramPacket(mensajeBytes, mensajeBytes.length, host, 6789);
            socketUDP.send(peticion);

            byte[] buffer = new byte[1024];
            DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length);
            socketUDP.receive(respuesta);

            String respuestaStr = new String(respuesta.getData(), 0, respuesta.getLength());
            System.out.println("Respuesta del servidor: " + respuestaStr);
        }
    }
}
