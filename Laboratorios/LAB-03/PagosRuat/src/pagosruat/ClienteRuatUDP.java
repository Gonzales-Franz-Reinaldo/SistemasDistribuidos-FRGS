/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pagosruat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author Franz Gonzales
 */
public class ClienteRuatUDP {
    private String host;
    private int port;

    public ClienteRuatUDP(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public String consultarAlcaldia(String ci) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress address = InetAddress.getByName(host);
        byte[] bufferSend = ("consulta:" + ci).getBytes();
        DatagramPacket packetSend = new DatagramPacket(bufferSend, bufferSend.length, address, port);
        socket.send(packetSend);

        byte[] bufferReceive = new byte[1024];
        DatagramPacket packetReceive = new DatagramPacket(bufferReceive, bufferReceive.length);
        socket.receive(packetReceive);
        socket.close();

        return new String(packetReceive.getData()).trim();
    }
}
