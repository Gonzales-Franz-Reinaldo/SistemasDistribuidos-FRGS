/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg1examenparcial;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Franz Gonzales
 */
public class ServerASFI_RMI {
    
    public static void main(String[] args) throws RemoteException, AlreadyBoundException, MalformedURLException{
        
        Cuenta cuenta =  new Cuenta(Banco.Mercantil, "11021654", "12345", "Juan", "Perez Segovia", 500.0);
        
        Registry registry = LocateRegistry.createRegistry(1099);
        
        registry.rebind("Cuenta", cuenta);
        
        System.out.println("Servidor RMI está listo.");
        
        
        
    }
}
