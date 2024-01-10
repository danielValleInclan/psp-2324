package actividades.actividad3_2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) throws IOException {
        int puerto = 6000;
        ServerSocket servidor = new ServerSocket(puerto);
        System.out.println("Escuchando en " + servidor.getLocalPort());

        Socket cliente1 = servidor.accept();
        Socket cliente2 = servidor.accept();

        System.out.println("Puerto remoto del cliente 1: " + cliente1.getPort() + " puerto local: " + cliente1.getLocalPort());
        System.out.println("Puerto remoto del cliente 2: " + cliente2.getPort() + " puerto local: " + cliente2.getLocalPort());

        cliente2.close();
        cliente1.close();
        servidor.close();
    }
}
