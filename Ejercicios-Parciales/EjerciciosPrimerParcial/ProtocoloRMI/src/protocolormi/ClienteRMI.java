/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package protocolormi;

import java.net.MalformedURLException;
import java.nio.channels.AlreadyBoundException;
import java.nio.channels.NotYetBoundException;
import java.nio.charset.MalformedInputException;
import java.rmi.RemoteException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Franz Gonzales
 */

public class ClienteRMI {

    public static void main(String[] args) {
        try {
            // Conectar con el registro RMI en localhost (o la IP del servidor)
            Registry registry = LocateRegistry.getRegistry("localhost", 1100);

            // Buscar el objeto remoto por su nombre (en este caso "HolaMundo")
            ISaludo saludo = (ISaludo) registry.lookup("Saludo");

            // Invocar el método remoto y mostrar el resultado
            String mensaje = saludo.saludar();
            System.out.println("Mensaje recibido del servidor: " + mensaje);
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
