/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pagos_ruat;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author pablo
 */
public interface IRuat2 extends Remote {
    public ArrayList<Deuda> ConsultarDeuda(String ci) throws RemoteException;
    public Boolean PagarDeuda(Deuda deuda) throws RemoteException;
}
