/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pagosruat;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.net.MalformedURLException;

/**
 *
 * @author Franz Gonzales
 */

public class RuatServidorRMI {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            Ruat ruat = new Ruat();
            Naming.rebind("rmi://localhost/RuatService", ruat);
            System.out.println("Servidor Ruat corriendo...");
        } catch (RemoteException | MalformedURLException e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }
}
