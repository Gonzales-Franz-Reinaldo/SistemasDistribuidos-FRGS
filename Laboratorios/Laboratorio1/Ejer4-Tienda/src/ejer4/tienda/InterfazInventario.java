
package ejer4.tienda;

/**
 *
 * @author Franz Gonzales
 */
public interface InterfazInventario {
    
    public void agregarProducto(Producto producto);
    public void mostrarInventario();
    public double calcularPrecioTotalStock();
}
