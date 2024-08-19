package ejer2.juego.ahorcado;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class JuegoAhorcado {
    private final String palabraAdivinar;
    private final Set<Character> letrasAdivinadas = new HashSet<>();
    private int errores = 0;
    private final int maximo_errores = 7;

    public JuegoAhorcado(String palabra) {
        this.palabraAdivinar = palabra.toLowerCase();
        mostrarPista();
    }
    
    private void mostrarPista(){
        Random random = new Random();
        
        int num_letras = random.nextInt(2) + 2;
        
        Set<Character> pista = new HashSet<>();
        while(pista.size() < num_letras){
            int index = random.nextInt(palabraAdivinar.length());
            pista.add(palabraAdivinar.charAt(index));
        }
        
        letrasAdivinadas.addAll(pista);
    }

    public boolean adivinarLetra(char letra) {
        letra = Character.toLowerCase(letra);

        if (palabraAdivinar.contains(String.valueOf(letra))) {
            letrasAdivinadas.add(letra);
            return true;
        } else {
            errores++;
            return false;
        }
    }

    public boolean palabraCompletada() {
        for (char letra : palabraAdivinar.toCharArray()) {
            if (!letrasAdivinadas.contains(letra)) {
                return false;
            }
        }
        return true;
    }

    public boolean terminarJuego() {
        return errores >= maximo_errores || palabraCompletada();
    }

    public String obtenerEstadoPalabra() {
        StringBuilder estado = new StringBuilder();

        for (char letra : palabraAdivinar.toCharArray()) {
            if (letrasAdivinadas.contains(letra)) {
                estado.append(letra).append(" ");
            } else {
                estado.append("_ ");
            }
        }

        return estado.toString().trim();
    }

    public int getErrores() {
        return errores;
    }

    public int getMaximoErrores() {
        return maximo_errores;
    }

    public String getPalabraCompleta() {
        return this.palabraAdivinar;
    }
}
