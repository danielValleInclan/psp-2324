package actividades.actividad3_8;

import ejemplos.Persona;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;
import java.util.Scanner;

public class UDPObjetoCliente {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        InetAddress destino = InetAddress.getLocalHost();
        int port = 12345;
        Persona persona = new Persona("Daniel", 14);
        DatagramSocket socket = new DatagramSocket(34567); // Puerto local

        while (!persona.getNombre().equals("salir")){
            ByteArrayOutputStream bs = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bs);
            System.out.print("Nombre: ");
            persona.setNombre(sc.next());
            if (persona.getNombre().equals("salir")) {
                break; // exit the loop if the input is "salir"
            }
            System.out.print("Edad: ");
            persona.setEdad(sc.nextInt());


            out.writeObject(persona);

            byte[] mensaje = bs.toByteArray();

            // Construyo el datagrama a enviar
            DatagramPacket envio = new DatagramPacket(mensaje, mensaje.length, destino, port);

            //Envio datagrama
            socket.send(envio);
            System.out.println("Enviado -> " + persona.getNombre() + " " + persona.getEdad());
            bs.close();
            out.close();
        }
        socket.close();

    }
}
