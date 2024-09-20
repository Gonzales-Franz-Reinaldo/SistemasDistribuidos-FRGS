/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cajeroautomaticormi;

import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author Franz Gonzales
 */
// Interfaz remota para la emisión de diplomas
public interface IUniversidad extends Remote {
    public Diploma emitirDiploma(String ci, String nombres, String primerApellido, String segundoApellido, String fechaNacimiento, String carrera) throws RemoteException;
}
