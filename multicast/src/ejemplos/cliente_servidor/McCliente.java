package ejemplos.cliente_servidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class McCliente {
    public static void main(String[] args) throws IOException {
        // se crea el socket
        MulticastSocket ms = new MulticastSocket(12345);

        //Se configura la ip del grupo al que nos conectamos
        InetAddress grupo = InetAddress.getByName("225.0.0.1");

        //Se une al grupo
        ms.joinGroup(grupo);

        String msg = "";

        while (!msg.trim().equals("*")){
            //Recibe el paquete del servidor multicast
            byte[] buf = new byte[1000];
            DatagramPacket recibido = new DatagramPacket(buf, buf.length);
            ms.receive(recibido);

            msg = new String(recibido.getData());
            System.out.println("Recibido: "+ msg.trim());
        }

        // Abandona el grupo multicast
        ms.leaveGroup(grupo);

        //cierra el socket
        ms.close();
        System.out.println("Socket cerrado");
    }
}
