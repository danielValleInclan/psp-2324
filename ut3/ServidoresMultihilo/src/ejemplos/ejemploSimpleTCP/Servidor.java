package ejemplos.ejemploSimpleTCP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class Servidor {
    public static void main(String[] args)  {
        ServerSocket servidor;
        try {
            servidor = new ServerSocket(6003);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Servidor iniciado...");

        while (true){
            Socket cliente = null;
            try {
                cliente = servidor.accept();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            HiloServidor hiloServidor = new HiloServidor(cliente);
            hiloServidor.start();// se atiende al cliente
        }
    }
}
