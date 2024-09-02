/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pagosruat;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
/**
 *
 * @author Franz Gonzales
 */
public class AlcaldiaUDP {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(9876);
            byte[] bufferReceive = new byte[1024];

            System.out.println("Servidor de Alcaldía en ejecución...");

            while (true) {
                DatagramPacket packetReceive = new DatagramPacket(bufferReceive, bufferReceive.length);
                socket.receive(packetReceive);
                String solicitud = new String(packetReceive.getData()).trim();
                String respuesta;

                if (solicitud.startsWith("consulta:")) {
                    String ci = solicitud.split(":")[1];
                    if (ci.equals("1234567")) {
                        respuesta = "false";
                    } else {
                        respuesta = "true";
                    }

                    byte[] bufferSend = respuesta.getBytes();
                    DatagramPacket packetSend = new DatagramPacket(bufferSend, bufferSend.length, packetReceive.getAddress(), packetReceive.getPort());
                    socket.send(packetSend);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
