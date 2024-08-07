//Crea un sistema en Java para gestionar una tienda de productos electrónicos. Define
//clases para representar productos como teléfonos móviles, laptops, etc. Implementa
//funcionalidades para agregar productos al inventario, mostrar el inventario y calcular el
//precio total de los productos en stock.

package ejer4.tienda;

import java.util.Scanner;

/**
 *
 * @author Franz Gonzales
 */
public class Ejer4Tienda {

    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner scn = new Scanner(System.in);
        Inventario inventario = new Inventario();
                
        int opcion;
        
        do{
            System.out.println("MENU PRINCIAPL.");
            System.out.println("1: Agregar un producto.");
            System.out.println("2: Mostrar el Inventario.");
            System.out.println("3: Calcular el precio total.");
            System.out.println("4: Salir del programa.");
            
            opcion = scn.nextInt();
            scn.nextLine();
            
            switch(opcion){
                case 1:
                    System.out.println("Que tipo de producto desea agregar?.");
                    System.out.print("(1: Telefono - 2: Laptop): ");
                    int tipo = scn.nextInt();
                    scn.nextLine();
                    
                    Producto producto;
                    if(tipo == 1){
                        System.out.println("Ingrese los datos del Telefono.");
                        System.out.print("Nombre del telefono: ");
                        String nombreTelefono = scn.nextLine();
                        System.out.print("Precio del telefono: ");
                        double precioTelefono = scn.nextDouble();
                        scn.nextLine();
                        System.out.print("Marca del telefono: ");
                        String marcaTelefono = scn.nextLine();
                        
                        System.out.print("Modelo del telefono: ");
                        String modeloTelefono = scn.nextLine();
                        System.out.print("Ram del telefono: ");
                        int ramTelefono = scn.nextInt();
                        scn.nextLine();
                        System.out.print("Almacenamiento del telefono: ");
                        int almacenamientoTelefono = scn.nextInt();
                        scn.nextLine();
                        
                        producto = new Telefono(nombreTelefono, precioTelefono, marcaTelefono, modeloTelefono, ramTelefono, almacenamientoTelefono);
                        
                        inventario.agregarProducto(producto);
                        System.out.println("Teléfono agregado correctamente.");
                    }else{
                        System.out.println("Ingrese los datos del Laptop.");
                        System.out.print("Nombre del laptop: ");
                        String nombreLaptop = scn.nextLine();
                        System.out.print("Precio del laptop: ");
                        double precioLaptop = scn.nextDouble();
                        scn.nextLine();
                        System.out.print("Marca del laptop: ");
                        String marcaLaptop = scn.nextLine();
                        
                        System.out.print("Procesador del laptop: ");
                        String procesadorLaptop = scn.nextLine();
                        System.out.print("Ram del laptop: ");
                        int ramLaptop = scn.nextInt();
                        scn.nextLine();
                        System.out.print("Tipo de memoria del laptop: ");
                        String tipoMemoriaLaptop = scn.nextLine();
                        
                        producto = new Laptop(nombreLaptop, precioLaptop, marcaLaptop, procesadorLaptop, ramLaptop, tipoMemoriaLaptop);
                        
                        inventario.agregarProducto(producto);
                        System.out.println("Laptop agregado correctamente.");
                    }
                    break;
                case 2:
                    System.out.println("Inventario de Productos.");
                    inventario.mostrarInventario();
                    break;
                case 3:
                    System.out.println("El precio total de productos de Stock es: " + inventario.calcularPrecioTotalStock() + "BS.");
                    break;
                case 4:
                    System.out.println("Saliendo..");
                    break;
                default:
                    System.out.println("Operacion no valida");
                    break;
            }
            
        }while(opcion != 4);
        
        scn.close();
    }
    
}
