package SoquetsTCP.Operaciones;

import java.io.*;
import java.net.*;

public class Server {
    
    public static void main(String[] args) {
        int puerto = 12345;
        Calculadora calculadora = new Calculadora();
        
        try {
            ServerSocket server = new ServerSocket(puerto);
            System.out.println("Servidor iniciado en el puerto " + puerto);
            
            while (true) {
                
                Socket client = server.accept();
                System.out.println("Cliente conectado");
    
                
                BufferedReader entrada = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter toClient = new PrintWriter(client.getOutputStream(), true);

                String operacion = entrada.readLine();
                String resultado = "";

                if (!operacion.matches("fac|sum|fibo|serieFibo")) {
                    toClient.println("Error: Operación inválida. Usa: fac, sum, fibo, serieFibo.");
                    return;
                }

                String mensaje = "Introduzca un numero: ";
                toClient.println(mensaje);

                try {
                    
                    int numero = Integer.parseInt(entrada.readLine());
    
                    switch (operacion) {
                        case "fac":
                            resultado = "Factorial de " + numero + " = " + calculadora.factorial(numero);
                            break;
                        case "sum":
                            resultado = "Suma de los primeros " + numero + " numeros = " + calculadora.sumartoria(numero);
                            break;
                        case "fibo":
                            resultado = "Fibonacci de " + numero + " = " + calculadora.fibonacci(numero);
                            break;
                        case "serieFibo":
                            resultado = "La serie de Fiboncci de " + numero + " numeros = " + calculadora.serieFibonacci(numero);
                            break;
                        default:
                            break;
                    }
                } catch (NumberFormatException e) {
                    resultado = "Error: Entrada inválida. Debes ingresar un número entero.";
                }


                toClient.println(resultado);

                // Cierra flujos y sockets
                client.close();
                System.out.println("Conexion cerrada.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
