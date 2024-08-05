
package ejer4.crudbiblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Franz Gonzales
 */
public abstract class Armario {
    private int id; 
    private String codigo;
    private String tipo; 
    private int id_biblioteca;
    private List<Libro> libros;

    public Armario(String codigo, String tipo) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.libros = new ArrayList<>();
    }
    
    public Armario(int id, String codigo, String tipo, int id_biblioteca) {
        this.id = id;
        this.codigo = codigo;
        this.tipo = tipo;
        this.id_biblioteca = id_biblioteca;
        this.libros = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public int getId_biblioteca() {
        return id_biblioteca;
    }

    public void setId_biblioteca(int id_biblioteca) {
        this.id_biblioteca = id_biblioteca;
    }

    @Override
    public String toString() {
        return "Armario{" + "id=" + id + ", codigo=" + codigo + ", tipo=" + tipo + ", libros=" + libros + ", id_biblioteca=" + id_biblioteca + '}';
    }

    
}