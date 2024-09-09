/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package combinado;

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
        String url = "jdbc:mysql://localhost:3306/deuda?zeroDateTimeBehavior=CONVERT_TO_NULL";
        String usuario = "root";
        String password = "";
        DeudaDAO deudaDAO = new DeudaDAO(url, usuario, password);
        System.out.println(ci);
        ArrayList<Deuda> auxiliar = deudaDAO.listar(ci);
        int puerto = 6789;
        int anio;
        Impuesto impuesto;
        double monto;
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
            String ip = "localhost";
            String ci = deuda.getCi();
            String anio=deuda.getAnio();
            Impuesto impuesto=deuda.getImpuesto();
            String i=impuesto.toString();
            String monto=deuda.getMonto();
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
            if ("Tiene observaciones".equals(resultado.trim())) {
                System.out.println("Se mandó un false ya que tiene observaciones");
                return false;
            } else {
                System.out.println("Se mandó un true ya que no tiene observaciones");
                String url = "jdbc:mysql://localhost:3306/deuda?zeroDateTimeBehavior=CONVERT_TO_NULL";
                String usuario = "root";
                String password = "";
                DeudaDAO deudaDAO = new DeudaDAO(url, usuario, password);
                deudaDAO.eliminarDeuda(ci, anio, i, monto);
                System.out.println("Se pago la deuda con ci" + ci+ ":anio:" + anio +": impuesto: "+ i+" monto" + monto );
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
