package ejemplos.ej1;

import java.io.IOException;
import java.net.*;

public class UDPCliente {
    public static void main(String[] args) throws IOException {
        InetAddress destino = InetAddress.getLocalHost();
        int port = 12345;
        byte[] mensaje = new byte[1024];
        String saludo = "Enviando saludo";
        mensaje = saludo.getBytes();

        // Construyo el datagrama a enviar
        DatagramPacket envio = new DatagramPacket(mensaje, mensaje.length, destino, port);
        DatagramSocket socket = new DatagramSocket(34567); // Puerto local

        System.out.println("Enviado datagrama de longitud: " + mensaje.length);
        System.out.println("Host de destino: " + destino.getHostName());
        System.out.println("IP de destino: " + destino.getHostAddress());
        System.out.println("Puerto local del socket: " + socket.getLocalPort());
        System.out.println("Puerto al que envio: " + envio.getPort());

        //Envio datagrama
        socket.send(envio);
        socket.close();
    }
}
