
package operaciones;
import java.rmi.*;
/**
 *
 * @author Franz Gonzales
 */
public class Operacion  extends UnicastRemoteObject  implements IOperaciones{
    
    public Operacion() throws RemoteException{
        super();
    }

    @Override
    public int suma(int a, int b) throws RemoteException{
        return a + b;
    }

    @Override
    public int resta(int a, int b) throws RemoteException{
        return a - b;
    }
    
    @Override
    public int multiplicacion(int a, int b) throws RemoteException{
        return a * b;
    }
    
    @Override
    public int division(int a, int b) throws RemoteException{
        return a / b;
    }
    
    
}
