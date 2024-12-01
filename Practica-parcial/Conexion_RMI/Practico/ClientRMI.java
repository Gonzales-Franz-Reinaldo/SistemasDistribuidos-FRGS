package Conexion_RMI.Practico;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

public class ClientRMI {
    public static void main(String[] args) {

        try {

            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            IBiblioteca biblioteca = (IBiblioteca) registry.lookup("Biblioteca");

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\nMeñu de Opciones:");
                System.out.println("1. Registrar libro");
                System.out.println("2. Consultar libro");
                System.out.println("3. Listar libros");
                System.out.println("4. Prestar libro");
                System.out.println("5. Devolver libro");
                System.out.println("6. Salir");

                System.out.print("Selecciona una opción: ");

                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.print("Introduzca el titulo: ");
                        String titulo = scanner.nextLine();
                        System.out.print("Autor: ");
                        String autor = scanner.nextLine();
                        System.out.print("Editorial: ");
                        String editorial = scanner.nextLine();
                        System.out.print("Año de publicación: ");
                        int anio = scanner.nextInt();
                        scanner.nextLine();

                        Libro libro = new Libro(titulo, autor, editorial, anio);
                        System.out.println(biblioteca.registrarLibro(libro));
                        break;

                    case 2:
                        System.out.print("Introduzca el titulo del libro a consultar: ");
                        String tituloConsulta = scanner.nextLine();

                        System.out.println(biblioteca.consultarLibro(tituloConsulta));
                        break;
                    case 3:
                        List<Libro> libros = biblioteca.listarLibros();

                        if (libros.isEmpty()) {

                            System.out.println("No hay libros en la biblioteca");
                        } else {

                            System.out.println("Libros en la biblioteca:");

                            for (Libro libro_ : libros) {
                                System.out.println(libro_);
                            }
                        }
                        break;
                    case 4:
                        System.out.print("Introduzca el titulo del libro a prestar: ");
                        String tituloPrestar = scanner.nextLine();

                        System.out.println(biblioteca.prestarLibro(tituloPrestar));
                        break;

                    case 5:
                        System.out.print("Introduzca el titulo del libro a devolver: ");
                        String tituloDevolver = scanner.nextLine();

                        System.out.println(biblioteca.devolverLibro(tituloDevolver));
                        break;
                    case 6:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
