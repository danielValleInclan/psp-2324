package actividades.actividad3_2;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Cliente1 {
    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int puerto = 6000;

        System.out.println("Programa cliente iniciado ...");
        Socket cliente = new Socket(host, puerto);

        InetAddress i = cliente.getInetAddress();

        System.out.println("Puerto remoto: " + cliente.getPort());
        System.out.println("Puerto local: " + cliente.getLocalPort());
        System.out.println("IP del host remoto: " + i.getHostAddress().toString());

        cliente.close();
    }
}
