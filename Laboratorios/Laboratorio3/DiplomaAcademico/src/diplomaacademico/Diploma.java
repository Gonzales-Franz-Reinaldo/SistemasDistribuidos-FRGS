/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package diplomaacademico;

import java.rmi.RemoteException;

/**
 *
 * @author Franz Gonzales
 */
public class Diploma implements IDiploma{
    
    private String nombreCompleto;
    private String fecha;
    private String mensaje;

    public Diploma() {
        this.nombreCompleto = "";
        this.fecha = "";
        this.mensaje = "";
    }

    @Override
    public Diploma emitirDiploma(String ci, String nombres, String primerApellido, String segundoApellido, String fecha_nacimiento, String carrera) throws RemoteException {
        return new Diploma();
    }
    
}
