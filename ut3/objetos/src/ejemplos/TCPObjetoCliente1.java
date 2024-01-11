package ejemplos;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TCPObjetoCliente1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Programa cliente iniciado...");
        Socket cliente = new Socket("localhost", 6000);

        ObjectInputStream perEnt = new ObjectInputStream(cliente.getInputStream());

        Persona dato = (Persona) perEnt.readObject();

        System.out.println("Recibido: " + dato.nombre + " " + dato.edad);

        dato.setNombre("Daniel");
        dato.setEdad(30);

        ObjectOutputStream perSal = new ObjectOutputStream(cliente.getOutputStream());

        perSal.writeObject(dato);
        System.out.println("Envio: " + dato.nombre + " " + dato.edad);

        perEnt.close();
        perSal.close();
        cliente.close();
    }
}
