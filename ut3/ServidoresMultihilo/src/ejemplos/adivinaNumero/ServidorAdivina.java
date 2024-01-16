package ejemplos.adivinaNumero;

import java.io.IOException;
import java.net.ServerSocket;

class ServidorAdivina {
    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(6003);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Servidor iniciado");

        // Número a adivinar entre 1 y 25
        int numero = (int) (1 + 25 * Math.random());
        System.out.println("NÚMERO A ADIVINAR=> " + numero);

        // Todos los hilos comparten el objeto

    }
}
