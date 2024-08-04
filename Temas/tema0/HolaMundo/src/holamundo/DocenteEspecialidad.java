/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package holamundo;

import java.util.ArrayList;

/**
 *
 * @author Franz Gonzales
 */
public class DocenteEspecialidad extends ADocente{
    
    Especialidad especialidad;

    public DocenteEspecialidad(String nombre, String apellidos, Especialidad especialidad) {
        super(nombre, apellidos);
        this.especialidad = especialidad;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    
    @Override
    public void addMateria(IMateria materia) {
        materias.add(materia);
    }

    @Override
    public String toString() {
        return "DocenteEspecialidad{" + "especialidad=" + especialidad + '}';
    }
    
    
    
}
