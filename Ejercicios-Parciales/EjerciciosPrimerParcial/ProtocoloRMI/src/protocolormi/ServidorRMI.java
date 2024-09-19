/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package protocolormi;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
/**
 *
 * @author Franz Gonzales
 */
public class ServidorRMI {
    
    public static void main(String[] args) throws RemoteException, AlreadyBoundException, MalformedURLException{
        // Crear una instancia del objeto remoto
        Saludo saludo =  new Saludo();
        
        // Crear o localizar  el registro RMI por el puerto
        Registry registry = LocateRegistry.createRegistry(1100);
        
        // Registrar el objeto remoto con un nombre (Nombre de objeto)
        registry.rebind("Saludo", saludo);
        
        System.out.println("Servidor RMI está listo.");
    }
}
