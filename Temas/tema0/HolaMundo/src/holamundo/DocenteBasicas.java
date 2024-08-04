/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package holamundo;

/**
 *
 * @author Franz Gonzales
 */
public class DocenteBasicas extends ADocente{

    public DocenteBasicas(String nombre, String apellidos) {
        super(nombre, apellidos);
    }

    @Override
    public void addMateria(IMateria materia) {
        materias.add(materia);
    }
    
    
}
