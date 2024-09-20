/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pkg1examenparcial;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
/**
 *
 * @author Franz Gonzales
 */
public interface ICuenta extends Remote{
    public ArrayList<Cuenta>consultarCuenta(String ci, String nombres, String apellidos) throws RemoteException;
    public Boolean retenerMonto(Cuenta cuenta, double monto, String glosa) throws RemoteException;
    
}
