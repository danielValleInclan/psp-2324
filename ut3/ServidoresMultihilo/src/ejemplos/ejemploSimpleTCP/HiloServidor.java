package ejemplos.ejemploSimpleTCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class HiloServidor extends Thread{
    BufferedReader fentrada;
    PrintWriter fsalida;
    Socket socket = null;

    public HiloServidor(Socket socket){
        this.socket = socket;
        // se crean flujos de entrada y salida con el cliente
        try {
            fsalida = new PrintWriter(socket.getOutputStream(), true);
            fentrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() { // Tarea a realizar con el cliente
        String cadena = "";
        System.out.println("COMUNICO CON: " + socket.toString());
        while (!cadena.trim().equals("*")){
            try {
                cadena = fentrada.readLine(); // obtener cadena
                fsalida.println(cadena.trim().toUpperCase()); // enviar mayúscula
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("FIN CON: " + socket.toString());

        fsalida.close();
        try {
            fentrada.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
