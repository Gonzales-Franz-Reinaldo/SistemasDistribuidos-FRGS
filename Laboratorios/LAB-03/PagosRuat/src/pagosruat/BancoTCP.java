package pagosruat;

import java.io.*;
import java.net.*;
import java.rmi.Naming;
import java.sql.*;
import java.util.Arrays;

/**
 * Servidor TCP del Banco
 */
public class BancoTCP {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            System.out.println("Servidor Banco en ejecución...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try (Connection connection = ConnectionDB.getConnection()) {
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                IRuat ruat = (IRuat) Naming.lookup("rmi://localhost/RuatService");

                String request;
                while ((request = in.readLine()) != null) {
                    String[] parts = request.split(":");
                    String command = parts[0];

                    if (command.equals("Deuda")) {
                        String ci = parts[1];
                        out.println(buscarDeudas(ci, connection));
                    } else if (command.equals("Pagar")) {
                        String[] params = parts[1].split(",");
                        Deuda deuda = new Deuda(params[0], Integer.parseInt(params[1]), Impuesto.valueOf(params[2]), Double.parseDouble(params[3]));
                        boolean result = ruat.Pagar(deuda);
                        out.println("transacción:" + result);
                    }
                }
                clientSocket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private String buscarDeudas(String ci, Connection connection) {
            StringBuilder resultado = new StringBuilder("deudas:");
            try {
                String query = "SELECT d.anio, i.tipo, d.monto FROM Deudas d JOIN Impuestos i ON d.impuesto_id = i.id WHERE d.ci = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, ci);
                ResultSet rs = statement.executeQuery();

                while (rs.next()) {
                    resultado.append(rs.getInt("anio")).append(",")
                            .append(rs.getString("tipo")).append(",")
                            .append(rs.getDouble("monto")).append(";");
                }
                if (resultado.length() == 7) resultado.append("No se encontraron deudas."); // No hay deudas
            } catch (SQLException e) {
                e.printStackTrace();
                return "Error al buscar deudas";
            }
            return resultado.toString();
        }
    }
}
