
package ejer4.crudbiblioteca;

/**
 *
 * @author Franz Gonzales
 */

public class ArmarioMadera extends Armario{
    
    public ArmarioMadera(String codigo) {
        super(codigo, "Madera");
    }

    public ArmarioMadera(int id, String codigo, String tipo, int id_biblioteca) {
        super(id, codigo, "Madera", id_biblioteca);
    }

    @Override
    public String toString() {
        return "Armario de Madera{" + super.toString() + "}";
    }
    
}
