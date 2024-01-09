package ejemplos.tcp_cli_ser;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente_TCP {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 6000;

        System.out.println("Programa cliente iniciado ...");
        Socket cliente;
        try {
            cliente = new Socket(host, puerto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // flujo salida al servidor
        DataOutputStream flujoSalida;
        try {
            flujoSalida = new DataOutputStream(cliente.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // saludo a servidor
        try {
            flujoSalida.writeUTF("SALUDO AL SERVIDOR DESDE CLIENTE");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // flujo de entrada al servidor
        DataInputStream flujoEntrada;
        try {
            flujoEntrada = new DataInputStream(cliente.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // servidor me envia un mensaje
        try {
            System.out.println("Recibiendo del Servidor: \n\t" + flujoEntrada.readUTF());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // cerrar streams y sockets
        try {
            flujoEntrada.close();
            flujoSalida.close();
            cliente.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
