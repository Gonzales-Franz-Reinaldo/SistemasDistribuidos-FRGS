package SoquetsUDP.Estudiantes;

import java.net.*;
import java.util.*;

public class ServerUDP {

    private static final Map<String, Estudiante> estudiantes = new HashMap<>();
    
    public static void main(String[] args) {
        
        int PORT = 8000;
        byte[] buffer = new byte[1024];

        try {

            DatagramSocket socket = new DatagramSocket(PORT);
            System.out.println("Servidor UDP iniciado en el puerto " + PORT);

            while (true) {

                // Recibir solicitud del cliente
                DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);
                socket.receive(peticion);

                // Leer mensaje del cliente
                String mensaje = new String(peticion.getData(), 0, peticion.getLength());
                System.out.println("Solicitud recibida: " + mensaje);

                // Procesar el mensaje
                String respuesta = procesarSolicitud(mensaje);

                // Enviar respuesta al cliente
                byte[] bufferRespuesta = respuesta.getBytes();
                DatagramPacket respuestaPacket = new DatagramPacket(
                    bufferRespuesta,
                    bufferRespuesta.length,
                    peticion.getAddress(),
                    peticion.getPort()
                );

                socket.send(respuestaPacket);

                // socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static String  procesarSolicitud(String mensaje){
        String[] partes = mensaje.split(";");
        String operacion = partes[0].toLowerCase();

        switch(operacion){
            case "registrar":
                if(partes.length != 5){
                    return "Error: Formato inválido. Usa: registrar;<nombre>;<apellido>;<edad>;<carrera>";
                }
                String nombre = partes[1];
                String apellido = partes[2];
                int edad = Integer.parseInt(partes[3]);
                String carrera = partes[4];

                if(estudiantes.containsKey(nombre)){
                    return "Error: El estudiante " + nombre + " ya está registrado.";
                }

                Estudiante estudiante = new Estudiante(nombre, apellido, edad, carrera);
                estudiantes.put(nombre, estudiante);
                return "Estudiante: " + nombre + " registrado correctamente.";

            case "consultar":
                if(partes.length != 2){
                    return "Error: Formato inválido. Usa: consultar;<nombre>";
                }

                nombre = partes[1];
                if(estudiantes.containsKey(nombre)){
                    Estudiante estudiante_ = estudiantes.get(nombre);
                    return estudiante_.toString();
                } else {
                    return "Error: El estudiante " + nombre + " no está registrado.";
                }
            
            case "listar_estudiantes":
                if(estudiantes.isEmpty()){
                    return "No hay estudiantes registrados.";
                }

                StringBuilder listaEstudiantes = new StringBuilder("Lista de estudiantes registrados:\n");
                for (Estudiante estudiante_ : estudiantes.values()){
                    listaEstudiantes.append(estudiante_.toString()).append("\n");
                }

                return listaEstudiantes.toString();

            case "eliminar":
                if(partes.length != 2){
                    return "Error: Formato inválido. Usa: eliminar;<nombre>";
                }

                nombre = partes[1];
                if(estudiantes.containsKey(nombre)){
                    estudiantes.remove(nombre);
                    return "Estudiante: " + nombre + " eliminado correctamente.";
                } else {
                    return "Error: El estudiante " + nombre + " no está registrado.";
                }
            case "salir":
                System.exit(0);
                return "Saliendo del servidor.";

            default:
                return "Error: Operación no válida.";
        }
    }
}
