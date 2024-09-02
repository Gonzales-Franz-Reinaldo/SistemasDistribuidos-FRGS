package ahorcado;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

/**
 * @author Franz Gonzales
 */
public class Ahorcado extends UnicastRemoteObject implements IAhorcado {

    private String palabraSecreta;
    private StringBuilder estadoActual;
    private int vidas;
    private boolean juegoTerminado;
    private boolean jugadorGanador;

    private final String[] palabras = {"programacion", "java", "ahorcado", "trabajo", "computadora"};

    public Ahorcado() throws RemoteException {
        super();
    }

    @Override
    public boolean iniciar() throws RemoteException {
        palabraSecreta = seleccionarPalabraAleatoria();
        estadoActual = new StringBuilder("_".repeat(palabraSecreta.length()));
        vidas = 7; 
        juegoTerminado = false;
        jugadorGanador = false;
        System.out.println("Juego iniciado. La palabra secreta tiene " + palabraSecreta.length() + " letras.");
        return true;
    }

    @Override
    public Respuesta adivinarLetra(char letra) throws RemoteException {
        if (juegoTerminado) {
            return new Respuesta(estadoActual.toString(), vidas, juegoTerminado, jugadorGanador);
        }

        boolean letraAdivinada = false;

        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == letra && estadoActual.charAt(i) == '_') {
                estadoActual.setCharAt(i, letra);
                letraAdivinada = true;
            }
        }

        if (!letraAdivinada) {
            vidas--;
        }

        verificarEstadoDelJuego();

        return new Respuesta(estadoActual.toString(), vidas, juegoTerminado, jugadorGanador);
    }

    @Override
    public Respuesta adivinarPalabra(String palabra) throws RemoteException {
        if (juegoTerminado) {
            return new Respuesta(estadoActual.toString(), vidas, juegoTerminado, jugadorGanador);
        }

        if (palabra.equalsIgnoreCase(palabraSecreta)) {
            
            estadoActual = new StringBuilder(palabraSecreta);
            jugadorGanador = true;
            juegoTerminado = true;
        } else {
            vidas--;
            verificarEstadoDelJuego();
        }

        return new Respuesta(estadoActual.toString(), vidas, juegoTerminado, jugadorGanador);
    }

    private String seleccionarPalabraAleatoria() {
        Random random = new Random();
        return palabras[random.nextInt(palabras.length)];
    }

    private void verificarEstadoDelJuego() {
        if (estadoActual.toString().equalsIgnoreCase(palabraSecreta)) {
            juegoTerminado = true;
            jugadorGanador = true;
        } else if (vidas <= 0) {
            juegoTerminado = true;
        }
    }

    
    
    public String getPalabraSecreta() {
        return palabraSecreta;
    }

    public void getPalabraSecreta(String palabraSecreta) {
        this.palabraSecreta = palabraSecreta;
    }

    public StringBuilder getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(StringBuilder estadoActual) {
        this.estadoActual = estadoActual;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
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
    
    
    
}
