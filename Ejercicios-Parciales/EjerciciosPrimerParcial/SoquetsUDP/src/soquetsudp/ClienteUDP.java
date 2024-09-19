/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soquetsudp;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;
/**
 *
 * @author Franz Gonzales
 */
public class ClienteUDP {
    public static void main(String[] args){
        
        Scanner  scanner = new Scanner(System.in);
        
        String serverAddress = "localhost";
        int port = 6789;
        
        try{
            // Creamos el socket UDP
            DatagramSocket socketUDP = new DatagramSocket();
            
            System.out.print("Ingrese un mensaje: ");
            String mensaje = scanner.nextLine();
            byte[] buffer = mensaje.getBytes();
            
            // Obtener la dirección del servidor
            InetAddress hostServidor = InetAddress.getByName(serverAddress);
            
            // Crear un datagrama para enviar el mensaje
            DatagramPacket peticion = new DatagramPacket(buffer, buffer.length, hostServidor, port);
            socketUDP.send(peticion);
            
            // Preparamos el buffer para recibir la respuesta del servidor
            buffer = new byte[1024];
            DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length);
            socketUDP.receive(respuesta);
            
            // Convertir la respuesta a cadena y mostrar
            String response = new String(respuesta.getData(), 0, respuesta.getLength());
            System.out.println("Respuesta del servidor: " + response);
            
            // Cerrar socket
            socketUDP.close();
            
        }catch(SocketException e){
             System.out.println("Error en el socket: " + e.getMessage());
        } catch(IOException e){
            System.out.println("Error de E/S: " + e.getMessage());
        }
    }
}
