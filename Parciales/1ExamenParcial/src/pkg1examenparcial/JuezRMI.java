/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg1examenparcial;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
/**
 *
 * @author Franz Gonzales
 */
public class JuezRMI {
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            ICuenta cuenta = (ICuenta) registry.lookup("Cuenta");
            
            int opcion = 0;
            while(opcion != 3){
                
                System.out.println("1. Consultar cuentas");
                System.out.println("2. Retener Monto.");
                System.out.println("3. Salir");
                
                opcion = scanner.nextInt();
                scanner.nextLine();
                
                switch(opcion){
                    case 1: 
                        System.out.print("CI: ");
                        String ci = scanner.nextLine();
                        
                        System.out.print("Nombres: ");
                        String nombres = scanner.nextLine();
                        
                        System.out.print("Apellidos: ");
                        String apellidos = scanner.nextLine();
                        
                        cuenta.consultarCuenta(ci, nombres, apellidos);
                        break;
                    case 2:
                        System.out.print("Selecciona el banco 1):BancoMercantil/2):BancoBCP");
                        int num = scanner.nextInt();
                        scanner.nextLine();
                        
                        System.out.print("Elija el monto: ");
                        double monto = scanner.nextDouble();
                        scanner.nextLine();
                        
                        Banco banco;
                        if(num ==1){
                            banco = Banco.Mercantil; 
                        }else{
                            banco = Banco.BancoBCP; 
                        }
                        
                        cuenta.retenerMonto(cuenta, monto);

                        break;
               }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
