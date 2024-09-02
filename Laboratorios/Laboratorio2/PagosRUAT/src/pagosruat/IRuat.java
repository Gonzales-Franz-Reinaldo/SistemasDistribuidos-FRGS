package pagosruat;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRuat extends Remote {
    public Deuda[] Buscar(String ci) throws RemoteException;
    public Boolean Pagar(Deuda deuda) throws RemoteException;
}
