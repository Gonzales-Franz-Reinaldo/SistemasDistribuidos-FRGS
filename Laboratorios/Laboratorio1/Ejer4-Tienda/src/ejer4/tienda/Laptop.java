
package ejer4.tienda;

/**
 *
 * @author Franz Gonzales
 */
public class Laptop extends Producto{
    private String procesador;
    private int ram;
    private String tipoMemoria;

    public Laptop(String nombre, double precio, String marca, String procesador, int ram, String tipoMemoria) {
        super(nombre, precio, marca);
        this.procesador = procesador;
        this.ram = ram;
        this.tipoMemoria = tipoMemoria;
    }
    

    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles de la Laptop:");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Precio: " + getPrecio());
        System.out.println("Marca: " + getMarca());
        System.out.println("Procesador: " + procesador);
        System.out.println("RAM: " + ram + " GB");
        System.out.println("Tipo de memoria: " + tipoMemoria + " GB");
    }
    
}
