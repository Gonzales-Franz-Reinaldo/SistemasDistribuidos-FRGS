/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejer3.juegotresraya;

import java.util.Scanner;

/**
 *
 * @author Franz Gonzales
 */
public class Ejer3JuegoTresRaya {

    public static void main(String[] args) {
        // Instanciamos un objeto del juego
        TresEnRaya juegoTresRaya = new TresEnRaya();
        
       juegoTresRaya.crearLlenarTablero();
       juegoTresRaya.mostrarTablero();
        
       do{
           System.out.println();
           juegoTresRaya.movimientoJugador();
           juegoTresRaya.mostrarTablero();
           boolean resultado = juegoTresRaya.ganador('O');
           if(resultado == true){
               System.out.println("\nGanador Jugador 1.");
               break;
           }
           
           resultado = juegoTresRaya.celcaVacia();
           if(resultado == false){
               System.out.println("\nHubo un empate.");
               break;
           }

           System.out.println("\nJugador 2, La compu");
           juegoTresRaya.movimientoComputadora();
           juegoTresRaya.mostrarTablero();
           resultado = juegoTresRaya.ganador('X');
           if(resultado == true){
               System.out.println("\nGanador Jugador 2.");
               break;
           }
           
       } while(true);
    }
}
