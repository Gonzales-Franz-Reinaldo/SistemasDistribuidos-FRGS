
package ejer8.tareas;

/**
 *
 * @author Franz Gonzales
 */
public class Tarea {
    private String descripcion;
    private String fechaLimite;
    private Estado estado;

    public Tarea(String descripcion, String fechaLimite, Estado estado) {
        this.descripcion = descripcion;
        this.fechaLimite = fechaLimite;
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFechaLimite() {
        return fechaLimite;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFechaLimite(String fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    public void marcarComoCompletado(){
        this.estado = Estado.COMPLETADA;
    }

    @Override
    public String toString() {
        return "Tarea{" + "descripcion=" + descripcion + ", fechaLimite=" + fechaLimite + ", estado=" + estado + '}';
    }
    
    
}
