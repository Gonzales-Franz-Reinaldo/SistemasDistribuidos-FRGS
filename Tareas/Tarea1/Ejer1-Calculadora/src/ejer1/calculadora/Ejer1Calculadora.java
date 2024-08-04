/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejer1.calculadora;

import java.util.Scanner;

/**
 *
 * @author Franz Gonzales
 */

public class Ejer1Calculadora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner scanner = new Scanner(System.in);
        int numero = 0;
        int opcion = 0;
        
        Calculadora calculadora = new Calculadora();
        
        while(opcion != 6){
            System.out.println("Menu principal");
            System.out.println("1: Introducir n: ");
            System.out.println("2: Calcular fibonacci: ");
            System.out.println("3: Calcular serie de Fibonacci: ");
            System.out.println("4: Calcular factorial: ");
            System.out.println("5: Calcular Sumatoria: ");
            System.out.println("6: Salir: ");
            System.out.print("Seleccione una opción: ");
            
            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    System.out.println("Introduzca un número n: ");
                    numero = scanner.nextInt();
                    break;
                case 2:
                    System.out.println("Fibonacci de " + numero + " es: " + calculadora.fibonacci(numero));
                    break;
                case 3:
                    System.out.print("Serie Fibonacci hasta " + numero + ": ");
                    calculadora.serieFibonacci(numero);
                    break;
                case 4:
                    System.out.println("Factorial de " + numero + " es: " + calculadora.calcularFactorial(numero));
                    break;
                case 5:
                    System.out.println("Sumatoria de " + numero + " es: " + calculadora.sumatoriaNumero(numero));
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;    
            }
            
        }
        scanner.close();
    }
    
}
