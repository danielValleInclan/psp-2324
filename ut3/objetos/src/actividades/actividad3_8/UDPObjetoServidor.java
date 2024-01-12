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
        byte[] recibidos = new byte[1024];
        DatagramSocket socket = new DatagramSocket(12345);
        System.out.println("Esperando datagrama ...");


        String name = "";
        while (!name.equals("salir")){
            DatagramPacket paqRecibidos = new DatagramPacket(recibidos, recibidos.length);
            socket.receive(paqRecibidos);//recibo datagrama
            // Convertir los bytes a objeto
            ByteArrayInputStream bais = new ByteArrayInputStream(recibidos);
            ObjectInputStream in = new ObjectInputStream(bais);
            Persona persona = (Persona) in.readObject();
            name = persona.getNombre();
            in.close();
            System.out.println("Nombre: " + persona.getNombre() + " Edad: " + persona.getEdad());
        }
        socket.close();
    }
}
