/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package combinado;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author pablo
 */
public class ServidorTCP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Operaciones operaciones = new Operaciones();
        Banco banco = new Banco();
        int port = 5002;
        ServerSocket server;
        try {
            
            server = new ServerSocket(port);    
            System.out.println("Se inicio el servidor con exito ");
            while(true){
                Socket client;
                PrintStream toClient;
                client = server.accept();
                BufferedReader fromCliente = new BufferedReader(new InputStreamReader(client.getInputStream()));
                System.out.println("Cliente se conecto");
                String respuesta = "";
                while(true){
                    //String operacion = fromCliente.readLine();
                    String pedido = fromCliente.readLine();
                    System.out.println(pedido);
                    toClient = new PrintStream(client.getOutputStream());
                    banco.dividirPedido(pedido);
                    System.out.println("LLega1");
                    try {
                        IRuat2 ruatRMI;
                        ruatRMI = (IRuat2)Naming.lookup("rmi://localhost/Ruat"); // instanciar un objeto remoto
                        System.out.println("LLega2");
                        if (banco.getFuncion().equalsIgnoreCase("Deuda")){
                            System.out.println("LLegaDeuda");
                           ArrayList<Deuda> deudas = ruatRMI.ConsultarDeuda(banco.getCi());
                            System.out.println("Imprime las deudas");
                            System.out.println(deudas);
                           respuesta = "deudas:";
                            for (Deuda deuda : deudas) {
                                respuesta += deuda.getAnio() + ",";
                                respuesta += deuda.getImpuesto() + ",";
                                respuesta += deuda.getMonto() + ";";
                            }
                        }else if (banco.getFuncion().equalsIgnoreCase("Pagar")){
                            System.out.println("LLegaPegar");
                            Deuda deuda = new Deuda(banco.getCi(), banco.getAnio(), banco.getImpuesto(), banco.getMonto());
                            boolean aux = ruatRMI.PagarDeuda(deuda);
                            System.out.println(aux);
                            if (aux){
                                System.out.println("Llego aqui ya que no tiene observaciones");
                                respuesta = "false";
                            }else{
                                System.out.println("LLega aqui ya que tiene observaciones");
                                respuesta = "true";
                            }
                            
                        }else{
                            respuesta = "funcion no valida!!";
                        }
                        
                        toClient.println(String.valueOf(respuesta));
                    } catch (NotBoundException ex) {
                        Logger.getLogger(ServidorTCP.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (MalformedURLException ex) {
                        Logger.getLogger(ServidorTCP.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (RemoteException ex) {
                        Logger.getLogger(ServidorTCP.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } 
            }   
        } catch (IOException ex) {
            System.out.println(ex);
        }
    } 
}
