package actividades.actividad3_8;

import ejemplos.Persona;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPObjetoServidor {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        byte[] bufer = new byte[1024];
        DatagramSocket socket = new DatagramSocket(12345);
        System.out.println("Esperando datagrama ...");
        DatagramPacket recibo = new DatagramPacket(bufer, bufer.length);
        socket.receive(recibo);//recibo datagrama

        ByteArrayInputStream bais = new ByteArrayInputStream(bufer);
        ObjectInputStream in = new ObjectInputStream(bais);
        Persona persona = (Persona) in.readObject();

        System.out.println("Nombre: " + persona.getNombre() + " Edad: " + persona.getEdad());

        in.close();
    }
}
