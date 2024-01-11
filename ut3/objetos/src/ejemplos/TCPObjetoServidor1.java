package ejemplos;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPObjetoServidor1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket servidor = new ServerSocket(6000);

        System.out.println("Esperando al cliente...");
        Socket cliente = servidor.accept();

        ObjectOutputStream outputStream = new ObjectOutputStream(cliente.getOutputStream());

        Persona per = new Persona("Juan" , 19);

        outputStream.writeObject(per);
        System.out.println("Envio: " + per.nombre + " " + per.edad);

        ObjectInputStream inObject = new ObjectInputStream(cliente.getInputStream());

        Persona dato = (Persona) inObject.readObject();

        System.out.println("Recibido: " + dato.nombre + " " + dato.edad);

        outputStream.close();
        inObject.close();
        cliente.close();
        servidor.close();
   }
}
