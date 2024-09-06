/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package chatcontabilizarvotos;


/**
 *
 * @author Franz Gonzales
 */


import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;
import org.jgroups.util.Util;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class ChatContabilizarVotos extends ReceiverAdapter {
    JChannel channel;
    private String nombreUsuario;
    
    // almacenamos los votos acumulados para cada candidato
    private final Map<String, Integer> voteResults = new HashMap<>();
    
    // estado de las votaciones por mesas
    final List<String> state = new LinkedList<>();

    public ChatContabilizarVotos(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
        voteResults.put("Juan", 0);
        voteResults.put("Pedro", 0);
        voteResults.put("María", 0);
    }

    public void viewAccepted(View new_view) {
        System.out.println("** Nueva vista: " + new_view);
    }

    public void receive(Message mensaje) {
        // Recibir y procesar el mensaje con los resultados de votación
        String line = (String) mensaje.getObject();
        System.out.println(line);
        
        // Actualizamos el estado con la votación recibida
        synchronized(state) {
            state.add(line);
            actualizarVotos(line);
        }

        // Mostrar los resultados actualizados
        mostrarResultadosActuales();
    }

    public void getState(OutputStream output) throws Exception {
        synchronized(state) {
            Util.objectToStream(state, new DataOutputStream(output));
        }
    }

    @SuppressWarnings("unchecked")
    public void setState(InputStream input) throws Exception {
        List<String> list = (List<String>) Util.objectFromStream(new DataInputStream(input));
        synchronized(state) {
            state.clear();
            state.addAll(list);
            // Actualizamos los votos acumulados con el estado recibido
            for (String str : list) {
                actualizarVotos(str);
            }
        }
        mostrarResultadosActuales();
    }

    private void actualizarVotos(String votacion) {
        // Formato esperado: "Mesa X, Juan 10, Pedro 0, María 2"
        String[] partes = votacion.split(",");
        for (String parte : partes) {
            parte = parte.trim();
            if (parte.startsWith("Juan")) {
                int votos = Integer.parseInt(parte.split(" ")[1]);
                voteResults.put("Juan", voteResults.get("Juan") + votos);
            } else if (parte.startsWith("Pedro")) {
                int votos = Integer.parseInt(parte.split(" ")[1]);
                voteResults.put("Pedro", voteResults.get("Pedro") + votos);
            } else if (parte.startsWith("María")) {
                int votos = Integer.parseInt(parte.split(" ")[1]);
                voteResults.put("María", voteResults.get("María") + votos);
            }
        }
    }

    private void mostrarResultadosActuales() {
        System.out.println("Resultados actuales: {Juan: " + voteResults.get("Juan") + 
                ", Pedro: " + voteResults.get("Pedro") + 
                ", María: " + voteResults.get("María") + "}");
    }

    private void start() throws Exception {
        channel = new JChannel();
        channel.setReceiver(this);
        channel.connect("VotingCluster");
        channel.getState(null, 10000);
        eventLoop();
        channel.close();
    }

    private void eventLoop() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.print("Introduce el resultado de la votación (Ejp. Mesa 1, Juan 10, Pedro 0, María 2): \n");
                String line = in.readLine();
                if (line.startsWith("quit") || line.startsWith("exit")) {
                    break;
                }
                line = "[" + nombreUsuario + "] " + line;
                Message msg = new Message(null, line);
                channel.send(msg);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce tu nombre: ");
        String nombre = sc.next();
        new ChatContabilizarVotos(nombre).start();
    }
}


