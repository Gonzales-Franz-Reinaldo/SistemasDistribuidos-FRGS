/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestioestudianteudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Franz Gonzales
 */
public class UniversidadServer {
    private static List<Estudiante> estudiantes = new ArrayList<>();

    static {
        estudiantes.add(new Estudiante("123456", "Juan Perez", "Ingeniería"));
        estudiantes.add(new Estudiante("654321", "Maria Lopez", "Medicina"));
        estudiantes.add(new Estudiante("112233", "Carlos Gomez", "Derecho"));
    }

    public static void main(String[] args) throws IOException{
        
        DatagramSocket socketUDP = new DatagramSocket(6789);
        byte[] buffer = new byte[1024];
        System.out.println("Servidor UDP conectado.");
    
        while(true){
            // Recibimos datagrama
            DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);
            socketUDP.receive(peticion);
            
            String mensaje = new String(peticion.getData(), 0, peticion.getLength());
            String[] partes = mensaje.split(";");
            String accion = partes[0];
            
            String respuesta = "";
            
            if (accion.equals("buscar")) {
                String ci = partes[1];
                respuesta = buscarEstudiante(ci);
            } else if (accion.equals("eliminar")) {
                String ci = partes[1];
                respuesta = eliminarEstudiante(ci);
            } else if (accion.equals("mostrar")) {
                respuesta = mostrarEstudiantes();
            }
            
            byte[] respuestaBytes = respuesta.getBytes();
            DatagramPacket respuestaPaquete = new DatagramPacket(respuestaBytes, respuestaBytes.length, peticion.getAddress(), peticion.getPort());
            socketUDP.send(respuestaPaquete);
        }
    }
    
    
    private static String buscarEstudiante(String ci) {
        for (Estudiante est : estudiantes) {
            if (est.ci.equals(ci)) {
                return est.toString();
            }
        }
        return "Estudiante no encontrado.";
    }

    private static String eliminarEstudiante(String ci) {
        for (Estudiante est : estudiantes) {
            if (est.ci.equals(ci)) {
                estudiantes.remove(est);
                return "Estudiante eliminado.";
            }
        }
        return "Estudiante no encontrado.";
    }

    private static String mostrarEstudiantes() {
        if (estudiantes.isEmpty()) {
            return "No hay estudiantes registrados.";
        }
        StringBuilder sb = new StringBuilder();
        for (Estudiante est : estudiantes) {
            sb.append(est).append("\n");
        }
        return sb.toString();
    }
}
