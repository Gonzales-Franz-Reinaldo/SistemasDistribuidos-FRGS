/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pagos_ruat;

import java.io.Serializable;

/**
 *
 * @author pablo
 */
public class Deuda implements Serializable{
    private String anio;
    private Impuesto impuesto;
    private String monto;
    private String ci;

    public Deuda(String ci, String anio, Impuesto impuesto, String monto) {
        this.ci = ci;
        this.anio = anio;
        this.impuesto = impuesto;
        this.monto = monto;
        
    }
    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public Impuesto getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Impuesto impuesto) {
        this.impuesto = impuesto;
    }


    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Deuda{" + "anio=" + anio + ", impuesto=" + impuesto + ", monto=" + monto + ", ci=" + ci + '}';
    }
    
    
    
}