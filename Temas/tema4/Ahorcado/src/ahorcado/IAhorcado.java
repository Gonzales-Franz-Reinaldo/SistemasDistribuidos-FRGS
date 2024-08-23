
package ahorcado;

import java.rmi.RemoteException;
import java.rmi.*;

/**
 *
 * @author Franz Gonzales
 */
public interface IAhorcado extends Remote{
    public boolean iniciar() throws RemoteException;
    public Respuesta adivinarLetra(char letra) throws RemoteException;
    public Respuesta adivinarPalabra(String palabra)throws RemoteException;
}
