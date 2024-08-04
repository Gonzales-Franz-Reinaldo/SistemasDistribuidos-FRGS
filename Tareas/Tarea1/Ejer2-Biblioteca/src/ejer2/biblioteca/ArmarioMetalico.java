/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer2.biblioteca;

/**
 *
 * @author Franz Gonzales
 */
public class ArmarioMetalico extends Armario{

    public ArmarioMetalico(String codigo) {
        super(codigo);
    }
    
    @Override
    public String toString(){
        return "Armario Metálico {" + super.toString() + "}";
    }
    
}
