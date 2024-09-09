package pagosruat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class UsuarioGUI extends JFrame {
    private JTextField ciField;
    private JTextArea resultArea;
    private JButton consultarButton, pagarButton;
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public UsuarioGUI() {
        setTitle("Sistema de Pago RUAT");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel ciLabel = new JLabel("Ingrese CI:");
        ciField = new JTextField(15);
        consultarButton = new JButton("Consultar Deudas");
        pagarButton = new JButton("Pagar Deuda");
        resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false);

        add(ciLabel);
        add(ciField);
        add(consultarButton);
        add(pagarButton);
        add(new JScrollPane(resultArea));

        // Acciones de botones
        consultarButton.addActionListener(e -> consultarDeudas());
        pagarButton.addActionListener(e -> pagarDeuda());

        // Conexión al servidor TCP
        try {
            socket = new Socket("localhost", 9999);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void consultarDeudas() {
        String ci = ciField.getText();
        if (!ci.isEmpty()) {
            out.println("Deuda:" + ci);
            try {
                String response = in.readLine();
                resultArea.setText("Deudas encontradas:\n" + response);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese un CI válido");
        }
    }

    private void pagarDeuda() {
        String ci = ciField.getText();
        String deuda = JOptionPane.showInputDialog(this, "Ingrese el formato de deuda para pagar (ci,anio,impuesto,monto):");
        if (!ci.isEmpty() && deuda != null && !deuda.isEmpty()) {
            out.println("Pagar:" + deuda);
            try {
                String response = in.readLine();
                resultArea.setText("Resultado del pago:\n" + response);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese datos válidos");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UsuarioGUI gui = new UsuarioGUI();
            gui.setVisible(true);
        });
    }
}
