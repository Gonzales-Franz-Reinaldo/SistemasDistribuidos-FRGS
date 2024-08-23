
package operaciones;
import java.rmi.*;

/**
 *
 * @author Franz Gonzales
 */
public interface IOperaciones extends Remote{
    
    public int suma(int a, int b) throws RemoteException;
    public int resta(int a, int b) throws RemoteException;
    public int multiplicacion(int a, int b)throws RemoteException;
    public int division(int a, int b) throws RemoteException;
    
}
