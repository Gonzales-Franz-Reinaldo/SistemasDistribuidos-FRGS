/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer4.crudbiblioteca;

/**
 *
 * @author Franz Gonzales
 */
public class ArmarioMetalico extends Armario{

    public ArmarioMetalico(String codigo) {
        super(codigo, "Metalico");
    }
    
    public ArmarioMetalico(int id, String codigo, String tipo, int id_biblioteca) {
        super(id, codigo, "Metalico", id_biblioteca);
    }

    @Override
    public String toString() {
        return "Armario Metálico{" + super.toString() + "}";
    }
    
}