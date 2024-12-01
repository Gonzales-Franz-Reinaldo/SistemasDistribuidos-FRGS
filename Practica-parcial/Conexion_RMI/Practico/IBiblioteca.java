package Conexion_RMI.Practico;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IBiblioteca extends Remote {

    String registrarLibro(Libro libro) throws RemoteException;
    String consultarLibro(String titulo) throws RemoteException;
    List<Libro> listarLibros() throws RemoteException;
    String prestarLibro(String titulo) throws RemoteException;
    String devolverLibro(String titulo) throws RemoteException; 
} 
