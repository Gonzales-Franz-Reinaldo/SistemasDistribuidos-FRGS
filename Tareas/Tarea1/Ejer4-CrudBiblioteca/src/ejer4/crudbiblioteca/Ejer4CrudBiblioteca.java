
package ejer4.crudbiblioteca;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Franz Gonzales
 */
public class Ejer4CrudBiblioteca {

    public static void main(String[] args) {
        // TODO code application logic here
        
        String url = "jdbc:mysql://localhost:3306/bd_biblioteca";
        String user = "root";
        String password = "";
        String driver = "com.mysql.cj.jdbc.Driver";
        
        Scanner scanner = new Scanner(System.in);
        
        Conexion conector = new Conexion(url, user, password, driver);
        Connection conexion = conector.conectar();
        
        BibliotecaDAO biblotecaDAO = new BibliotecaDAO(conexion);
        ArmarioDAO armarioDAO = new ArmarioDAO(conexion);
        LibroDAO libroDAO = new LibroDAO(conexion);
        
        int opcion;
        
        do{
            System.out.println("MENU PRINCIPAL:");
            System.out.println("1: Crear Biblioteca para la Universidad.");
            System.out.println("2: Crear Armario.");
            System.out.println("3: Crear libro y agregar a un armario.");
            System.out.println("4: Listar bibliotecas.");
            System.out.println("5: Listar Armarios y Libros de una Biblioteca.");
            System.out.println("6: Salir");
            System.out.print("Seleccione una opcion: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion) {
                case 1:
                    System.out.println("Crear una Biblioteca.");
                    System.out.print("Introduce el nombre: ");
                    String nombre = scanner.nextLine();
                    
                    System.out.print("Introduce el tamaño en m2: ");
                    int tamano = scanner.nextInt();
                    scanner.nextLine();
                    
                    Biblioteca biblioteca = new Biblioteca(nombre, tamano);
                    biblotecaDAO.insertarBiblioteca(biblioteca);
                    break;
                    
                case 2:
                    System.out.println("Crear un Armario.");
                    System.out.print("Introduce el codigo: ");
                    String codigo = scanner.nextLine();
                    
                    System.out.print("Ingrese el tipo de armario (1. Madera, 2. Metálico): ");
                    int tipoArmario = scanner.nextInt();
                    scanner.nextLine();
                    
                    Armario armario;
                    if(tipoArmario == 1){
                        armario = new ArmarioMadera(codigo);
                    }else{
                        armario = new ArmarioMetalico(codigo);
                    }
                    
                    System.out.print("Ingresa el ID de la biblioteca a añadir: ");
                    int id_biblioteca = scanner.nextInt();
                    scanner.nextLine();
                    
//                    armario.setId_biblioteca(biblioteca.getId());
                    armario.setId_biblioteca(id_biblioteca);
                    armarioDAO.insertarArmario(armario);
                    break;
                 
                case 3:
                    System.out.println("Crear libro y agregar a un armario.");
                    System.out.print("Ingresa el nombre del libro: ");
                    String nombreLibro = scanner.nextLine();
                    
                    System.out.print("Ingresa el autor: ");
                    String autor = scanner.nextLine();
                    
                    System.out.print("Ingresa el editorial: ");
                    String editorial = scanner.nextLine();
                    
                    System.out.print("Ingresa el año: ");
                    int ano = scanner.nextInt();
                    scanner.nextLine();
                    
                    System.out.print("Ingresa el ID del armario a donde se pondrá el libro: ");
                    int id_armario = scanner.nextInt();
                    scanner.nextLine();
                    
                    Libro libro = new Libro(nombreLibro, autor, editorial, ano, id_armario);
                    
                    libroDAO.insertarLibro(libro);
                    break;
                    
                case 4:
                    System.out.println("Lista de las Bibliotecas");
                    List<Biblioteca> bibliotecas = biblotecaDAO.listarBibliotecas();
                    
                    for(Biblioteca biblios : bibliotecas){
                        System.out.println(biblios);
                    }
                    break;
                case 5:
                    System.out.println("Estado de Armarios y Libros de una Biblioteca.");
                    System.out.print("Ingresa el ID de la biblioteca de quien se mostrará los datos: ");
                    int idBiblioteca = scanner.nextInt();
                    scanner.nextLine();
                    
                    for(Armario arm : armarioDAO.listarArmario(idBiblioteca)){
                        System.out.print(arm);
                        
                        for(Libro lib : libroDAO.listarLibros(arm.getId())){
                            System.out.println(" " + lib);
                        }
                    }
                    
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
            
        } while(opcion != 6);
        
        scanner.close();
    }
    
}
