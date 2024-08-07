
package crud.tienda;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.*;

/**
 *
 * @author Franz Gonzales
 */
public class Conexion {
    private Connection conexion;
    private String url;
    private String db;
    private String user;
    private String password;
    private String driver;

    public Conexion(String url, String db, String user, String password, String driver) {
        this.url = url;
        this.db = db;
        this.user = user;
        this.password = password;
        this.driver = driver;
    }
    
    public Connection conectar(){
        try{
            Class.forName(driver);
            conexion = DriverManager.getConnection(url + db, user, password);
            System.out.println("Se conecto a la DB: " + db);
        } catch(ClassNotFoundException | SQLException ex){
            System.out.println("No se pudo conectar a la DB: " + db);
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return conexion;
    }
    
    public void desconectar() throws SQLException{
        try{
            conexion.close();
            System.out.println("Se desconecto de la DB.");
        }catch(SQLException ex){
            System.out.print(ex.getMessage());
        }
    }
}
