/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package diplomaacademico;

import java.rmi.*;
/**
 *
 * @author Franz Gonzales
 */
public interface IDiploma extends Remote{
    public Diploma emitirDiploma(String ci, String nombres, String primerApellido, String segundoApellido, String fecha_nacimiento, String carrera) throws RemoteException;
}
