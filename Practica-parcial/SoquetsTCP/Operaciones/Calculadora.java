package SoquetsTCP.Operaciones;

public class Calculadora {
    
    public int factorial(int n){
        int aux = 1;
        if(n == 0){
            return 1;
        } 

        for(int i = 1; i <= n ; i++){
            aux *= i;
        }

        return aux;
    }

    public int potencia(int base, int exponente){
        int aux = 1;
        for(int i = 0; i < exponente; i++){
            aux *= base;
        }

        return aux;
    }

    public int sumartoria(int n){
        int aux = 0;
        for(int i = 1; i <= n; i++){
            aux += i;
        }

        return aux;
    }

    public int fibonacci(int n){
        if(n == 0){
            return 0;
        } else if(n == 1){
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public String serieFibonacci(int n){
        String aux = "";
        for(int i = 0; i < n; i++){
            aux += fibonacci(i) + " ";
        }
        return aux;
    }
}
