/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer2.biblioteca;

/**
 *
 * @author Franz Gonzales
 */
public class Libro {
    String nombre;
    String autor;
    String editorial;
    int ano;

    public Libro(String nombre, String autor, String editorial, int ano) {
        this.nombre = nombre;
        this.autor = autor;
        this.editorial = editorial;
        this.ano = ano;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getAnual() {
        return ano;
    }

    public void setAnual(int anual) {
        this.ano = anual;
    }

    @Override
    public String toString() {
        return "Libro{" + "nombre=" + nombre + ", autor=" + autor + ", editorial=" + editorial + ", ano=" + ano + '}';
    }
    
    
    
}
