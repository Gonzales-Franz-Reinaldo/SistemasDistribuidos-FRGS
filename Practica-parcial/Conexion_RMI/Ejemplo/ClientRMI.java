package Conexion_RMI.Ejemplo;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ClientRMI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            // Conectar al RMI Registry
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Buscar el objeto remoto en el RMI Registry
            ICalculadora calculadora = (ICalculadora) registry.lookup("Calculadora");

            // Invocar métodos remotos del objeto

            System.out.print("Introduzca el primer número: ");
            int a = scanner.nextInt();
            System.out.print("Introduzca el segundo número: ");
            int b = scanner.nextInt();

            System.out.println("Suma: " + calculadora.sumar(a, b));
            System.out.println("Resta: " + calculadora.restar(a, b));
            System.out.println("Multiplicación: " + calculadora.multiplicar(a, b));
            System.out.println("División: " + calculadora.dividir(a, b));

            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
