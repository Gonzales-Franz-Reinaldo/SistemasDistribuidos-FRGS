
package ejer4.crudbiblioteca;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;


/**
 *
 * @author Franz Gonzales
 */
public class ArmarioDAO {
    private Connection conexion;

    public ArmarioDAO(Connection conexion) {
        this.conexion = conexion;
    }
    
    public void insertarArmario(Armario armario){
        String sql = "INSERT INTO armario (codigo, tipo, id_biblioteca) VALUES(?, ?, ?)";
        
        PreparedStatement instruccion = null;
        
        try{
            instruccion = conexion.prepareStatement(sql);
            
            instruccion.setString(1, armario.getCodigo());
            instruccion.setString(2, armario.getTipo());
            instruccion.setInt(3, armario.getId_biblioteca());
            
            instruccion.executeUpdate();
            System.out.println("Armador insertada correctamente.");
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
    
    
    public List<Armario> listarArmario(int id_biblioteca){
        List<Armario> listaArmarios = new ArrayList<>();
        
        String sql = "SELECT * FROM armario WHERE id_biblioteca = ?";
        PreparedStatement instruccion = null;
        ResultSet resultado = null;
        
        try{
            instruccion = conexion.prepareStatement(sql);
            instruccion.setInt(1, id_biblioteca);
            
            resultado = instruccion.executeQuery();
            
            while(resultado.next()){
                Armario armario;
                if(resultado.getString("tipo").equals("Madera")){
                    armario = new ArmarioMadera(
                        resultado.getInt("id"),
                        resultado.getString("codigo"),
                        resultado.getString("tipo"),
                        resultado.getInt("id_biblioteca")
                    );
                }else{
                    armario = new ArmarioMetalico(
                        resultado.getInt("id"),
                        resultado.getString("codigo"),
                        resultado.getString("tipo"),
                        resultado.getInt("id_biblioteca")
                    );
                }
                armario.setId(resultado.getInt("id"));
                listaArmarios.add(armario);
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
        
        return listaArmarios;
    }
}
