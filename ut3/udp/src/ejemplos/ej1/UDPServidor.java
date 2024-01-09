package ejemplos.ej1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServidor {
    public static void main(String[] args) throws IOException {
        byte[] bufer = new byte[1024];
        DatagramSocket socket = new DatagramSocket(12345);

        //Esperando datagrama
        System.out.println("Esperando datagrama ...");
        DatagramPacket recibo = new DatagramPacket(bufer, bufer.length);
        socket.receive(recibo);//recibo datagrama
        int bytesRec = recibo.getLength(); // número de bytes
        String paquete = new String(recibo.getData());

        // Visualizo información
        System.out.println("Número de bytes recibido: " + bytesRec);
        System.out.println("Contenido del paquete: " + paquete.trim());
        System.out.println("Puerto origen del mensaje: " + recibo.getPort());
        System.out.println("IP de origen: " + recibo.getAddress().getHostAddress());
        System.out.println("Puerto destino del mensaje: " + socket.getLocalPort());
        socket.close();
    }
}
