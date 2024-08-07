
package ejer4.tienda;

/**
 *
 * @author Franz Gonzales
 */
public class Telefono extends Producto{
    private String modelo;
    private int ram;
    private int almacenamiento;

    public Telefono(String nombre, double precio, String marca, String modelo, int ram, int almacenamiento) {
        super(nombre, precio, marca);
        this.modelo = modelo;
        this.ram = ram;
        this.almacenamiento = almacenamiento;
    }


    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles del Telefono:");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Marca: " + getMarca());
        System.out.println("Precio: " + getPrecio());
        System.out.println("Modelo: " + modelo);
        System.out.println("RAM: " + ram + " GB");
        System.out.println("Almacenamiento: " + almacenamiento + " GB");
    }

}
