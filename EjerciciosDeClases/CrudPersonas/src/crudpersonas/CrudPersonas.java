
package crudpersonas;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Franz Gonzales
 */
public class CrudPersonas {
    
    public static void main(String[] args) {
        // TODO code application logic here
        String url = "jdbc:mysql://localhost:3306/bd_personas";
        String user = "root";
        String password = "";
        String driver = "com.mysql.cj.jdbc.Driver";
        
        PersonaDAO personaDAO = new PersonaDAO(url, user, password, driver);
        personaDAO.conectar();
        
        Scanner scanner = new Scanner(System.in);
        int opcion;
        
        do{
            System.out.println("MENU PRINCIPAL:");
            System.out.println("1: Insertar nueva persona: ");
            System.out.println("2: Listar personas: ");
            System.out.println("3: Editar persona: ");
            System.out.println("4: Eliminar Persona: ");
            System.out.println("5: Salir.");
            System.out.print("Seleccione una opcion: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion) {
                case 1:
                    System.out.println("Insertar nueva persona");
                    System.out.print("Introducir nombre: ");
                    String nombre = scanner.nextLine();
                    
                    System.out.print("Introducir apellido: ");
                    String apellido = scanner.nextLine();
                    
                    System.out.print("Introducir edad: ");
                    int edad = scanner.nextInt();
                    scanner.nextLine();
                    
                    System.out.print("Introducir nro_carnet: ");
                    String nro_carnet = scanner.nextLine();
                    
                    Persona persona = new Persona(nombre, apellido, edad, nro_carnet);
                    personaDAO.insertar(persona);
                    System.out.println("Persona se inserto correctamente");
                    break;
                case 2:
                    System.out.println("Listar personas");
                    List<Persona> personas = personaDAO.listar();
                    
                    for (Persona pers : personas) {
                        System.out.println(pers);
                    }
                    break;
                case 3:
                    System.out.println("Editar persona.");
                    System.out.print("Introducir el ID a la persona a editar: ");
                    int id_persona = scanner.nextInt();
                    scanner.nextLine();
                    
                    System.out.println("Introdur nuevo nombre: ");
                    String nuevo_nombre = scanner.nextLine();
                    
                    System.out.println("Introdur nuevo apellido: ");
                    String nuevo_apellido = scanner.nextLine();
                    
                    System.out.println("Introdur nueva edad: ");
                    int nueva_edad = scanner.nextInt();
                    scanner.nextLine();
                    
                    System.out.println("Introdur nuevo nro carnet: ");
                    String nuevo_nroCarnet = scanner.nextLine();
                    
                    Persona personaEditar = new Persona(id_persona, nuevo_nombre, nuevo_apellido, nueva_edad, nuevo_nroCarnet);
                    personaDAO.editarPersona(personaEditar);
                    break;
                case 4:
                    System.out.println("Eliminar una persona.");
                    System.out.print("Introduzca el ID de la persona a eliminar: ");
                    int id = scanner.nextInt();
                    
                    personaDAO.eliminarPersona(id);
                    break;
                case 5:
                    System.out.println("Saliendo..");
                    personaDAO.desconectar();
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
            
                    
        } while(opcion != 4);
        
        scanner.close();
    }
    
}
