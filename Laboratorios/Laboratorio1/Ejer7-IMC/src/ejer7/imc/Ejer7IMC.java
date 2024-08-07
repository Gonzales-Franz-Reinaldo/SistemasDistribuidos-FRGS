//7. Crea un programa en Java para calcular el IMC (Índice de Masa Corporal) de una
//persona. Permite al usuario ingresar su peso y altura, y calcula su IMC. Proporciona una
//clasificación del IMC según los estándares de salud.

package ejer7.imc;

import java.util.Scanner;

/**
 *
 * @author Franz Gonzales
 */
public class Ejer7IMC {

    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner scanner = new Scanner(System.in);
        IMC imc = new IMC();
        
        System.out.println("MENU PRINCIPAL.");
        System.out.print("Ingrese el peso de la persona: ");
        double peso = scanner.nextDouble();
        scanner.nextLine();
        
        System.out.print("Ingrese la altura de la perosna: ");
        double altura = scanner.nextDouble();
        
        Persona persona = new Persona(peso, altura);
        
        double imcPersona = imc.calcularIMC(persona);
        String clasificado = imc.clasificarIMC(imcPersona);
        
        System.out.println("El IMC de la persona es: " + imcPersona);
        System.out.println("Clasificacion es: " + clasificado);
    }
    
}
