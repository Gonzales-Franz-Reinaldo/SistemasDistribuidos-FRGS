/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pagosruat;

import java.io.*;
import java.net.*;

/**
 *
 * @author Franz Gonzales
 */

public class UsuarioTCP {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 9999);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Ingrese el comando (Deuda:ci o Pagar:ci,anio,impuesto,monto):");
            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                String response = in.readLine();
                System.out.println("Respuesta del servidor: " + response);
                System.out.println("Ingrese el siguiente comando:");
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
