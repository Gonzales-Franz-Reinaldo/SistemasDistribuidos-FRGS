
package crud.tienda;

/**
 *
 * @author Franz Gonzales
 */
public abstract class Producto {
    private int id;
    private String nombre;
    private double precio;
    private String tipo;
    private int cantidad;
    private String marca; 

    public Producto(int id, String nombre, double precio, String tipo, int cantidad, String marca) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.marca = marca;
    }
    
    public Producto(String nombre, double precio, String tipo, int cantidad, String marca) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.marca = marca;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }


    public abstract String detallesProducto();

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", tipo=" + tipo + ", cantidad=" + cantidad + ", marca=" + marca + '}';
    }
    
    
}
