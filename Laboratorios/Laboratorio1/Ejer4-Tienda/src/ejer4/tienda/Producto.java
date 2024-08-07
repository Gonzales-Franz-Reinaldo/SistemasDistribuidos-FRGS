
package ejer4.tienda;

/**
 *
 * @author Franz Gonzales
 */
public abstract class Producto {
    private String nombre;
    private double precio;
    private String marca;

    public Producto(String nombre, double precio, String marca) {
        this.nombre = nombre;
        this.precio = precio;
        this.marca = marca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
//    Metodo abstracto para mostrar detalles
    public abstract void mostrarDetalles();

    @Override
    public String toString() {
        return "Producto{" + "nombre=" + nombre + ", precio=" + precio + ", marca=" + marca + '}';
    }
    
}
