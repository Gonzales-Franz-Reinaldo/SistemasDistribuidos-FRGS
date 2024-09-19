/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package protocolormi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Franz Gonzales
 */

// Definir la interfaz remota
public interface ISaludo extends Remote{
    public String saludar() throws RemoteException;
}
