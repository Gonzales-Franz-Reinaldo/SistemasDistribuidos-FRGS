package ahorcado;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.Naming;

/**
 *
 * @author Franz Gonzales
 */
public class Servidor {

    public static void main(String[] args) throws RemoteException, AlreadyBoundException, MalformedURLException {

        try {
            Ahorcado ahorcado = new Ahorcado();
            LocateRegistry.createRegistry(1099);
            Naming.bind("JuegoAhorcado", ahorcado);
            
            System.out.println("Servidor de Ahorcado listo.");
            
        } catch (RemoteException | MalformedURLException | AlreadyBoundException e) {
            System.err.print(e.getMessage());
        }

    }
}
