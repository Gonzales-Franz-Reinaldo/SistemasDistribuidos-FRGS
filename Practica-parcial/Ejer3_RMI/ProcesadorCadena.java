package Ejer3_RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ProcesadorCadena extends UnicastRemoteObject implements IProcesadorCadena {

    private String cadenaActual;

    public ProcesadorCadena() throws RemoteException {
        super();
        this.cadenaActual = "";
    }
    

    @Override
    public boolean introducirCadena(String cadena) throws RemoteException{
        if(cadena != null){
            cadenaActual = cadena;
            return true;
        }

        return false;
    }

    @Override
    public String invertirCadena() throws RemoteException{
        // String invertida = "";

        // for (int i = cadenaActual.length() - 1; i >= 0; i--){
        //     invertida += cadenaActual.charAt(i);
        // }

        // return invertida;

        StringBuilder invertida = new StringBuilder(cadenaActual);
        return invertida.reverse().toString();
    }

    @Override
    public String aumentarEspacios(int cantidad) throws RemoteException{

        // String aumentada = "";

        // for (int i = 0; i < cadenaActual.length(); i++){
        //     aumentada += cadenaActual.charAt(i);

        //     for (int j = 0; j < cantidad; j++){
        //         aumentada += " ";
        //     }
        // }

        // return aumentada;

        if (cantidad < 0) return cadenaActual; 

        StringBuilder sb = new StringBuilder();
        for(char c : cadenaActual.toCharArray()){
            sb.append(c);
            for(int i = 0; i < cantidad; i++){
                sb.append(" ");
            }
        }

        return sb.toString().trim();
    }

    @Override
    public String aumentar(String cadena) throws RemoteException{

        // return cadenaActual + cadena;
        if(cadena != null){
            cadenaActual += cadena;
            return cadenaActual;
        }

        return cadenaActual;
    }

}
