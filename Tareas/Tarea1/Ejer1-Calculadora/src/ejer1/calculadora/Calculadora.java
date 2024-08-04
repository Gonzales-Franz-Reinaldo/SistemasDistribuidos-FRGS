/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer1.calculadora;

/**
 *
 * @author Franz Gonzales
 */

public class Calculadora {
    
    public int fibonacci(int numero){
        if(numero <= 1){
            return numero;
        }else{
            return fibonacci(numero - 1) + fibonacci(numero - 2);
        }
        
    }
    
    public void serieFibonacci(int numero){
        int a = 0;
        int b = 1;
        
        System.out.print(a + " " +  b);
        
        for(int i = 2; i < numero; i++){
            int aux = a + b;
            System.out.print(" " + aux);
            a = b;
            b = aux;
        }
        System.out.println();     
    }
    
    public int calcularFactorial(int numero){
        if(numero <= 1){
            return 1;
        }
        int factorial = 1;
        for(int i = 1; i <= numero; i++){
            factorial *= i;
        }
        return factorial;
    }
    
    public int sumatoriaNumero(int numero){
        int sumatoria = 0;
        for(int i = 1; i <= numero; i++){
            sumatoria += i;
        }
        return sumatoria;
    }
}