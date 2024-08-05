
package ejer4.crudbiblioteca;


import java.sql.Connection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Franz Gonzales
 */
public class Conexion {
    private Connection conexion;
    String url;
    String user;
    String password;
    String driver;

    public Conexion(String url, String user, String password, String driver) {
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
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return conexion;
    }
    
    public void desconectar() throws SQLException{
        try {
            conexion.close();
            System.out.println("Se desconectó de la BD.");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
