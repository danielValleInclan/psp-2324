package ejemplos.ejemploSimpleTCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class Cliente {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 6003;
        Socket cliente;
        PrintWriter fsalida;
        BufferedReader fentrada, in;
        try {
            cliente = new Socket(host, puerto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Se crean los flujos de entrada y salida
        try {
            fsalida = new PrintWriter(cliente.getOutputStream(), true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fentrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Flujo para entrada estandar
        in = new BufferedReader(new InputStreamReader(System.in));
        String cadena, eco = "";

        do {
            System.out.print("Introducción cadena: ");
            try {
                cadena = in.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            fsalida.println(cadena); // envio cadena al servidor
            try {
                eco = fentrada.readLine(); // recibo cadena del servidor
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("    =>ECO: " + eco);
        } while (!cadena.trim().equals("*"));

        fsalida.close();
        try {
            fentrada.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("FIN DEL ENVIO ...");
        try {
            in.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            cliente.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
