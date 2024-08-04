/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer2.juegotresraya;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Franz Gonzales
 */
public class TresEnRaya {
    //    Propiedades
    private char[][] tablero;
    
    //    Metodos
    public void crearLlenarTablero(){
        tablero = new char[3][3];
        for(int i=0; i < tablero.length; i++){
            for(int j=0; j < tablero.length; j++){
                tablero[i][j] = '-';
            }
        }
    }
    
    public void mostrarTablero(){
        for(int i=0; i < tablero.length; i++){
            for(int j=0; j < tablero.length; j++){
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public void movimientoJugador() {
        Scanner posicion = new Scanner(System.in);
        int fila, columna;
        boolean movimientoValido = false;

        while (!movimientoValido) {
            System.out.println("\nJugador 1:");

            do {
                System.out.print("Elija una posición de la fila (1-3): ");
                fila = posicion.nextInt();
                if (fila < 1 || fila > 3) {
                    System.out.println("Número de fila incorrecto. Debe ser 1, 2 o 3.");
                }
            } while (fila < 1 || fila > 3);

            do {
                System.out.print("Elija una posición de la columna (1-3): ");
                columna = posicion.nextInt();
                if (columna < 1 || columna > 3) {
                    System.out.println("Número de columna incorrecto. Debe ser 1, 2 o 3.");
                }
            } while (columna < 1 || columna > 3);

            if (tablero[fila - 1][columna - 1] != '-') {
                System.out.println("La posición ya está marcada. Elija otra posición.");
            } else {
                tablero[fila - 1][columna - 1] = 'O';
                movimientoValido = true;
            }
        }
    }
    
    public void movimientoComputadora(){
        int fila, columna;
        
        do{
            do{
                fila = ThreadLocalRandom.current().nextInt(1, 4);
            }while(fila < 1 || fila > 3);
            
            do{
                columna = ThreadLocalRandom.current().nextInt(1, 4);
            }while(columna < 1 || columna > 3);
            
        }while(tablero[fila-1][columna-1] != '-');
        
        tablero[fila-1][columna-1] = 'X';
    }
    
    public boolean ganador(char marcador) {
        // Verificar filas y columnas
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == marcador && tablero[i][1] == marcador && tablero[i][2] == marcador) {
                return true;
            }
            if (tablero[0][i] == marcador && tablero[1][i] == marcador && tablero[2][i] == marcador) {
                return true;
            }
        }

        // Verificar diagonales
        if (tablero[0][0] == marcador && tablero[1][1] == marcador && tablero[2][2] == marcador) {
            return true;
        }
        if (tablero[2][0] == marcador && tablero[1][1] == marcador && tablero[0][2] == marcador) {
            return true;
        }

        return false;
    }
    
    public boolean celcaVacia(){
        for(int i=0; i < tablero.length; i++){
            for(int j=0; j < tablero.length; j++){
                if(tablero[i][j] == '-'){
                    return true;
                }
            }
        }
        return false;
    }

}


