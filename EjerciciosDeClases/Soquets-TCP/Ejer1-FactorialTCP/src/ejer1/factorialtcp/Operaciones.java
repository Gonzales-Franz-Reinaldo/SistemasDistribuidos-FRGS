
package ejer1.factorialtcp;

/**
 *
 * @author Franz Gonzales
 */
public class Operaciones {
    private int numero;
    
    public Operaciones(){
        
    }
    
    public Operaciones(int numero){
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
//    Metodos para los calculos de las operaciones
    public int factorial(){
        if(numero <= 1){
            return 1;
        }
        
        int fact = 1;
        for(int i = 1; i <= numero; i++){
            fact *= i;
        }
        
        return fact;
    }
    
    public int fibonacci(){
        if(numero <= 0){
            return 0;
        }else if(numero == 1){
            return 1;
        }
        
        int a = 0;
        int b = 1;
        int fibo = 0;
        
        for(int i = 2; i <= numero; i++){
            fibo = a + b;
            a = b;
            b = fibo;
        }
        return fibo;
    }
    
    public int sumatoria(){
        if(numero == 0){
            return 0;
        }
        
        int sumatoria = 0;
        
        for(int i = 1; i<= numero; i++){
            sumatoria += i;
        }
        
        return sumatoria;
    }
}
