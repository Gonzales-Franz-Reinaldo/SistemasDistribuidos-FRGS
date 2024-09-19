/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculadorautpmultihilo;

/**
 *
 * @author Franz Gonzales
 */
public class Calculadora {

    // Método para sumar dos números
    public static int suma(int a, int b) {
        return a + b;
    }

    // Método para restar dos números
    public static int resta(int a, int b) {
        return a - b;
    }

    // Método para multiplicar dos números
    public static int multiplicacion(int a, int b) {
        return a * b;
    }

    // Método para dividir dos números
    public static double division(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir entre cero");
        }
        return (double) a / b;
    }

    // Método para calcular el factorial de un número
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    // Método para calcular el n-ésimo número de Fibonacci
    public static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int a = 0, b = 1, c;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
