/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pagos_ruat;

/**
 *
 * @author pablo
 */
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author sergio
 */
public class Alcaldia extends UnicastRemoteObject {
    protected Alcaldia() throws RemoteException {
        super();
    }
    public Boolean Consulta(String ci) throws RemoteException {
        boolean observaciones = false;

        if (ci.equals("1234567")) {
            observaciones = true;
            return observaciones;
        }
        if (ci.equals("555587")) {
            return observaciones;
        }
        if (ci.equals("333357")) {
            return observaciones;
        }
        return observaciones;
    }

}