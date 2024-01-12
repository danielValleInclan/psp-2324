package actividades.actividad3_8;

import ejemplos.Persona;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;

public class UDPObjetoCliente {
    public static void main(String[] args) throws IOException {
        InetAddress destino = InetAddress.getLocalHost();
        int port = 12345;
        Persona persona = new Persona("Daniel", 14);

        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bs);
        out.writeObject(persona);
        
        byte[] mensaje = bs.toByteArray();

        // Construyo el datagrama a enviar
        DatagramPacket envio = new DatagramPacket(mensaje, mensaje.length, destino, port);
        DatagramSocket socket = new DatagramSocket(34567); // Puerto local

        //Envio datagrama
        socket.send(envio);
        System.out.println("Enviado -> " + persona.getNombre() + " " + persona.getEdad());

        bs.close();
        out.close();
        socket.close();

    }
}
