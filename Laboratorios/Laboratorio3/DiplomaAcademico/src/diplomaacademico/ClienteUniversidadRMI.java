/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package diplomaacademico;

import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 *
 * @author Franz Gonzales
 */
public class ClienteUniversidadRMI {
    public static void main(String[] args) {
        
        try{
            // Conectar al registro RMI en localhost
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Buscar el objeto remoto del cajero automático
            IDiploma diploma = (IDiploma) registry.lookup("DiplomadoAcademico");

            // Crear el menú para interactuar con el usuario
            Scanner scanner = new Scanner(System.in);
            
            
            while(true){
                System.out.println("\n--- DIPLOMA ACADEMICO ---");
                System.out.println("INTRODUZCA LOS DATOS.");
                
                System.out.print("CI: ");
                String ci = scanner.nextLine();
                
                System.out.print("Nombre: ");
                String nombres = scanner.nextLine();
                
                System.out.print("1erApellido: ");
                String primerApellido = scanner.nextLine();
                
                System.out.print("2doApellido: ");
                String segundoApellido = scanner.nextLine();
                
                System.out.print("Fecha Nacimiento: ");
                String fecha_nacimiento = scanner.nextLine();
                
                System.out.print("Carrera: ");
                String carrera = scanner.nextLine();
            }
            
//            scanner.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}