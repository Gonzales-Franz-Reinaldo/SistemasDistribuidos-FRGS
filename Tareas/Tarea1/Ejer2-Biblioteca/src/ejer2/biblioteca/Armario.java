/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer2.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Franz Gonzales
 */
public abstract class Armario {
    
    private String codigo;
    private List<Libro> libros; 

    public Armario(String codigo) {
        this.codigo = codigo;
        this.libros = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public void agregarLibro(Libro libro){
        libros.add(libro);
    }

    @Override
    public String toString() {
        return "Armario{" + "codigo=" + codigo + ", libros=" + libros + '}';
    }
    
    
    
}
