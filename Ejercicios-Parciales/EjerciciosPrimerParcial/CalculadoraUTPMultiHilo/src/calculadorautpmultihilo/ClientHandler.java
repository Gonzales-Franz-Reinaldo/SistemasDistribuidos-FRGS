/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadorautpmultihilo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Franz Gonzales
 */
public // Clase que maneja la conexión de cada cliente en un hilo separado
class ClientHandler extends Thread {
    private Socket client;

    public ClientHandler(Socket socket) {
        this.client = socket;
    }

    @Override
    public void run() {
        try {
            // Flujos de entrada y salida
            DataInputStream fromClient = new DataInputStream(client.getInputStream());
            DataOutputStream toClient = new DataOutputStream(client.getOutputStream());

            while (true) {
                int opcion = fromClient.readInt();  // Leer la opción del cliente
                if (opcion == 7) {
                    System.out.println("Cliente desconectado.");
                    break;
                }

                // Procesar la operación seleccionada
                int num1 = 0, num2 = 0, resultado = 0;
                String respuesta = "";

                switch (opcion) {
                    case 1:  // Suma
                        num1 = fromClient.readInt();
                        num2 = fromClient.readInt();
                        resultado = Calculadora.suma(num1, num2);
                        respuesta = "Suma: " + resultado;
                        break;
                    case 2:  // Resta
                        num1 = fromClient.readInt();
                        num2 = fromClient.readInt();
                        resultado = Calculadora.resta(num1, num2);
                        respuesta = "Resta: " + resultado;
                        break;
                    case 3:  // Multiplicación
                        num1 = fromClient.readInt();
                        num2 = fromClient.readInt();
                        resultado = Calculadora.multiplicacion(num1, num2);
                        respuesta = "Multiplicación: " + resultado;
                        break;
                    case 4:  // División
                        num1 = fromClient.readInt();
                        num2 = fromClient.readInt();
                        try {
                            double divResult = Calculadora.division(num1, num2);
                            respuesta = "División: " + divResult;
                        } catch (ArithmeticException e) {
                            respuesta = e.getMessage();
                        }
                        break;
                    case 5:  // Factorial
                        num1 = fromClient.readInt();
                        resultado = Calculadora.factorial(num1);
                        respuesta = "Factorial: " + resultado;
                        break;
                    case 6:  // Fibonacci
                        num1 = fromClient.readInt();
                        resultado = Calculadora.fibonacci(num1);
                        respuesta = "Fibonacci: " + resultado;
                        break;
                    default:
                        respuesta = "Opción no válida";
                        break;
                }

                // Enviar la respuesta al cliente
                toClient.writeUTF(respuesta);
            }

            client.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
