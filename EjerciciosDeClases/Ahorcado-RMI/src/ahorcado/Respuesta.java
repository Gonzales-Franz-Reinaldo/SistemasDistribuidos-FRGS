package ahorcado;

import java.io.Serializable;

/**
 *
 * @author Franz Gonzales
 */
public class Respuesta implements Serializable {

    private String estado; // Cadena de guieones y letras adivinadas hasta ahora d__e_s
    private int numero_vidas;
    private boolean juegoTerminado;
    private boolean jugadorGanador;

    public Respuesta(String estado, int numero_vidas, boolean juegoTerminado, boolean jugadorGanador) {
        this.estado = estado;
        this.numero_vidas = numero_vidas;
        this.juegoTerminado = juegoTerminado;
        this.jugadorGanador = jugadorGanador;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getNumero_vidas() {
        return numero_vidas;
    }

    public void setNumero_vidas(int numero_vidas) {
        this.numero_vidas = numero_vidas;
    }

    public boolean isJuegoTerminado() {
        return juegoTerminado;
    }

    public void setJuegoTerminado(boolean juegoTerminado) {
        this.juegoTerminado = juegoTerminado;
    }

    public boolean isJugadorGanador() {
        return jugadorGanador;
    }

    public void setJugadorGanador(boolean jugadorGanador) {
        this.jugadorGanador = jugadorGanador;
    }

    @Override
    public String toString() {
        return "Respuesta{" + "estado=" + estado + ", numero_vidas=" + numero_vidas + ", juegoTerminado=" + juegoTerminado + ", jugadorGanador=" + jugadorGanador + '}';
    }

}
