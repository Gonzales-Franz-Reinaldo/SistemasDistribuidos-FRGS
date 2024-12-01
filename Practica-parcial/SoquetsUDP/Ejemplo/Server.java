package SoquetsUDP.Ejemplo;

import java.net.*;

public class Server {
    
    public static void main(String[] args) {

        int port = 8000;
        byte[] buffer = new byte[1024];

        try {

            DatagramSocket socket = new DatagramSocket(port);
            System.out.println("Servidor UDP iniciado en el puerto " + port);

            while (true) {
                // Recibir datagrama del cliente
                DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);
                socket.receive(peticion);

                // Leer mensaje del cliente
                String mensaje = new String(peticion.getData(), 0, peticion.getLength());
                System.out.println("Mensaje del cliente: " + mensaje);

                // Processar el mensaje
                int numero;
                String respuesta;

                try{
                    numero = Integer.parseInt(mensaje);
                    respuesta = "El cuadrado de " + numero + " es " + (numero * numero);
                } catch (Exception e) {
                    respuesta = "Error: Debes enviar un número entero.";
                }

                // Enviar respuesta al cliente
                byte[] bufferRespuesta = respuesta.getBytes();
                DatagramPacket respuestaPacket = new DatagramPacket(bufferRespuesta, bufferRespuesta.length, peticion.getAddress(), peticion.getPort());

                socket.send(respuestaPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
