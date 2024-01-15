package actividades.cta.act3;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        InetAddress destino = InetAddress.getLocalHost();
        int port = 12345;
        byte[] mensaje;

        String idalumno = "";
        do {
            System.out.println("Introduce el id del alumno (* para salir)");
            idalumno = sc.next();

            mensaje = idalumno.getBytes();
            DatagramPacket envio = new DatagramPacket(mensaje, mensaje.length, destino, port);
            DatagramSocket socket = new DatagramSocket(34567); // Puerto local

            socket.send(envio);
            socket.close();
        } while (!idalumno.equals("*"));
    }
}
