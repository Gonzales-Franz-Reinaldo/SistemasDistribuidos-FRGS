/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package holamundo;

import java.util.Scanner;

/**
 *
 * @author Franz Gonzales
 */
public class HolaMundo {

    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Hola mundo");
        
//        Persona persona = new Persona("Junito", "Gonzales", 20);
//        System.out.println(persona);

        int opcion = 0;
        
        Persona persona = new Persona();
        
        while(opcion != 3){
            
            System.out.println("1.- Inroducir Datos");
            System.out.println("2.- Mostrar Datos");
            System.out.println("3.- Crear Docente Basica");
            System.out.println("4.- Salir");
            
            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    System.out.println("Introducir el nombre");
                    String nombre = scanner.next();
                    System.out.println("Introducir el apellido");
                    String apellido = scanner.next();
                    System.out.println("Introducir la edad");
                    int edad = scanner.nextInt();
                    
//                    Persona persona = new Persona(nombre, apellido, edad);
                    persona.setNombre(nombre.toUpperCase());
                    persona.setApellidos(apellido.toUpperCase());
                    persona.setEdad(edad);
                    
                    break;
                    
                case 2:
//                    System.out.println(persona);
                    persona.mostrarDatos();
                    break;
                case 3:
                    DocenteBasicas ing_Monti = new DocenteBasicas("Carlos", "Monti");
                    MateriaBasica SIS101 = new MateriaBasica();
                    MateriaBasica SIS251 = new MateriaBasica();
                    MateriaEspecialidad SIS258 = new MateriaEspecialidad();
                    
                    ing_Monti.addMateria(SIS101);
                    ing_Monti.addMateria(SIS251);
                    ing_Monti.addMateria(SIS258);
                    break;
                default:
                    throw new AssertionError();
            }
        }

    }
    
}
