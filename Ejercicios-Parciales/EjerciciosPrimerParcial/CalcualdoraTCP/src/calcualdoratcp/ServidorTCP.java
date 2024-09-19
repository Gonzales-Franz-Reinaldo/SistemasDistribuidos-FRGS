/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calcualdoratcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Franz Gonzales
 */
public class ServidorTCP {
    public static void main(String[] args) throws IOException{
        
        int port = 5000;
        ServerSocket server = new ServerSocket(port);
        System.out.println("Se conecto el servidor correctamente.");
        
        while(true){
            
            Socket client = server.accept();
            new HiloServidorTCP(client).start();
            System.out.println("Cliente conectado.");
        }
    }
}
