package SoquetsTCP.SoquetMultiHilo;

import java.io.*;
import java.net.*;
import java.net.Socket;

public class ClientHandler extends Thread {
    private Socket client;
    private Calculadora calculadora;

    public ClientHandler(Socket client) {
        this.client = client;
        this.calculadora = new Calculadora();
    }

    @Override
    public void run() {

        try {

            BufferedReader entrada = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter toClient = new PrintWriter(client.getOutputStream(), true);

            String operacion = entrada.readLine();
            String resultado = "";

            // Validar operación
            if (!operacion.matches("fac|sum|fibo|serieFibo")) {
                toClient.println("Error: Operación inválida. Usa: fac, sum, fibo, serieFibo.");
                return;
            }

            String mensaje = "Introduzca un numero: ";
            toClient.println(mensaje);

            try {

                // Leer el número enviado por el cliente
                int numero = Integer.parseInt(entrada.readLine());

                // Procesar la operación
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
                        resultado = "La serie de Fiboncci de " + numero + " numeros = "
                                + calculadora.serieFibonacci(numero);
                        break;
                    default:
                        break;
                }

                // Enviar el resultado al cliente
                toClient.println(resultado);
                
            } catch (NumberFormatException e) {
                resultado = "Error: Entrada inválida. Debes ingresar un número entero.";
            }
        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }
}
