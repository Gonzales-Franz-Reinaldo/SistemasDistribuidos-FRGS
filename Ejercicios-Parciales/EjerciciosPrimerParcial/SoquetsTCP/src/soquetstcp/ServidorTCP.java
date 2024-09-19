/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soquetstcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Franz Gonzales
 */
public class ServidorTCP {
    
    public static void main(String[] args) {
        // Definimos el puerto de comunicacion
        int port = 5000;
        
        try{
            // Creamos un socket de servidor en el puerto 5000
            ServerSocket server = new ServerSocket(port);
            System.out.println("Se inicio el servidor con exito.");
            
            // Esperamos la conexión de un cliente
            Socket client = server.accept();
            System.out.println("Cliente conectado.");
            
            // Leemos los mensajes del cliente
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
            
            // Enviamos mensaje de respuesta al cliente
            PrintWriter toClient = new PrintWriter(client.getOutputStream(), true);
            
            // Leemos el mensaje enviado  por el cliente
            String mensaje = fromClient.readLine();
            System.out.println("El cliente envio : " + mensaje);
            
            // Responder al cliente con un mensaje
            toClient.println("Hola desde el servidor..");
            
            // Cerrar los flujos y el socket al concluir la comunicacion
            fromClient.close();
            toClient.close();
            client.close();
            System.out.println("Conexion finalizada con el cliente.");
        }catch(IOException ex){
            System.out.print(ex.getMessage());
        }
        
    }
}
