package ahorcado;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {
        try {
            IAhorcado ahorcado = (IAhorcado) Naming.lookup("rmi://localhost/JuegoAhorcado");
            ahorcado.iniciar();

            Scanner scanner = new Scanner(System.in);
            Respuesta respuesta = null;
            boolean jugando = true;

            while (jugando) {
                System.out.println("Menú del Juego del Ahorcado");
                System.out.println("1. Adivinar letra");
                System.out.println("2. Adivinar palabra");
                System.out.println("3. Salir");
                System.out.print("Elige una opción: ");

                int opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                switch (opcion) {
                    case 1:
                        System.out.print("Introduce una letra: ");
                        char letra = scanner.nextLine().charAt(0);
                        respuesta = ahorcado.adivinarLetra(letra);
                        break;

                    case 2:
                        System.out.print("Introduce una palabra: ");
                        String palabra = scanner.nextLine();
                        respuesta = ahorcado.adivinarPalabra(palabra);
                        break;

                    case 3:
                        jugando = false;
                        System.out.println("Gracias por jugar.");
                        break;

                    default:
                        System.out.println("Opción no válida. Intenta de nuevo.");
                        break;
                }

                if (respuesta != null) {
                    System.out.println(respuesta);

                    if (respuesta.isJuegoTerminado()) {
                        
                        jugando = false;
                        
                        if (respuesta.isJugadorGanador()) {
                            System.out.println("¡Felicidades, ganaste el juego!");
                        } else {
//                            System.out.println("Lo siento, perdiste. La palabra era: " + ahorcado.getPalabraSecreta());
                            System.out.println("Lo siento, perdiste.");
                        }
                    }
                }
            }

            scanner.close();
            
        } catch (Exception e) {
            System.err.println("Error al comunicarse con el servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
