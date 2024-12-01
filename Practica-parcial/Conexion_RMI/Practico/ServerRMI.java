package Conexion_RMI.Practico;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerRMI {
    public static void main(String[] args) {
        
        try {
            
            // Crear una instancia del objeto remoto
            IBiblioteca biblioteca = new Biblioteca();

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("Biblioteca", biblioteca);

            System.out.println("Servidor RMI iniciado en el puerto 1099");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
