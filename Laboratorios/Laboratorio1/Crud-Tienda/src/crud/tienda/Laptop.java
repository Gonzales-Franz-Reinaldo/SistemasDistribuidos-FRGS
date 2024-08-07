
package crud.tienda;

/**
 *
 * @author Franz Gonzales
 */
public class Laptop extends Producto{
    private String sistemaOperativo;
    private String ram;

    public Laptop(int id, String nombre, double precio, String tipo, int cantidad, String marca) {
        super(id, nombre, precio, "Laptop", cantidad, marca);
    }
    
    public Laptop(String nombre, double precio, int cantidad, String marca) {
        super(nombre, precio, "Laptop", cantidad, marca);
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    
    @Override
    public String detallesProducto() {
        return "Laptop{" +
                ", Sistema operativo='" + sistemaOperativo + '\'' +
                ", ram='" + ram + '\'' +
                '}';
    }
    
    @Override
    public String toString() {
        return "Laptop{" + super.toString() + "}";
    }
}
