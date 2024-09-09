/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pagosruat;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Franz Gonzales
 */
    
public class Ruat extends UnicastRemoteObject implements IRuat {
    private List<Deuda> listaDeudas;
    private ClienteRuatUDP clienteRuatUDP;

    public Ruat() throws RemoteException {
        super();
        listaDeudas = new ArrayList<>();
        listaDeudas.add(new Deuda("1234567", 2022, Impuesto.Vehiculo, 2451));
        listaDeudas.add(new Deuda("1234567", 2022, Impuesto.Casa, 2500));
        listaDeudas.add(new Deuda("555587", 2021, Impuesto.Vehiculo, 5000));
        listaDeudas.add(new Deuda("333357", 2023, Impuesto.Casa, 24547));

        clienteRuatUDP = new ClienteRuatUDP("localhost", 9876);
    }

    @Override
    public Deuda[] Buscar(String ci) throws RemoteException {
        List<Deuda> resultado = new ArrayList<>();
        for (Deuda deuda : listaDeudas) {
            if (deuda.getCi().equals(ci)) {
                resultado.add(deuda);
            }
        }
        return resultado.toArray(new Deuda[resultado.size()]);
    }

    @Override
    public Boolean Pagar(Deuda deuda) throws RemoteException {
        try {
            String resultado = clienteRuatUDP.consultarAlcaldia(deuda.getCi());
            return resultado.equals("true");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
