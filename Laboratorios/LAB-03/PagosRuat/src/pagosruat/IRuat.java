/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pagosruat;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Franz Gonzales
 */
public interface IRuat extends Remote {
    public Deuda[] Buscar(String ci) throws RemoteException;
    public Boolean Pagar(Deuda deuda) throws RemoteException;
}