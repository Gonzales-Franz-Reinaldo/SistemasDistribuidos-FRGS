
package ejer4.crudbiblioteca;

/**
 *
 * @author Franz Gonzales
 */
public class Libro {
    int id;
    String nombre;
    String autor;
    String editorial;
    int ano;
    int id_armario;

    public Libro(int id, String nombre, String autor, String editorial, int ano, int id_armario) {
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
        this.editorial = editorial;
        this.ano = ano;
        this.id_armario = id_armario;
    }

    public Libro(String nombre, String autor, String editorial, int ano, int id_armario) {
        this.nombre = nombre;
        this.autor = autor;
        this.editorial = editorial;
        this.ano = ano;
        this.id_armario = id_armario;
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

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getId_armario() {
        return id_armario;
    }

    public void setId_armario(int id_armario) {
        this.id_armario = id_armario;
    }

    @Override
    public String toString() {
        return "Libro{" + "id=" + id + ", nombre=" + nombre + ", autor=" + autor + ", editorial=" + editorial + ", ano=" + ano + ", id_armario=" + id_armario + '}';
    }

    
}

