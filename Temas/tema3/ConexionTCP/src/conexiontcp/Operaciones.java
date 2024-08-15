
package conexiontcp;

/**
 *
 * @author Franz Gonzales
 */
public class Operaciones {
    
    public int factorial(int n){
        if(n <= 1){
            return 1;
        }
        
        int factorial = 1;
        
        for(int i = 1; i<= n; i++){
            factorial *= i;
        }
        
        return factorial;
    }
    
    public int fibonacci(int n){
        if(n <= 1){
            return n;
        }else{
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
    

}
