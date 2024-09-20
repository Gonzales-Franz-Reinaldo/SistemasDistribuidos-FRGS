/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg1examenparcial;
import java.io.Serializable;

import java.rmi.RemoteException;
import java.rmi.server.RemoteRef;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Franz Gonzales
 */
public class Cuenta extends UnicastRemoteObject implements ICuenta{
    private Banco banco;
    private String nroCuenta;
    private String ci;
    private String nombres;
    private String apellidos;
    private double saldo;
    
    private List<Cuenta> cuentas;

    public Cuenta(Banco banco, String nroCuenta, String ci, String nombres, String apellidos, double saldo) throws RemoteException {
        super();
        this.banco = banco;
        this.nroCuenta = nroCuenta;
        this.ci = ci;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.saldo = saldo;
    }

    public Banco getBanco() {
        return banco;
    }

    public String getNroCuenta() {
        return nroCuenta;
    }

    public String getCi() {
        return ci;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public void setNroCuenta(String nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public ArrayList<Cuenta> consultarCuenta(String ci, String nombres, String apellidos) throws RemoteException {
        List<Cuenta> resultado = new ArrayList<>();
        for(Cuenta cuenta : cuentas){
            if(cuenta.ci.equals(ci) || cuenta.nombres.equals(nombres) || cuenta.apellidos.equals(apellidos)){
                resultado.add(cuenta);
            }
        }
        
//        return resultado.toArray(new Cuenta[resultado.size()]);
        return (ArrayList<Cuenta>) resultado;
    }

    @Override
    public Boolean retenerMonto(Cuenta cuenta, double monto, String glosa) throws RemoteException {
        double montoInicio = cuenta.getSaldo();
        cuenta.setSaldo(montoInicio - monto);
        return true;
    }
}
