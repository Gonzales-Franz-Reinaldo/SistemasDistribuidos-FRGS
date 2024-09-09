/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operaciones;

import java.net.MalformedURLException;
import java.nio.channels.AlreadyBoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.rmi.*;



/**
 *
 * @author Franz Gonzales
 */
public class Servidor {
    public static void main(String[] args) throws AlreadyBoundException {
        try {
            Operacion operacion = new Operacion();
            LocateRegistry.createRegistry(1099);
            Naming.bind("Operaciones", operacion);
        } catch (RemoteException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch(AlreadyBoundException ex){
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch(MalformedURLException ex){
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
