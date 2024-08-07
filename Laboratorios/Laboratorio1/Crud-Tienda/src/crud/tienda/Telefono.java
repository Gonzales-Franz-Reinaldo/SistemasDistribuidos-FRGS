
package crud.tienda;

/**
 *
 * @author Franz Gonzales
 */
public class Telefono extends Producto{
    private String modelo; 
    private String almacenamiento;

    public Telefono(int id, String nombre, double precio, String tipo, int cantidad, String marca) {
        super(id, nombre, precio, "Telefono", cantidad, marca);
    }
    
    public Telefono(String nombre, double precio, int cantidad, String marca) {
        super(nombre, precio, "Telefono", cantidad, marca);
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(String almacenamiento) {
        this.almacenamiento = almacenamiento;
    }
    
    @Override
    public String detallesProducto() {
        return "TelefonoMovil{" +
                ", modelo='" + modelo + '\'' +
                ", almacenamiento='" + almacenamiento + '\'' +
                '}';
    }

    @Override
    public String toString() {
        return "Telefono{" + super.toString() + "}";
    }

    
}
