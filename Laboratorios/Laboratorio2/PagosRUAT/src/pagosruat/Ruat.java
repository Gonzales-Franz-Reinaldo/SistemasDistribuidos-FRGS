package pagosruat;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Ruat extends UnicastRemoteObject implements IRuat {
    
    private ArrayList<Deuda> lista_deudas;

    public Ruat() throws RemoteException {
        super();
        // Inicializar la lista de deudas con datos estáticos
        lista_deudas = new ArrayList<>();
        lista_deudas.add(new Deuda("1234567", 2022, Impuesto.Vehiculo, 2451));
        lista_deudas.add(new Deuda("1234567", 2022, Impuesto.Casa, 2500));
        lista_deudas.add(new Deuda("555587", 2021, Impuesto.Vehiculo, 5000));
        lista_deudas.add(new Deuda("333357", 2023, Impuesto.Casa, 24547));
        
    }

    
    @Override
    public Deuda[] Buscar(String ci) throws RemoteException {
        ArrayList<Deuda> resultado = new ArrayList<>();
        
        for(Deuda deuda : lista_deudas){
            if(deuda.getCi().equals(ci)){
                resultado.add(deuda);
            }
        }   
        return resultado.toArray(new Deuda[resultado.size()]);
    }

    @Override
    public Boolean Pagar(Deuda deuda) throws RemoteException {
        
        try {
            String resultado = consultarAlcaldia(deuda.getCi());
            return resultado.equals("true");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public String consultarAlcaldia(String ci) throws Exception{
        
        DatagramSocket client = new DatagramSocket();
        InetAddress direccion  = InetAddress.getByName("localhost");
        byte[] mensaje = ("consulta:" + ci).getBytes();
        
        DatagramPacket toServer = new DatagramPacket(mensaje, mensaje.length, direccion, 9876);
        client.send(toServer);
        
        byte[] respuesta = new byte[1024];
        DatagramPacket packetReceive = new  DatagramPacket(respuesta, respuesta.length);
        client.receive(packetReceive);
        client.close();
        
        return new String(packetReceive.getData()).trim();
        
    } 

}
