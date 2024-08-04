
package ejer2.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Franz Gonzales
 */
public class BibliotecaFacultad {
    public String nombre;
    public int metros_cuadrados;
    public List<Armario> armarios;

    public BibliotecaFacultad(String nombre, int metros_cuadrados) {
        this.nombre = nombre;
        this.metros_cuadrados = metros_cuadrados;
        armarios = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMetros_cuadrados() {
        return metros_cuadrados;
    }

    public void setMetros_cuadrados(int metros_cuadrados) {
        this.metros_cuadrados = metros_cuadrados;
    }

    public List<Armario> getArmarios() {
        return armarios;
    }

    public void setArmarios(List<Armario> armarios) {
        this.armarios = armarios;
    }

    
    public void agregarArmario(Armario armario){
        armarios.add(armario);
    }

    @Override
    public String toString() {
        return "BibliotecaFacultad{" + "nombre=" + nombre + ", metros_cuadrados=" + metros_cuadrados + ", armarios=" + armarios + '}';
    }
    
    
}
