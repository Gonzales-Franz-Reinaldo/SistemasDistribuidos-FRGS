/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package protocolormi;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
/**
 *
 * @author Franz Gonzales
 */

// Implementar la interfaz remota
public class Saludo extends UnicastRemoteObject implements ISaludo{

    public Saludo() throws RemoteException{
        super();
    }
    
    @Override
    public String saludar() throws RemoteException {
        return "Hola mundo desde el servidor..";
    }
    
}
