package Conexion_RMI.Practico;

import java.io.Serializable;

public class Libro implements Serializable{
    
    private static final long serialVersionUID = 1L; // Versión de serialización
    private String titulo;
    private String autor;
    private String editorial;
    private int anio;
    private boolean prestado;

    public Libro(String titulo, String autor, String editorial, int anio) {
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.anio = anio;
        this.prestado = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    @Override
    public String toString() {
        return "Titulo: " + titulo + "\nAutor: " + autor + "\nEditorial: " + editorial + "\nAño: " + anio + "\nEstado: " + (prestado ? "Prestado" : "Disponible");
    }

}
