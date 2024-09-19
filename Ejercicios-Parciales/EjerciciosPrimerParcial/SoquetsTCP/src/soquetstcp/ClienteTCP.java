/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soquetstcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Franz Gonzales
 */
public class ClienteTCP {
    public static void main(String[] args) {
       
        int port = 5000;   // Puerto en el que escucha el servidor
        String hostname = "localhost";  // Dirección del servidor (localhost)
        
        try{
            // Creamos el socket cliente
            Socket client = new Socket(hostname, port);
            System.out.println("Cliente conectado al servidor en " + hostname + " en el puerto " + port);
            
            // Enviamos mensaje al servidor de salida
            PrintWriter toServer = new PrintWriter(client.getOutputStream(), true);
            
            // Flujo de entreda, leemos la respuesta del servidor.
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
            
            // Enviar mensaje al servidor.
            toServer.println("Hola mundo desde el cliente");
            
            // Leer la respuesta del servidor
            String respuesta = fromServer.readLine();
            System.out.println("Respuesta del servidor: " + respuesta);
            
        } catch(IOException ex){
            System.out.print(ex.getMessage());
        }
    }
}
