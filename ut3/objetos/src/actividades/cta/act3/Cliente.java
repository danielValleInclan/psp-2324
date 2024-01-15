package actividades.cta.act3;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
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

            byte[] recibidos = new byte[1024];
            DatagramPacket paqRecibido = new DatagramPacket(recibidos, recibidos.length);
            socket.receive(paqRecibido);//recibo datagrama
            ByteArrayInputStream bais = new ByteArrayInputStream(recibidos);
            ObjectInputStream in = new ObjectInputStream(bais);
            Alumno alumno = (Alumno) in.readObject();

            in.close();

            System.out.println("Recibido -> \n" +
                    "Nombre: " + alumno.getNombre() +
                    "Nota: " + alumno.getNota() +
                    "Curso: " + alumno.getCurso());
            socket.close();
        } while (!idalumno.equals("*"));
    }
}
