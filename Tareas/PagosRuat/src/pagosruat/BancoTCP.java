/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pagosruat;

import java.io.*;
import java.net.*;
import java.rmi.Naming;
import java.util.Arrays;

/**
 *
 * @author Franz Gonzales
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
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                IRuat ruat = (IRuat) Naming.lookup("rmi://localhost/RuatService");

                String request;
                while ((request = in.readLine()) != null) {
                    String[] parts = request.split(":");
                    String command = parts[0];

                    if (command.equals("Deuda")) {
                        String ci = parts[1];
                        Deuda[] deudas = ruat.Buscar(ci);
                        String response = "deudas:" + Arrays.stream(deudas).map(Deuda::toString).reduce((a, b) -> a + ";" + b).orElse("");
                        out.println(response);
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
    }
}