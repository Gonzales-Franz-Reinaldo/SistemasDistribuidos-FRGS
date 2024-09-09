/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package combinado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pablo
 */
public class DeudaDAO {

    private Connection conexion;

    public DeudaDAO(String url, String usuario, String password) {
        try {
            this.conexion = DriverManager.getConnection(url, usuario, password);
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
            //Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Deuda> listar(String Ci) {
        ArrayList<Deuda> deudas = new ArrayList<Deuda>();
        String sql = "SELECT ci, anio, impuesto, monto FROM deuda WHERE ci = ?";
        try {
            PreparedStatement instruccionPersona = conexion.prepareStatement(sql);
            instruccionPersona.setString(1, Ci);
            ResultSet resultado = instruccionPersona.executeQuery();
            while (resultado.next()) {
                // Leer los resultados y crear objetos Deuda
                String ci = resultado.getString("ci");
                String anio = resultado.getString("anio");
                String impuestoStr = resultado.getString("impuesto");
                Impuesto impuesto;
                try {
                    impuesto = Impuesto.valueOf(impuestoStr);
                } catch (IllegalArgumentException e) {
                    System.err.println("Impuesto inválido: " + impuestoStr);
                    continue;
                }
                String monto = resultado.getString("monto");

                Deuda deuda = new Deuda(ci, anio, impuesto, monto);
                deudas.add(deuda);
            }

        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
            //Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return deudas;
    }

    public boolean consultarD(String Ci) {
        int ciInt = Integer.parseInt(Ci);
        boolean resultados = false;
        String sql = "SELECT observacion FROM observacion WHERE ciDeuda = ?";
        try {
            PreparedStatement instruccionPersona = conexion.prepareStatement(sql);
            instruccionPersona.setInt(1, ciInt);
            ResultSet resultado = instruccionPersona.executeQuery();
            if (resultado.next()) {
                int observacion = resultado.getInt("observacion");
                if (observacion == 1) {
                    resultados = true;
                    return resultados;
                }
            }

        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
            //Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultados;
    }

    public void eliminarDeuda(String ci, String anio, String impuestos, String monto) {
        String sqlDeuda = "DELETE FROM deuda WHERE ci = ? AND anio = ? AND impuesto = ? AND monto = ?";
        try {
            PreparedStatement instruccionDeuda = conexion.prepareStatement(sqlDeuda);
            instruccionDeuda.setString(1, ci);
            instruccionDeuda.setString(2, anio);
            instruccionDeuda.setString(3, impuestos);
            instruccionDeuda.setString(4, monto);
            int filasAfectadas = instruccionDeuda.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar la deuda: " + ex.getMessage());
        }
    }


}
