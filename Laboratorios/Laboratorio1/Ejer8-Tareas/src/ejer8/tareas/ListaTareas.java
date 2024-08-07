
package ejer8.tareas;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Franz Gonzales
 */
public class ListaTareas {
    
    private List<Tarea> tareas;

    public ListaTareas() {
        tareas = new ArrayList<>();
    }
    
    public void agregarTarea(Tarea tarea){
        tareas.add(tarea);
    }
    
    public void marcarCompletado(Tarea tarea, Estado estado){
        tarea.setEstado(estado);
    }
    
    public List<Tarea> mostrarListaTareas(){
        return tareas;
    }
}
