/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package diplomaacademico;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Franz Gonzales
 */
public class ServidorUniversidadRMI {
    
    public static void main(String[] args) throws RemoteException, AlreadyBoundException, MalformedURLException{
        // Crear una instancia del objeto remoto
        IDiploma diploma = new Diploma();
        
        // Crear o localizar el registro RMI
        Registry registry  = LocateRegistry.createRegistry(1099);
        
        // Registrar el objeto remoto con el nombre
        registry.rebind("DiplomadoAcademico", diploma);
        
        System.out.println("Servidor RMI del Cajero Automático está listo.");
    }
}
