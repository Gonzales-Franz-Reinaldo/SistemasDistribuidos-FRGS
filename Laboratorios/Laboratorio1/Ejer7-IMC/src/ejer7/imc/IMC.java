
package ejer7.imc;

/**
 *
 * @author Franz Gonzales
 */
public class IMC {
    
    public double calcularIMC(Persona persona){
        
        double peso = persona.getPeso();
        double altura = persona.getAltura();
        
        double imc = peso / (altura * altura);
        
        return Math.round(imc * 100.0) / 100.0;
    }
    
    
    public String clasificarIMC(double imc){
        if(imc < 18.5){
            return "Bajo peso";
        }else if(imc >= 18.5 && imc <= 24.9){
            return "Peso normal";
        }else if(imc >= 25 && imc <= 29.9){
            return "Sobrepeso";
        }else{
            return "Obesidad";
        }
    }
}
