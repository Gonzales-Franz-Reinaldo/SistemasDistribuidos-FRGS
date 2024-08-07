
package crud.tienda;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Franz Gonzales
 */
public class CrudTienda {

    public static void main(String[] args) {
        // TODO code application logic here
        
        String url = "jdbc:mysql://localhost:3306/";
        String db = "bd_productos";
        String user = "root";
        String password = "";
        String driver = "com.mysql.cj.jdbc.Driver";
        
        Conexion conector = new Conexion(url, db, user, password, driver);
        Connection conexion = conector.conectar();
        
        ProductoDAO productoDao = new ProductoDAO(conexion);
        
        Scanner scanner = new Scanner(System.in);
        
        int opcion = 0;
        while(opcion != 4){
            System.out.println("MENU PRINCIPAL.");
            System.out.println("1: Agregar producto al inventario.");
            System.out.println("2: Mostrar Inventario.");
            System.out.println("3: Calcular el precio total del Stock.");
            System.out.println("4: Salir del programa.");
            
            opcion = scanner.nextInt();
            scanner.nextLine();
    
            switch(opcion){
                case 1:
                    System.out.println("Elija que tipo de producto desea agregar.");
                    System.out.print("(1: Telefono, 2: Laptop): ");
                    int tipo = scanner.nextInt();
                    scanner.nextLine();
                    
                    Producto producto;
                    if(tipo == 1){
                        System.out.print("Nombre del Telefono: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Precio del Telefono: ");
                        double precio = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Cantidad del Telefono: ");
                        int cantidad = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Marca del Telefono: ");
                        String marca = scanner.nextLine();
                        
                        producto = new Telefono(nombre, precio, cantidad, marca);
                        productoDao.agregarProductoInventario(producto);
                        System.out.println("El producto Telefono fue agregado correctamente.");
                    }else if(tipo == 2){
                        System.out.print("Nombre del Laptop: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Precio del Laptop: ");
                        double precio = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Cantidad del Laptop: ");
                        int cantidad = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Marca del Laptop: ");
                        String marca = scanner.nextLine();
                        
                        producto = new Laptop(nombre, precio, cantidad, marca);
                        productoDao.agregarProductoInventario(producto);
                        System.out.println("El producto Laptop fue agregado correctamente.");
                    }
                    break;
                case 2:
                    System.out.println("Estado del Inventario.");
                    List<Producto> productos = productoDao.mostrarInventario();
                    
                    for(Producto products : productos){
                        System.out.print(products + " \n");
                    }
                    break;
                case 3:
                    System.out.println("El precio total de los productos es: " + productoDao.calcularPrecioTotalStock() + "Bs.");
                    break;
                case 4:
                    System.out.println("Saliendo..");
                    break;
                default:
                    System.out.println("Operacion no valida.");
                    break;
            }
        }
    }
    
}
