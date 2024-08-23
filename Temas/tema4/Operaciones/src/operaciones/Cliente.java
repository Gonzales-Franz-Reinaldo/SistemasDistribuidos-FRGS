
package operaciones;
import java.net.MalformedURLException;
import java.nio.channels.AlreadyBoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.rmi.*;
/**
 *
 * @author Franz Gonzales
 */
public class Cliente {
    
    public static void main(String[] args) {
        
        try {
            IOperaciones operacion;
            operacion = (IOperaciones) Naming.lookup("rmi://localhost/Operaciones");
            System.out.println (operacion.suma(3, 4));
        } catch (RemoteException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch(AlreadyBoundException ex){
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch(MalformedURLException ex){
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
