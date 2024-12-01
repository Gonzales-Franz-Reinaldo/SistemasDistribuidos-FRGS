package Conexion_RMI.Practico;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca extends UnicastRemoteObject implements IBiblioteca {
    
    private List<Libro> libros;

    public Biblioteca() throws RemoteException {
        super();
        libros = new ArrayList<>();
    }

    @Override
    public String registrarLibro(Libro libro) throws RemoteException {
        
        for(Libro libro_ : libros){
            if(libro_.getTitulo().equalsIgnoreCase(libro.getTitulo())){
                return "El libro ya existe en la biblioteca";
            }
        }

        libros.add(libro);
        return "Libro registrado con éxito: " + libro.getTitulo();
    }

    @Override
    public String consultarLibro(String tiulo) throws RemoteException {

        for(Libro libro : libros){

            if(libro.getTitulo().equalsIgnoreCase(tiulo)){
                return libro.toString();
            }
        }

        return "Error: El libro no existe.";
    }

    @Override
    public List<Libro> listarLibros() throws RemoteException {
        if(libros.isEmpty()){
            return new ArrayList<>(); // Lista vacía si no hay libros
        }

        return libros;
    }

    @Override
    public String prestarLibro(String titulo) throws RemoteException {

        for(Libro libro_ : libros){
            if (libro_.getTitulo().equalsIgnoreCase(titulo)){
                if(libro_.isPrestado()){
                    return "El libro ya está prestado";
                }else{
                    libro_.setPrestado(true);
                    return "El libro '" + titulo + "' ha sido prestado.";
                }
            }
        }

        return "Error: El libro no existe.";
    }


    @Override
    public String devolverLibro(String titulo) throws RemoteException {

        for(Libro libro_ : libros){
            if (libro_.getTitulo().equalsIgnoreCase(titulo)){
                if(libro_.isPrestado()){
                    libro_.setPrestado(false);
                    return "El libro '" + titulo + "' ha sido devuelto.";
                }else{
                    return "El libro no está prestado";
                }
            }
        }

        return "Error: El libro no existe.";
    }
}
