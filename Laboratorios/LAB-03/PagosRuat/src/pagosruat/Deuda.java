/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pagosruat;
import java.io.Serializable;

/**
 *
 * @author Franz Gonzales
 */
public class Deuda implements Serializable {
    private String ci;
    private int anio;
    private Impuesto impuesto;
    private double monto;

    public Deuda(String ci, int anio, Impuesto impuesto, double monto) {
        this.ci = ci;
        this.anio = anio;
        this.impuesto = impuesto;
        this.monto = monto;
    }

    public String getCi() {
        return ci;
    }

    public int getAnio() {
        return anio;
    }

    public Impuesto getImpuesto() {
        return impuesto;
    }

    public double getMonto() {
        return monto;
    }

    @Override
    public String toString() {
        return anio + "," + impuesto + "," + monto;
    }
}