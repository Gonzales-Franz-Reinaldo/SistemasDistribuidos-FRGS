/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer2.biblioteca;

/**
 *
 * @author Franz Gonzales
 */
public class ArmarioMadera extends Armario{
    
    public ArmarioMadera(String codigo){
        super(codigo);
    }
    
    @Override
    public String toString(){
        return "Armario de Madera {" + super.toString() + "}";
    }
}
