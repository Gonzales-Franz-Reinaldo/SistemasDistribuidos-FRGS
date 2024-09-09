/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package combinado;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author pablo
 */
public class ClienteTCP {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int port = 5002;
            Socket client = new Socket("localhost", port);
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String operacion = "";
            while (!operacion.equals("3")) {
                System.out.println("1.-Deuda");
                System.out.println("2.-Pagar");
                System.out.println("3.-Salir");
                operacion = sc.next();
                if (operacion.equals("1")) {
                    System.out.println("Introduzca El CI");
                    String n = sc.next();
                    toServer.println("Deuda:" + n);
                    String deudas = fromServer.readLine(); //1
                    System.out.println("Las deudas con el Ci: " + n + " son");
                    String[] partes = deudas.split(":");
                    String deudasSinTermino = partes[1];
                    String[] deudasArray = deudasSinTermino.split(";");
                    for (String deudasI : deudasArray) {
                        String[] detalleDeuda = deudasI.split(",");
                        System.out.println("Anio:" + detalleDeuda[0]);
                        System.out.println("Impuesto:" + detalleDeuda[1]);
                        System.out.println("Monto:" + detalleDeuda[2]);
                        System.out.println("");
                    }
                } else if (operacion.equals("2")) {
                    System.out.println("Introduzca El CI");
                    String ci = sc.next();
                    System.out.println("Introduzca El anio");
                    String anio = sc.next();
                    System.out.println("Introduzca El impuesto");
                    String impuesto = sc.next();
                    System.out.println("Introduzca El monto");
                    String monto = sc.next();
                    toServer.println("Pagar:" + ci + "," + anio + "," + impuesto + "," + monto + ","); //2
                    String pago = fromServer.readLine();
                    System.out.println("Transaccion:" + pago);
                    
                    System.out.println("Llega aqui");
                    if (pago.equals("true")){
                        System.out.println("Se pudo realizar el pago");
                    }else {
                        System.out.println("No se pudo realizar el pago");
                    }
                }
            }
            client.close();
            System.out.println("Conexión cerrada.");

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
