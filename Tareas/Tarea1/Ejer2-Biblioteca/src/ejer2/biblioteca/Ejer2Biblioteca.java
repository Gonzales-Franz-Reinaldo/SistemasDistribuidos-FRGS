
//2. Crear las clases necesarias para manejar  la biblioteca de  la facultad  donde
//existe una biblioteca que tiene armarios donde se encuentran libros , la biblioteca 
//tiene un nombre un tamaño en metros cuadras y un lista de armarios, el armario puede 
//ser de madera o metálico y tiene un código y un lista de libros, el libro tiene un 
//nombre autor ,editorial y año 
//Crear las clases necesarias para representar la biblioteca y las opciones para 
//crear armario y añadirlo a la biblioteca , crear libro, cargar un libro en un armario 

package ejer2.biblioteca;

import com.sun.source.doctree.EscapeTree;
import java.util.Scanner;

/**
 *
 * @author Franz Gonzales
 */
public class Ejer2Biblioteca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner scanner = new Scanner(System.in);
        int opcion;
        
        BibliotecaFacultad biblioteca = new BibliotecaFacultad("Biblioteca USFX", 250);
        
        do{
            System.out.println("MENU PRINCIPAL.");
            System.out.println("1: Crear un Armario.");
            System.out.println("2: Crear un libro y cargar a un Armario.");
            System.out.println("3: Listar Biblioteca.");
            System.out.println("4: Saliendo..");
            System.out.print("Seleccione una opcion: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch(opcion){
                case 1:
                    System.out.println("Crear un armario.");
                                
                    System.out.print("Intoducir el codigo del Armario: ");
                    String codigo = scanner.nextLine();
                    
                    System.out.println("Ingrese el Tipo de Armario a crear:");
                    System.out.print("(1: Armario Madera - 2: Armario Metalico): ");
                    int tipo = scanner.nextInt();
                    scanner.nextLine();
                    
                    Armario armario;
                    if(tipo == 1){
                        armario = new ArmarioMadera(codigo);
                    }else{
                        armario = new ArmarioMetalico(codigo);
                    }
                    
                    biblioteca.agregarArmario(armario);
                    System.out.println("Armario agregado.");
                    break;
                    
                case 2:
                    System.out.println("Crear un libro");
                    
                    System.out.print("Introduce el Nombre: ");
                    String nombre = scanner.nextLine();
                    
                    System.out.print("Introduce el Autor: ");
                    String autor = scanner.nextLine();
                    
                    System.out.print("Introduce el Editorial: ");
                    String editorial = scanner.nextLine();
                    
                    System.out.print("Introduce el año: ");
                    int ano = scanner.nextInt();
                    scanner.nextLine();
                    
                    Libro libro = new Libro(nombre, autor, editorial, ano);
                    
                    System.out.print("Ingrese el codigo del armario a cargar el libro: ");
                    String codigoArmario = scanner.nextLine();
                    
                    for(Armario arm : biblioteca.getArmarios()){
                        if(arm.getCodigo().equals(codigoArmario)){
                            arm.agregarLibro(libro);
                            System.out.println("Libro agregado correctamente.");
                            break; 
                        }else{
                            System.out.println("No existe un libro con el codigo introducido");
                        }
                    }
                    
                    break;
                case 3:
                    System.out.println("Estado de la Biblioteca.");
                    System.out.println(biblioteca);
                    break;
                case 4:
                    System.out.println("Saliendo..");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
            
        }while(opcion != 4);
        
        scanner.close();
    }
    
}
