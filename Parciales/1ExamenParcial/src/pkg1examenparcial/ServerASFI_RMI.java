/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg1examenparcial;

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
        // Crear una instancia del objeto remoto

        Cuenta cuenta =  new Cuenta(Banco.Mercantil, "11021654", "12345", "Juan", "Perez Segovia", 500.0);
        
        // Crear o localizar  el registro RMI por el puerto
        Registry registry = LocateRegistry.createRegistry(1099);
        
        // Registrar el objeto remoto con un nombre (Nombre de objeto)
        registry.rebind("Cuenta", cuenta);
        
        System.out.println("Servidor RMI está listo.");
    }
}
