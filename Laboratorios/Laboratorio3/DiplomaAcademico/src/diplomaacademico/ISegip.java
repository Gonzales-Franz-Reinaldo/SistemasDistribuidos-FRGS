/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cajeroautomaticormi;

/**
 *
 * @author Franz Gonzales
 */
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ISegip extends Remote {
    public Respuesta verificarCI(String ci) throws RemoteException;
}
