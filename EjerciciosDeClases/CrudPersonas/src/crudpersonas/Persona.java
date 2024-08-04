
package crudpersonas;

public class Persona {
    int id;
    String nombre;
    String apellido;
    int edad;
    String nro_carnet;

    public Persona(int id, String nombre, String apellido, int edad, String nro_carnet) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.nro_carnet = nro_carnet;
    }
    
    public Persona(String nombre, String apellido, int edad, String nro_carnet) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.nro_carnet = nro_carnet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNro_carnet() {
        return nro_carnet;
    }

    public void setNro_carnet(String nro_carnet) {
        this.nro_carnet = nro_carnet;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", nro_carnet=" + nro_carnet + '}';
    }
    
    
}
