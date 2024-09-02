/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pagos_ruat;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pablo
 */
public class ServidorRMI {
    public static void main(String[] args) {
        try {
            Ruat2 ruat2=new Ruat2();
            LocateRegistry.createRegistry(1099);
            
//            LocateRegistry.createRegistry(1099);
//            Ruat ruat = new Ruat();
//            Naming.rebind("rmi://192.168.192.132/Ruat", ruat2);
//            System.out.println("Servidor Ruat corriendo...");
            try {
//                Naming.bind("Ruat",ruat2);
                Naming.rebind("rmi://192.168.192.132/Ruat", ruat2);
                System.out.println("Servidor Ruat corriendo...");
            } catch (MalformedURLException ex) {
                Logger.getLogger(ServidorRMI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(ServidorRMI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
