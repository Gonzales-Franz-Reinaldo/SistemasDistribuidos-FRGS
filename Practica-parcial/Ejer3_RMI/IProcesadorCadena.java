package Ejer3_RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IProcesadorCadena extends Remote{
    boolean introducirCadena(String cadena) throws RemoteException;
    String invertirCadena() throws RemoteException;
    String aumentarEspacios(int cantidad) throws RemoteException;
    String aumentar(String cadena) throws RemoteException;
}
