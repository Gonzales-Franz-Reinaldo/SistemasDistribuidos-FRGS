
package ejer4.crudbiblioteca;

import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Franz Gonzales
 */
public class BibliotecaDAO {
    private Connection conexion;
    
    public BibliotecaDAO(Connection conexion){
        this.conexion = conexion;
    }
    
    public void insertarBiblioteca(Biblioteca biblioteca){
        String sql = "INSERT INTO biblioteca(nombre, tamano) VALUES(?, ?)";
        PreparedStatement instruccion = null;
        
        try{
            instruccion = conexion.prepareStatement(sql);
            
            instruccion.setString(1, biblioteca.getNombre());
            instruccion.setInt(2, biblioteca.getTamano());
            
            instruccion.executeUpdate();
            System.out.println("Biblioteca insertada correctamente.");
        } catch(SQLException e){
            System.out.print(e.getMessage());
        } finally{
            if(instruccion !=  null){
                try {
                    instruccion.close();
                } catch (SQLException ex) {
                    System.out.print(ex.getMessage());
                }
            }
        }
    }
    
    public List<Biblioteca> listarBibliotecas(){
        List<Biblioteca> bibliotecas = new ArrayList<>();
        
        String sql = "SELECT * FROM biblioteca";
        Statement instruccion = null;
        ResultSet resultado = null;
        
        try{
            instruccion = conexion.createStatement();
            resultado = instruccion.executeQuery(sql);
            
            while(resultado.next()){
                Biblioteca biblio = new Biblioteca(
                    resultado.getInt("id"),
                    resultado.getString("nombre"),
                    resultado.getInt("tamano")
                );
                
                bibliotecas.add(biblio);
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
        
        return bibliotecas;
    }
}
