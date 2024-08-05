
package ejer4.crudbiblioteca;

import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Franz Gonzales
 */
public class LibroDAO {
    private Connection conexion;

    public LibroDAO(Connection conexion) {
        this.conexion = conexion;
    }
    
    public void insertarLibro(Libro libro){
        String sql = "INSERT INTO libro(nombre, autor, editorial, ano, id_armario) VALUES(?, ?, ?, ?, ?)";
        
        PreparedStatement instruccion = null;
        
        try{
            instruccion = conexion.prepareStatement(sql);
            
            instruccion.setString(1, libro.getNombre());
            instruccion.setString(2, libro.getAutor());
            instruccion.setString(3, libro.getEditorial());
            instruccion.setInt(4, libro.getAno());
            instruccion.setInt(5, libro.getId_armario());
            
            instruccion.executeUpdate();
            System.out.println("Libro insertada correctamente.");
        } catch(SQLException ex){
            System.out.print(ex.getMessage());
        } finally{
            if(instruccion != null){
                try{
                    instruccion.close();
                }catch(SQLException ex){
                    System.out.print(ex.getMessage());
                }
            }
        }
    }
    
    public List<Libro> listarLibros(int id_armario){
        List<Libro> listaLibros = new ArrayList<>();
        
        String sql = "SELECT * FROM libro WHERE id_armario = ?";
        PreparedStatement instruccion = null;
        ResultSet resultado = null;
        
        try{
            instruccion = conexion.prepareStatement(sql);
            instruccion.setInt(1, id_armario);
            
            resultado = instruccion.executeQuery();
            
            while(resultado.next()){
                Libro libro = new Libro(
                    resultado.getInt("id"),
                    resultado.getString("nombre"),
                    resultado.getString("autor"),
                    resultado.getString("editorial"),
                    resultado.getInt("ano"),
                    resultado.getInt("id_armario")
                );
                
                libro.setId(resultado.getInt("id"));
                listaLibros.add(libro);
            }
        } catch(SQLException ex){
            System.out.print(ex.getMessage());
        } finally{
            if(resultado != null){
                try {
                    resultado.close();
                } catch (SQLException ex) {
                    System.out.print(ex.getMessage());
                }
            }   
            
            if(instruccion != null){
                try {
                    instruccion.close();
                } catch (SQLException ex) {
                    System.out.print(ex.getMessage());
                }
            }  
        }
        
        return listaLibros;
    }
}
