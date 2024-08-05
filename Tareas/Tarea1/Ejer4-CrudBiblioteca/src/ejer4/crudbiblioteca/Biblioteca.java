
package ejer4.crudbiblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Franz Gonzales
 */
public class Biblioteca {
    public int id;
    public String nombre;
    public int tamano;
    public List<Armario> armarios;
    
    public Biblioteca(int id, String nombre, int tamano) {
        this.id = id;
        this.nombre = nombre;
        this.tamano = tamano;
        armarios = new ArrayList<>();
    }

    public Biblioteca(String nombre, int tamano) {
        this.nombre = nombre;
        this.tamano = tamano;
        armarios = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public List<Armario> getArmarios() {
        return armarios;
    }

    public void setArmarios(List<Armario> armarios) {
        this.armarios = armarios;
    }

    @Override
    public String toString() {
        return "Biblioteca{" + "id=" + id + ", nombre=" + nombre + ", tamano=" + tamano + ", armarios=" + armarios + '}';
    }
    
    public void agregarArmario(Armario armario){
        armarios.add(armario);
    }
    
}
