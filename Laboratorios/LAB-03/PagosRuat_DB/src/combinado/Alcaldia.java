/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package combinado;

/**
 *
 * @author pablo
 */
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author sergio
 */
public class Alcaldia extends UnicastRemoteObject {
    protected Alcaldia() throws RemoteException {
        super();
    }
    public Boolean Consulta(String ci) throws RemoteException {
        String url = "jdbc:mysql://localhost:3306/deuda?zeroDateTimeBehavior=CONVERT_TO_NULL";
        String usuario = "root";
        String password = "";
        DeudaDAO deudaDAO = new DeudaDAO(url, usuario, password);
        boolean observaciones = deudaDAO.consultarD(ci);
        return observaciones;
    }

}