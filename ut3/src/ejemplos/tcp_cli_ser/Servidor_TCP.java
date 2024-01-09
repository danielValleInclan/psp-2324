package ejemplos.tcp_cli_ser;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor_TCP {
    public static void main(String[] args) {
        // creacion de servidor
        int puerto = 6000;
        ServerSocket servidor;
        Socket clienteConectado = null;
        try {
            servidor = new ServerSocket(puerto);
            System.out.println("Esperando a cliente ...");
            clienteConectado = servidor.accept();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // flujo de entrada cliente
        InputStream entrada = null;
        try {
            entrada = clienteConectado.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        DataInputStream flujoEntrada = new DataInputStream(entrada);

        // el cliente me envia un mensaje
        try {
            System.out.println("Recibiendo del cliente: \n\t" + flujoEntrada.readUTF());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // flujo de salida cliente
        OutputStream salida = null;
        try {
            salida = clienteConectado.getOutputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        DataOutputStream flujoSalida = new DataOutputStream(salida);

        // saludo al cliente
        try {
            flujoSalida.writeUTF("Saludos al cliente del servidor");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // cerrar stream y sockets
        try {
            entrada.close();
            flujoEntrada.close();
            salida.close();
            flujoSalida.close();
            clienteConectado.close();
            servidor.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
