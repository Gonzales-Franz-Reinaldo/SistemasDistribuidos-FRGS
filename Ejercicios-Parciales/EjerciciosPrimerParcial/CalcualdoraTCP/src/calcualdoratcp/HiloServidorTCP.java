/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calcualdoratcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Franz Gonzales
 */
public class HiloServidorTCP extends Thread{
    private Socket client;
    private Calculadora calculadora = new Calculadora();

    public HiloServidorTCP(Socket client) {
        this.client = client;
    }
    
    public void run() {
        try {
            DataInputStream fromClient = new DataInputStream(client.getInputStream());
            DataOutputStream toClient = new DataOutputStream(client.getOutputStream());

            // Recibir opción seleccionada por el cliente
            int opcion = fromClient.readInt();

            switch (opcion) {
                case 1: 
                    // Suma
                    int a = fromClient.readInt();
                    int b = fromClient.readInt();
                    int suma = calculadora.suma(a, b);
                    toClient.writeInt(suma);
                    break;
                case 2:
                    // Resta
                    a = fromClient.readInt();
                    b = fromClient.readInt();
                    int resta = calculadora.resta(a, b);
                    toClient.writeInt(resta);
                    break;
                case 3: // Multiplicación
                    a = fromClient.readInt();
                    b = fromClient.readInt();
                    int multiplicacion = calculadora.multiplicacion(a, b);
                    toClient.writeInt(multiplicacion);
                    break;
                case 4: // División
                    a = fromClient.readInt();
                    b = fromClient.readInt();
                    double division = calculadora.division(a, b);
                    toClient.writeDouble(division);
//                    try {
//                        double division = calculadora.division(a, b);
//                        toClient.writeDouble(division);
//                    } catch (ArithmeticException e) {
//                        toClient.writeUTF(e.getMessage());
//                    }
                    break;
                case 5: // Factorial
                    int n = fromClient.readInt();
                    long factorial = calculadora.factorial(n);
                    toClient.writeLong(factorial);
                    break;
                case 6: // Fibonacci
                    n = fromClient.readInt();
                    int fibonacci = calculadora.fibonacci(n);
                    toClient.writeInt(fibonacci);
                    break;
                default:
                    toClient.writeUTF("Opción no válida");
                    break;
            }
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
