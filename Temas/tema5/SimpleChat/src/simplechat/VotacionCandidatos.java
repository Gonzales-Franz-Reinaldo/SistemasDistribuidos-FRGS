/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simplechat;

/**
 *
 * @author Franz Gonzales
 */
import org.jgroups.*;
import org.jgroups.util.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author armando
 */
public class VotacionCandidatos extends ReceiverAdapter {

    private List<Integer> totalVotes = new ArrayList<>();

    public VotacionCandidatos() {

        totalVotes.add(0); // Juan
        totalVotes.add(0); // Pedro
        totalVotes.add(0); // Maria
        totalVotes.add(0); // mesa
    }

    public void start(String name) throws Exception {
        JChannel channel = new JChannel();
        channel.setReceiver(this);
        channel.connect("VotingCluster");

        ingresarVotos(channel);

    }

    public void ingresarVotos(JChannel channel) throws IOException, Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("Introduce el resultado de la votación (ej. mesa 1, juan 10,pedro 0,maria 2):");
            String voteInput = in.readLine().toLowerCase();

            Message msg = new Message(null, voteInput);
            channel.send(msg);

            System.out.println("Resultados actuales: Juan=" + totalVotes.get(0) + ", Pedro=" + totalVotes.get(1) + ", Maria=" + totalVotes.get(2));
        }
    }

    @Override
    public void receive(Message msg) {
        String voteData = msg.getObject();
        processVote(voteData);

        System.out.println("Votos actualizados recibidos desde otra mesa-> " + totalVotes.get(3) + " Juan=" + totalVotes.get(0) + ", Pedro=" + totalVotes.get(1) + ", Maria=" + totalVotes.get(2));
    }

    private void processVote(String voteInput) {
        String[] parts = voteInput.split(",");

        for (String part : parts) {
            String[] vote = part.trim().split(" ");
            String candidate = vote[0];
            int votes = Integer.parseInt(vote[1]);

            switch (candidate.toLowerCase()) {
                case "mesa":
                    totalVotes.set(3, totalVotes.get(3) * 0 + votes); // mesa
                    break;
                case "juan":
                    totalVotes.set(0, totalVotes.get(0) + votes); // Juan 
                    break;
                case "pedro":
                    totalVotes.set(1, totalVotes.get(1) + votes); // Pedro 
                    break;
                case "maria":
                    totalVotes.set(2, totalVotes.get(2) + votes); // Maria 
                    break;
                default:
                    System.out.println("Candidato no válido: " + candidate);
                    break;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Introduce tu nombre: ");
        String userName = in.readLine();
        new VotacionCandidatos().start(userName);
    }
}
