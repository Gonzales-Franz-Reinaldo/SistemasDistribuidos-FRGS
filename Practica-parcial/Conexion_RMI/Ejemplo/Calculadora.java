package Conexion_RMI.Ejemplo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// Implementación de la interfaz remota
public class Calculadora extends UnicastRemoteObject implements ICalculadora{

    public Calculadora() throws RemoteException {
        super();
    }

    @Override
    public int sumar(int a, int b) throws RemoteException {
        return a + b;
    }

    @Override  
    public int restar(int a, int b) throws RemoteException {
        return a - b;
    }

    @Override
    public int multiplicar(int a, int b) throws RemoteException {
        return a * b;
    }

    @Override
    public int dividir(int a, int b) throws RemoteException {
        return a / b;
    }
}