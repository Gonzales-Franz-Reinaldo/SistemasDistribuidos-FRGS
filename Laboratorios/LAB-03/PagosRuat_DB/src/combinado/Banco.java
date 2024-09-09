/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package combinado;

/**
 *
 * @author pablo
 */
public class Banco {

    private String ci;
    private String anio;
    private Impuesto impuesto;
    private String monto;
    private String funcion;
    private String parametros;

    public void dividirPedido(String pedido) {
        String[] pedidoSeparado = pedido.split(":");
        this.funcion = pedidoSeparado[0];
        this.parametros = pedidoSeparado[1];
        asignarParametros();
    }

    public void asignarParametros() {
        if (this.funcion.equalsIgnoreCase("Deuda")) {
            this.ci = this.parametros;
        } else {
            String[] parametrosSeparado = this.parametros.split(",");
            this.ci = parametrosSeparado[0];
            this.anio = parametrosSeparado[1];
            if (parametrosSeparado[1].equalsIgnoreCase("Inmueble")) {
                this.impuesto = Impuesto.Inmueble;
            } else {
                this.impuesto = Impuesto.Vehiculo;
            }
            //this.impuesto = parametrosSeparado[2];
            this.monto = parametrosSeparado[3];
        }
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

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public String getParametros() {
        return parametros;
    }

    public void setParametros(String parametros) {
        this.parametros = parametros;
    }

}
