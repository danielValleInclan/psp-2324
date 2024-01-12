package actividades.actividad3_7;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TCPObjetoCliente {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Programa cliente iniciado...");
        Socket cliente = new Socket("localhost", 6000);

        ObjectOutputStream outputStream = new ObjectOutputStream(cliente.getOutputStream());
        ObjectInputStream inputStream = new ObjectInputStream(cliente.getInputStream());
        Numeros numero = new Numeros();
        int n = 1;
        while (n != 0){
            outputStream.reset();
            System.out.println("Introduce un número (0 para terminar): ");
            n = sc.nextInt();
            numero.setNumero(n);
            outputStream.writeObject(numero);
            System.out.println("Envio: " + numero.getNumero());

            numero = (Numeros) inputStream.readObject();

            System.out.println("Recibido: " +
                    " Número: " + numero.getNumero() +
                    " Cuadrado: " + numero.getCuadrado() +
                    " Cubo: " + numero.getCubo());
        }
        outputStream.close();
        cliente.close();
    }
}
