/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pagos_ruat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author pablo
 */
public class Ruat2 extends UnicastRemoteObject implements IRuat2 {

    public Ruat2() throws RemoteException {
        super();
    }

    @Override
    public ArrayList<Deuda> ConsultarDeuda(String ci) throws RemoteException {
        System.out.println(ci);
        ArrayList<Deuda> auxiliar = new ArrayList<>();
        int puerto = 6789;
        int anio;
        Impuesto impuesto;
        double monto;
        try {
            if (ci.equals("1234567")) {
                System.out.println("Deuda con el numero 1234567");
                System.out.println("");
                Deuda deuda = new Deuda(ci, "2022", Impuesto.Vehiculo, "2451.0");
                auxiliar.add(deuda);
                Deuda deuda2 = new Deuda(ci, "2022", Impuesto.Inmueble, "2500.0");
                auxiliar.add(deuda2);
            }
            if (ci.equals("555587")) {
                System.out.println("Deuda con el numero 555587");
                System.out.println("");
                Deuda deuda = new Deuda(ci, "2021", Impuesto.Vehiculo, "5000.0");
                auxiliar.add(deuda);
            }
            if (ci.equals("333357")) {
                System.out.println("Deuda con el numero 333357");
                System.out.println("");
                Deuda deuda = new Deuda(ci, "2023", Impuesto.Inmueble, "24547.0");
                auxiliar.add(deuda);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        for (Deuda deuda : auxiliar) {
            System.out.println(deuda);
        }
        return auxiliar;
    }

    @Override
    public Boolean PagarDeuda(Deuda deuda) throws RemoteException {
        int puerto = 6789;
        try {
            deuda.toString();
            String ip = "192.168.192.58";
            String ci = deuda.getCi();
            System.out.println(ci);
            DatagramSocket socketUDP = new DatagramSocket();
            byte[] mensaje = ci.getBytes();
            InetAddress hostServidor = InetAddress.getByName(ip);
            // Construimos un datagrama para enviar el mensaje al servidor
            DatagramPacket peticion = new DatagramPacket(mensaje, mensaje.length, hostServidor, puerto);
            // Enviamos el datagrama
            socketUDP.send(peticion);
            byte[] bufer = new byte[1000];
            DatagramPacket respuesta = new DatagramPacket(bufer, bufer.length);
            socketUDP.receive(respuesta);
            String resultado = new String(respuesta.getData());
            // Enviamos la respuesta del servidor a la salida estandar
            System.out.println("Respuesta: " + resultado);
            socketUDP.close();
            if (resultado.equals("Tiene observaciones")) {
                return false;
            } else {
                return true;
            }
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
        return null;
    }

}
