//1. Crea un programa en Java para calcular el área y el perímetro de un rectángulo.
//Proporciona un menú con opciones para ingresar las dimensiones del rectángulo,
//calcular el área y el perímetro, y salir del programa.
package ejer1.rectangulo;

import java.util.Scanner;

/**
 *
 * @author Franz Gonzales
 */
public class Ejer1Rectangulo {

    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner scanner = new Scanner(System.in);
        Rectangulo rectagulo = null;
        
        int opcion;
        
        do{
            System.out.println("MENU PRINCIPAL.");
            System.out.println("1. Ingresar las dimensiones del Rectangulo.");
            System.out.println("2. Calcular el Area.");
            System.out.println("3. Calcular el Perimetro.");
            System.out.println("4. Salir del progrma.");
            
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese las dimensiones.");
                    System.out.print("Ingrese el largo del rectangulo: ");
                    double largo = scanner.nextDouble();
                    scanner.nextLine();
                    
                    System.out.print("Ingrese el ancho del rectangulo: ");
                    double ancho = scanner.nextDouble();
                    scanner.nextLine();
                    
                    rectagulo = new Rectangulo(largo, ancho);
                    break;
                case 2:
                    System.out.println("El Area del Rectangulo es: " + rectagulo.calcularArea());
                    break;
                case 3:
                    System.out.println("El Perimetro del Rectangulo es: " + rectagulo.calcularPerimetro());
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while(opcion != 4);
        
        scanner.close();
    }
    
}
