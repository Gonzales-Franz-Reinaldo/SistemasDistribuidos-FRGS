package Conexion_RMI.Ejemplo;

import java.rmi.Remote;
import java.rmi.RemoteException;


// Interfaz remota que define los métodos disponibles
public interface ICalculadora extends Remote{

    int sumar(int a, int b) throws RemoteException;
    int restar(int a, int b) throws RemoteException;
    int multiplicar(int a, int b) throws RemoteException;
    int dividir(int a, int b) throws RemoteException;
}
