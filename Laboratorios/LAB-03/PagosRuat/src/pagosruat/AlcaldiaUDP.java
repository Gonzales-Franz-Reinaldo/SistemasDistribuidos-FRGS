package pagosruat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servidor UDP de la Alcaldía
 */
public class AlcaldiaUDP {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(9876);
            byte[] bufferReceive = new byte[1024];

            System.out.println("Servidor de Alcaldía en ejecución...");

            while (true) {
                DatagramPacket packetReceive = new DatagramPacket(bufferReceive, bufferReceive.length);
                socket.receive(packetReceive);
                String solicitud = new String(packetReceive.getData()).trim();
                String respuesta;

                if (solicitud.startsWith("consulta:")) {
                    String ci = solicitud.split(":")[1];
                    respuesta = consultarObservacion(ci);
                    byte[] bufferSend = respuesta.getBytes();
                    DatagramPacket packetSend = new DatagramPacket(bufferSend, bufferSend.length, packetReceive.getAddress(), packetReceive.getPort());
                    socket.send(packetSend);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String consultarObservacion(String ci) {
        try (Connection connection = ConnectionDB.getConnection()) {
            String query = "SELECT observado FROM Observaciones WHERE ci = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, ci);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getBoolean("observado") ? "false" : "true"; // Devuelve "false" si está observado
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "true"; // Por defecto, no observado
    }
}
