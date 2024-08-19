
package ejer2.juego.ahorcado;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Franz Gonzales
 */
public class HiloCliente extends Thread{
    private final Socket client;
    private final JuegoAhorcado juego;
    
    public HiloCliente(Socket client, String palabra){
        this.client = client;
        this.juego = new JuegoAhorcado(palabra);
    }
    
    @Override
    public void run(){
        try(
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintStream toClient = new PrintStream( client.getOutputStream())
        ){
            
            toClient.println("Bienvenido al juego del Ahorcado");
            toClient.println("Adivina la palabra: " + juego.obtenerEstadoPalabra());
            
            while(!juego.terminarJuego()){
                toClient.println("Introduce una letra: ");
                String input = fromClient.readLine();
                
                if(input == null || input.length() != 1){
                    toClient.println("Debe introducir sola una letra.");
                    continue;
                }
                
                char letra = input.charAt(0);
                
                if(juego.adivinarLetra(letra)){
                    toClient.println("Correcto!");
                }else{
                    toClient.println("Letra incorrecta. Error: " + juego.getErrores() + " - " + juego.getMaximoErrores());
                }
                
                toClient.println("Estado actual: " + juego.obtenerEstadoPalabra());
                
                if(juego.terminarJuego()){
                    if(juego.palabraCompletada()){
                        toClient.println("Usted Ganó.. La palabra a adivinar fue: " + juego.getPalabraCompleta());
                    }else{
                        toClient.println("Usteded perdió.!. La palbra a adivinar es: " + juego.getPalabraCompleta());
                    }
                }
            }
            
            client.close();
            
        } catch (IOException ex) {
            System.out.println("Error en la comunicación con el cliente: " + ex.getMessage());
        }
    }
}
