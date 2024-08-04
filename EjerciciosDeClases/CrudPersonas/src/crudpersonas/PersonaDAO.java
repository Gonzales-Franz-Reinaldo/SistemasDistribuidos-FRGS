
package crudpersonas;

//import com.sun.jdi.connect.spi.Connection;
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
public class PersonaDAO {

    private Connection conexion;
    String url;
    String user;
    String password;
    String driver;

    public PersonaDAO(String url, String user, String password, String driver) {
        this.url = url;
        this.user = user;
        this.password = password;
        this.driver = driver;
    }

    
    public Connection conectar(){
        try{
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Se conecto a la BD.");
            
        }catch(ClassNotFoundException | SQLException ex) {
            System.out.println("No se conecto a la BD.");
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return conexion;
    }
    
    public void desconectar(){
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    public void insertar(Persona persona){
        String sql = "INSERT INTO persona(nombre, apellido, edad, nro_carnet) VALUES(?,?,?,?)";
        PreparedStatement instruccion = null;
        try{
            
            instruccion = conexion.prepareStatement(sql);
            
            instruccion.setString(1, persona.getNombre());
            instruccion.setString(2, persona.getApellido());
            instruccion.setInt(3, persona.getEdad());
            instruccion.setString(4, persona.getNro_carnet());
            
            instruccion.execute();
        }catch(SQLException ex){
            System.out.print(ex.getMessage());
        }finally{
            if(instruccion != null){
                try{
                    instruccion.close();
                }catch(SQLException e){
                    System.out.print(e.getMessage());
                }
            }
        }
    }
    
    public List<Persona> listar(){
        List<Persona> auxiliar = new ArrayList<>();
        
        String sql = "SELECT * FROM persona";
        Statement instruccion = null;
        ResultSet resultado = null;
        
        try{
            instruccion = conexion.createStatement();
            resultado = instruccion.executeQuery(sql);
            
            while(resultado.next()){
                Persona pers = new Persona(
                resultado.getInt("id"), 
                resultado.getString("nombre"), 
                resultado.getString("apellido"), 
                resultado.getInt("edad"), 
                resultado.getString("nro_carnet")
                );
                
                auxiliar.add(pers);
            }
            
        }catch(SQLException ex){
            System.out.print(ex.getMessage());
        }finally{
            if(resultado != null){
                try{
                    resultado.close();
                } catch (SQLException e){
                    System.out.print(e.getMessage());
                }
            }
            
            if (instruccion != null) {
                try {
                    instruccion.close();
                } catch (SQLException e) {
                    System.out.print(e.getMessage());
                }
            }
            
        }
        
        return auxiliar;
    }
    
    
    public void editarPersona(Persona persona){
        String sql = "UPDATE persona SET nombre = ?, apellido = ?,  edad = ?, nro_carnet = ? WHERE id = ?";
        PreparedStatement instruccion = null;
        
        try{
            instruccion = conexion.prepareStatement(sql);
            
            instruccion.setString(1, persona.getNombre());
            instruccion.setString(2, persona.getApellido());
            instruccion.setInt(3, persona.getEdad());
            instruccion.setString(4, persona.getNro_carnet());
            
            instruccion.setInt(5, persona.getId());
            
            int elemento_fila = instruccion.executeUpdate();
            
            if(elemento_fila > 0){
                System.out.println("Persona actualizada correctamente.");
            }else{
                System.out.println("No se encontro una persona con el ID especificado.");
            }
        } catch(SQLException e){
            System.out.print(e.getMessage());
        } finally{
            if(instruccion != null){
                try{
                    instruccion.close();
                } catch(SQLException e){
                    System.out.print(e.getMessage());
                }
            }
        }
    }
    
    public void eliminarPersona(int id){
        String sql = "DELETE FROM persona WHERE id = ?";
        PreparedStatement instruccion = null;
        try{
           instruccion = conexion.prepareStatement(sql);
           instruccion.setInt(1, id);
           int elemento_fila = instruccion.executeUpdate();
           
           if(elemento_fila > 0){
               System.out.println("Persona eliminada correctamente.");
           }else{
               System.out.println("No se encontró una persona  con el ID: " + id + "especicado.");
           }
        } catch(SQLException e){
            System.out.print(e.getMessage());
        } finally{
            if(instruccion != null){
                try{
                    instruccion.close();
                } catch(SQLException e){
                    System.out.print(e.getMessage());
                }
            }
        }
    }

}
