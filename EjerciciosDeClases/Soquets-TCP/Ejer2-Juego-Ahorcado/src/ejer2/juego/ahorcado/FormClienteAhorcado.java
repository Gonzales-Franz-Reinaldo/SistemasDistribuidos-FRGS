package ejer2.juego.ahorcado;

import java.io.OutputStreamWriter;
import java.net.Socket;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author Franz Gonzales
 */
public class FormClienteAhorcado extends javax.swing.JDialog {

    private Socket client;
    private BufferedReader fromServer;
    private PrintWriter toServer;

    /**
     * Creates new form FormClienteAhorcado
     */
    public FormClienteAhorcado(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initSocket();
    }

    private void initSocket() {
        try {
            client = new Socket("localhost", 5002);
            fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
            toServer = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));

            String estadoInicial = fromServer.readLine();
            mostrar_estadoPalabra.setText(estadoInicial);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No se pudo conectar al servidor.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ingresar_letra = new java.awt.TextField();
        button_ingresarLetra = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        mostrar_mensajeCorreccion = new javax.swing.JTextArea();
        resultado_juego = new javax.swing.JOptionPane();
        mostrar_titulo_bienvenida = new javax.swing.JLabel();
        puntaje_errores = new java.awt.Label();
        jScrollPane2 = new javax.swing.JScrollPane();
        mostrar_estadoPalabra = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 255, 51));

        ingresar_letra.setText("letra");

        button_ingresarLetra.setBackground(new java.awt.Color(0, 153, 0));
        button_ingresarLetra.setForeground(new java.awt.Color(255, 255, 51));
        button_ingresarLetra.setText("Ingresar letra");

        mostrar_mensajeCorreccion.setColumns(20);
        mostrar_mensajeCorreccion.setRows(5);
        jScrollPane1.setViewportView(mostrar_mensajeCorreccion);

        mostrar_titulo_bienvenida.setBackground(new java.awt.Color(0, 204, 153));
        mostrar_titulo_bienvenida.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        mostrar_titulo_bienvenida.setForeground(new java.awt.Color(51, 0, 51));
        mostrar_titulo_bienvenida.setText("JUEGO DEL AHORCADO");

        puntaje_errores.setBackground(new java.awt.Color(255, 102, 102));
        puntaje_errores.setText("label1");

        mostrar_estadoPalabra.setColumns(20);
        mostrar_estadoPalabra.setRows(5);
        jScrollPane2.setViewportView(mostrar_estadoPalabra);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(147, 147, 147)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(120, 120, 120)
                            .addComponent(resultado_juego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(ingresar_letra, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(51, 51, 51)
                            .addComponent(button_ingresarLetra, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(puntaje_errores, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 68, Short.MAX_VALUE)
                .addComponent(mostrar_titulo_bienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(mostrar_titulo_bienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(puntaje_errores, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ingresar_letra, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(button_ingresarLetra, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(resultado_juego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void initComponent() {
        // Tu código de diseño generado por el Form Editor, no lo repito para ahorrar espacio
        // ...

        // Añadir el ActionListener al botón para enviar la letra
        button_ingresarLetra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                enviarLetra();
            }
        });
    }

    /**
     * Envía la letra ingresada por el usuario al servidor.
     */
    private void enviarLetra() {
        String letra = ingresar_letra.getText();

        if (letra.isEmpty() || letra.length() > 1) {
            JOptionPane.showMessageDialog(this, "Por favor, introduce solo una letra.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Enviar la letra al servidor
        toServer.println(letra);

        // Leer la respuesta del servidor
        try {
            String estadoPalabra = fromServer.readLine();
            String mensajeCorreccion = fromServer.readLine();
            String errores = fromServer.readLine();
            String resultadoJuego = fromServer.readLine();

            // Actualizar la interfaz gráfica con la nueva información
            mostrar_estadoPalabra.setText(estadoPalabra);
            mostrar_mensajeCorreccion.setText(mensajeCorreccion);
            puntaje_errores.setText("Errores: " + errores);

            // Verificar si el juego ha terminado
            if (!resultadoJuego.equals("CONTINUA")) {
                resultado_juego.showMessageDialog(this, resultadoJuego);
                // Cerrar conexión al finalizar el juego
                client.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Enviar la letra al servidor
        toServer.println(letra);

        // Limpia el campo de texto
        ingresar_letra.setText("");
    }

    /**
     * This method is called when the window is closed.
     */
    @Override
    public void dispose() {
        try {
            if (client != null && !client.isClosed()) {
                client.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.dispose();
    }

    private class Listener implements Runnable {

        @Override
        public void run() {
            try {
                String response;
                while ((response = fromServer.readLine()) != null) {
                    // Procesa la respuesta del servidor, podría ser el estado de la palabra o un mensaje de corrección
                    procesarRespuestaServidor(response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void procesarRespuestaServidor(String response) {
        if (response.startsWith("PALABRA")) {
            // La respuesta contiene el estado de la palabra
            String estadoPalabra = response.substring(8); // Omite el prefijo "PALABRA "
            mostrar_estadoPalabra.setText(estadoPalabra);

        } else if (response.startsWith("CORRECCION")) {
            // La respuesta contiene una corrección o resultado
            String mensajeCorreccion = response.substring(11); // Omite el prefijo "CORRECCION "
            mostrar_mensajeCorreccion.append(mensajeCorreccion + "\n");

        } else if (response.startsWith("PUNTAJE")) {
            // La respuesta contiene el puntaje o errores
            String errores = response.substring(8); // Omite el prefijo "PUNTAJE "
            puntaje_errores.setText(errores);

        } else if (response.startsWith("GANADO") || response.startsWith("PERDIDO")) {
            // El juego ha terminado, muestra un mensaje emergente
            resultado_juego.showMessageDialog(this, response);
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormClienteAhorcado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormClienteAhorcado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormClienteAhorcado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormClienteAhorcado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormClienteAhorcado dialog = new FormClienteAhorcado(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_ingresarLetra;
    private java.awt.TextField ingresar_letra;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea mostrar_estadoPalabra;
    private javax.swing.JTextArea mostrar_mensajeCorreccion;
    private javax.swing.JLabel mostrar_titulo_bienvenida;
    private java.awt.Label puntaje_errores;
    private javax.swing.JOptionPane resultado_juego;
    // End of variables declaration//GEN-END:variables
}