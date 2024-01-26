package ejemplos.adivinaNumero;

import java.io.IOException;
import java.net.ServerSocket;
<<<<<<< HEAD

class ServidorAdivina {
    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(6003);
=======
import java.net.Socket;

class ServidorAdivina {
    public static void main(String[] args) {
        ServerSocket servidor;
        try {
            servidor = new ServerSocket(6003);
>>>>>>> aa69997 (Haciendo ejemplo adivina)
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Servidor iniciado");

        // Número a adivinar entre 1 y 25
        int numero = (int) (1 + 25 * Math.random());
        System.out.println("NÚMERO A ADIVINAR=> " + numero);

        // Todos los hilos comparten el objeto
<<<<<<< HEAD

=======
        ObjetoCompartido objetoCompartido = new ObjetoCompartido(numero);
        int id = 0;
        while (true){
            Socket cliente = new Socket();
            try {
                cliente = servidor.accept();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            id++;
            HiloServidorAdivina hiloServidorAdivina = new HiloServidorAdivina(cliente, objetoCompartido, id);
            hiloServidorAdivina.start();
        }
>>>>>>> aa69997 (Haciendo ejemplo adivina)
    }
}
