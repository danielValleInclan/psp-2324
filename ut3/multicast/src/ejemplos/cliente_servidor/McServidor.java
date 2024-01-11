package ejemplos.cliente_servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class McServidor {
    public static void main(String[] args) throws IOException {
        // flujo de entrada
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        MulticastSocket ms = new MulticastSocket();
        int puerto = 12345;

        // Grupo multicast
        InetAddress grupo = InetAddress.getByName("225.0.0.1");

        String cadena = "";

        while (!cadena.trim().equals("*")){
            System.out.println("Datos a enviar al grupo");
            cadena = in.readLine();
            //Enviando al grupo
            //Se crea el datagrama
            DatagramPacket paquete = new DatagramPacket(cadena.getBytes(), cadena.length(), grupo, puerto);

            // se envia el paquete al grupo
            ms.send(paquete);
        }


        //se cierra el socket
        ms.close();
        System.out.println("Socket cerrado");
    }
}
