
package crud.tienda;

import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Franz Gonzales
 */
public class ProductoDAO {
    private Connection conexion;

    public ProductoDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public void agregarProductoInventario(Producto producto){
        String sql = "INSERT INTO productos (nombre, precio, tipo, cantidad, marca) VALUES(?, ?, ?, ?, ?)";
        
        try{
            PreparedStatement instrucion = conexion.prepareStatement(sql);
            
            instrucion.setString(1, producto.getNombre());
            instrucion.setDouble(2, producto.getPrecio());
            instrucion.setString(3, producto.getTipo());
            instrucion.setInt(4, producto.getCantidad());
            instrucion.setString(5, producto.getMarca());
            
            instrucion.executeUpdate();
            
        }catch(SQLException ex){
            System.out.print(ex.getMessage());
        }
    }
    
    
    public List<Producto> mostrarInventario(){
        List<Producto> listaProductos = new ArrayList<>();
        
        String sql = "SELECT * FROM productos";
        
        try{
            Statement instruccion = conexion.createStatement();
            ResultSet resultado = instruccion.executeQuery(sql);
            
            while(resultado.next()){
                Producto producto = null;
                String  tipo = resultado.getString("tipo");
                
                if(tipo.equals("Telefono")){
                    producto = new Telefono(
                        resultado.getInt("id"),
                        resultado.getString("nombre"),
                        resultado.getDouble("precio"),
                        tipo,
                        resultado.getInt("cantidad"),
                        resultado.getString("marca")
                        );
                }else if(tipo.equals("Laptop")){
                    producto = new Laptop(
                        resultado.getInt("id"),
                        resultado.getString("nombre"),
                        resultado.getDouble("precio"),
                        tipo,
                        resultado.getInt("cantidad"),
                        resultado.getString("marca") 
                    );
                }
                        
                if (producto != null) {
                    listaProductos.add(producto);
                }
            }
        } catch(SQLException ex){
            System.out.print(ex.getMessage());
        }
        
        return listaProductos;
    }
    
    
    public double calcularPrecioTotalStock(){
        String sql = "SELECT SUM(precio * cantidad) AS precio_total FROM productos";
        double precio_total = 0;
        try{
            PreparedStatement instruccion = conexion.prepareStatement(sql);
            ResultSet resultado = instruccion.executeQuery();
            
            if(resultado.next()){
                precio_total = resultado.getDouble("precio_total");
            }
        } catch(SQLException ex){
            System.out.print(ex.getMessage());
        }
        
        return precio_total;
    }
    
}
