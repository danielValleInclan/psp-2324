package actividades.actividad3_7;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPObjetoServidor {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket servidor = new ServerSocket(6000);

        System.out.println("Esperando al cliente...");
        Socket cliente = servidor.accept();
        int cuadrado = 0, cubo = 0;

        ObjectInputStream inObject = new ObjectInputStream(cliente.getInputStream());
        ObjectOutputStream outputStream = new ObjectOutputStream(cliente.getOutputStream());
        Numeros numero;

        do {
            outputStream.reset();
            numero = (Numeros) inObject.readObject();

            System.out.println("Recibido: " + numero.getNumero());

            cuadrado = numero.getNumero() * numero.getNumero();
            numero.setCuadrado(cuadrado);
            cubo = numero.getNumero()*numero.getNumero()*numero.getNumero();
            numero.setCubo(cubo);
            outputStream.writeObject(numero);

            System.out.println("Enviado: " +
                    " Número: " + numero.getNumero() +
                    " Cuadrado: " + cuadrado +
                    " Cubo: " + cubo);
        } while (numero.getNumero() != 0);

        outputStream.close();
        inObject.close();
        cliente.close();
        servidor.close();
    }
}
