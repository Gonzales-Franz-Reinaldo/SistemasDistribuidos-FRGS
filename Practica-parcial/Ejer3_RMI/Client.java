package Ejer3_RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int port = 1099;

        try {
            Registry registry = LocateRegistry.getRegistry("localhost", port);

            IProcesadorCadena procesador = (IProcesadorCadena) registry.lookup("Procesador");

            while (true) {

                System.out.println("Menú de opciones:");
                System.out.println("1. Introducir cadena");
                System.out.println("2. Invertir cadena");
                System.out.println("3. Aumentar espacios");
                System.out.println("4. Aumentar cadena");
                System.out.println("5. Salir");

                System.out.print("Opción: ");
                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.print("Introduzca la cadena: ");
                        String cadena = scanner.nextLine();

                        procesador.introducirCadena(cadena);
                        break;
                    case 2:
                        System.out.println("Cadena invertida: " + procesador.invertirCadena());
                        break;
                    case 3:
                        System.out.print("Introduzca la cantidad de espacios a aumentar: ");
                        int cantidad = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Cadena con espacios aumentados: " + procesador.aumentarEspacios(cantidad));
                        break;
                    case 4:
                        System.out.print("Introduzca la cadena a aumentar: ");
                        String cadenaAumentar = scanner.nextLine();

                        System.out.println("Cadena aumentada: " + procesador.aumentar(cadenaAumentar));
                        break;
                    case 5:
                        System.out.println("Saliendo...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opción inválida");
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
