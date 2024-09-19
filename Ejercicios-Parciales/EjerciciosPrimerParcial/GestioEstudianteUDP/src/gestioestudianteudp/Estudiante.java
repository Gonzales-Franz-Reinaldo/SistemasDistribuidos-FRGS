/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestioestudianteudp;

/**
 *
 * @author Franz Gonzales
 */
public class Estudiante {
    String ci;
    String nombre;
    String carrera;

    public Estudiante(String ci, String nombre, String carrera) {
        this.ci = ci;
        this.nombre = nombre;
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return "CI: " + ci + ", Nombre: " + nombre + ", Carrera: " + carrera;
    }
}