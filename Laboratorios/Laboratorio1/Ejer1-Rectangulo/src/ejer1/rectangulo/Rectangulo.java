
package ejer1.rectangulo;

/**
 *
 * @author Franz Gonzales
 */
public class Rectangulo {
    
    private double  largo;
    private double ancho;

    public Rectangulo(double largo, double ancho) {
        this.largo = largo;
        this.ancho = ancho;
    }

    public double getLargo() {
        return largo;
    }

    public void setLargo(double largo) {
        this.largo = largo;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }
    
    
    public double calcularArea(){
        double area = largo * ancho;
        return area;
    }
    
    public double calcularPerimetro(){
        double perimetro = 2 * (largo + ancho);
        
        return perimetro;
    }
}
