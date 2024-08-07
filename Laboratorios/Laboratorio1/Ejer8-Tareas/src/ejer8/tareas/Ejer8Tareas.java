
package ejer8.tareas;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Franz Gonzales
 */
public class Ejer8Tareas {
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner scanner = new Scanner(System.in);
        
        ListaTareas operarTarea = new ListaTareas();
        
        int opcion = 0;
        
        while(opcion != 4){
            System.out.println("MENU PRINCIPAL.");
            System.out.println("1: Agregar una tarea.");
            System.out.println("2: Marcar tarea como completada.");
            System.out.println("3: Mostrar lista de tareas.");
            System.out.println("4: Salir del programa.");
            
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch(opcion){
                case 1:
                    System.out.println("Agregue una tarea.");
                    System.out.println("Ingresa la descripcion del libro: ");
                    String descripcion = scanner.nextLine();
                    
                    System.out.print("Ingrese la fecha de limite: ");
                    String fechaLimite = scanner.nextLine();
                    
                    System.out.println("Ingrese el estado del libro");
                    System.out.print("(1: Pendiente, 2: En progreso, 3: Completada): ");
                    int est = scanner.nextInt();
                    scanner.nextLine();
                   
                    Estado estado;
                    if(est == 1){
                        estado = Estado.PENDIENTE;
                    }else if(est == 2){
                        estado = Estado.EN_PROGRESO;
                    }else{
                        estado = Estado.COMPLETADA;
                    }
                    
                    Tarea tarea = new Tarea(descripcion, fechaLimite, estado);
                    
                    operarTarea.agregarTarea(tarea);
                    System.out.println("Se agrego la tarea");
                    break;
                case 2:
                    System.out.println("Ingre el nombre de la tarea a marcar completada.");
                    String tareaEstado = scanner.nextLine();
                    List<Tarea> materias = operarTarea.mostrarListaTareas();
                    
                    for(Tarea tarea_ : materias){
                        if(tarea_.getDescripcion().equals(tareaEstado)){
                            tarea_.setEstado(Estado.COMPLETADA);
                        }
                    }
                    System.out.println("La tarea fue marcada como completada.");
                    break;
                case 3:
                    System.out.println("Lista de tareas.");
                    List<Tarea> listaMaterias = operarTarea.mostrarListaTareas();
                    
                    for(Tarea tar : listaMaterias){
                        System.out.println(tar);
                    }
                    break;
                case 4:
                    System.out.println("Saliendo..");
                    break;
                
                default:
                    System.out.println("Operacion no valida.");
                    break;
            }
        }
    }
    
}
