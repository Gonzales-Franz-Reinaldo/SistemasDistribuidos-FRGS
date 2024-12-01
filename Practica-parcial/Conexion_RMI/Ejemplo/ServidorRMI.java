package Conexion_RMI.Ejemplo;


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServidorRMI {
    public static void main(String[] args) {

        try{

            // Crear una instancia del objeto remoto
            ICalculadora calculadora = new Calculadora();

            // Registrar el objeto remoto en el RMI Registry
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("Calculadora", calculadora);

            System.out.println("Servidor RMI iniciado en el puerto 1099");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
