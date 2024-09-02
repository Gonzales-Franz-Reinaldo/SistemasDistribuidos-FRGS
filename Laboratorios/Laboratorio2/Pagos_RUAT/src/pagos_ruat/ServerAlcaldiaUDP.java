/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pagos_ruat;

/**
 *
 * @author pablo
 */
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author sergio
 */
public class ServerAlcaldiaUDP {
    public static void main(String[] args) {
        int port=6789;
        try {

            DatagramSocket socketUDP = new DatagramSocket(port);
            byte[] bufer = new byte[1000];

            while (true) {
                boolean obvs = false;
                String response = " ";
                Alcaldia alcaldia = new Alcaldia();

                // Construimos el DatagramPacket para recibir peticiones
                DatagramPacket peticion =
                        new DatagramPacket(bufer, bufer.length);

                // Leemos una petición del DatagramSocket
                socketUDP.receive(peticion);
                String cadena =new String (peticion.getData(), 0, peticion.getLength());
                //System.out.println(cadena);
                obvs = alcaldia.Consulta(cadena);

               if(obvs){
                   response = "Tiene observaciones";
               }else {
                   response = "No tiene observaciones";
               }

                byte[] mensaje = response.getBytes();

                //Construimos el DatagramPacket para mandar la respuesta
                DatagramPacket respuesta =
                        new DatagramPacket(mensaje, mensaje.length,
                                peticion.getAddress(), peticion.getPort());

                // Enviamos la respuesta, que es un eco
                socketUDP.send(respuesta);
            }

        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
    }
}
