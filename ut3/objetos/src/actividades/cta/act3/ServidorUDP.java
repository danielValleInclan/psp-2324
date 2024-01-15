package actividades.cta.act3;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class ServidorUDP {
    public static void main(String[] args) throws IOException {
        Curso curso1 = new Curso("id1", "Informática");
        Curso curso2 = new Curso("id2", "Robotica");
        Curso curso3 = new Curso("id3", "Matemáticas");
        Alumno[] alumnos = {new Alumno("id1", "Daniel", curso1, 7),
                new Alumno("id2", "David", curso1, 5),
                new Alumno("id3", "Pablo", curso2, 8),
                new Alumno("id4", "Manuel", curso3, 3),
                new Alumno("id5", "Sara", curso3, 9)};


        byte[] recibidos = new byte[1024];
        DatagramSocket socket = new DatagramSocket(12345);
        System.out.println("Esperando datagrama ...");

        while (true){
            DatagramPacket paqRecibidos = new DatagramPacket(recibidos, recibidos.length);
            socket.receive(paqRecibidos);//recibo datagrama

            String idalumno = new String(paqRecibidos.getData(), 0, paqRecibidos.getLength());
            System.out.println("Id Alumno recibido: " + idalumno.trim());
            System.out.println("Puerto origen del mensaje: " + paqRecibidos.getPort());


            for (Alumno a : alumnos){
                if (a.getIdalumno().equals(idalumno)) {
                    System.out.println("Enviando objeto Alumno al cliente");
                    ByteArrayOutputStream bs = new ByteArrayOutputStream();
                    ObjectOutputStream out = new ObjectOutputStream(bs);
                    out.writeObject(a);

                    byte[] mensaje = bs.toByteArray();

                    // Construyo el datagrama a enviar
                    DatagramPacket envio = new DatagramPacket(mensaje, mensaje.length, InetAddress.getLocalHost(), paqRecibidos.getPort());

                    //Envio datagrama
                    socket.send(envio);
                    bs.close();
                    out.close();
                    break;
                }
            }
            System.out.println("No se ha encontrado ningún alumno con dicho id");
        }
    }
}
