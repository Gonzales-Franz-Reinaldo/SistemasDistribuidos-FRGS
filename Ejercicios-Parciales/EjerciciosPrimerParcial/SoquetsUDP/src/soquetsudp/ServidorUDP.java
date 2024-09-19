/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package soquetsudp;

import java.io.IOException;
import java.net.*;
/**
 *
 * @author Franz Gonzales
 */
public class ServidorUDP {

    public static void main(String[] args) throws IOException {
        int port = 6789;
        
        try{
            DatagramSocket socketUDP = new DatagramSocket(port);
            byte[] buffer = new byte[1024]; 
            
            System.out.println("Servidor UDP escuchando en el puerto " + port);
            
            while(true){
                
                // Recibimos datagrama
                DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);
                socketUDP.receive(peticion);
                
                // Convertir datos a cadena
                String mensajeRecibido = new String(peticion.getData(), 0, peticion.getLength());
                System.out.println("Mensaje recibido: " + mensajeRecibido);
                
                // Preparar respuesta
                String respuesta = "Respuesta desde el servidor UDP: " + mensajeRecibido;
                byte[] respuestaBytes = respuesta.getBytes();
                
                // Enviar respuesta al cliente
                DatagramPacket respuestaPaquete = new DatagramPacket(respuestaBytes, respuestaBytes.length, peticion.getAddress(), peticion.getPort());
                socketUDP.send(respuestaPaquete);
            }
        } catch(SocketException e){
            System.out.println("Error en el socket: " + e.getMessage());
        } catch (IOException e){
            System.out.println("Error de E/S: " + e.getMessage());
        }
    }
    
}
