
package ejer4.tienda;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Franz Gonzales
 */
public class Inventario implements InterfazInventario{
    private List<Producto> productos;

    public Inventario() {
        productos = new ArrayList<>();
    }
    

    @Override
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    @Override
    public void mostrarInventario() {
        for(Producto producto : productos){
            System.out.println(producto);
            System.out.println("Detalles del producto: ");
            producto.mostrarDetalles();
            System.out.println();
        }
    }

    @Override
    public double calcularPrecioTotalStock() {
        double precioTotal = 0;
        for(Producto producto : productos){
            precioTotal += producto.getPrecio();
        }
        
        return precioTotal;
    }
    
}
