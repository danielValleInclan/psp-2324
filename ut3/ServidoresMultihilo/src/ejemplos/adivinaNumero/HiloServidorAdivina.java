package ejemplos.adivinaNumero;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

class HiloServidorAdivina extends Thread{
    ObjectInputStream fentrada;
    ObjectOutputStream fsalida;
    Socket socket;
    ObjetoCompartido objetoCompartido;
    int identificador, intentos = 0;

    public HiloServidorAdivina(Socket socket, ObjetoCompartido objetoCompartido, int identificador) {
        this.socket = socket;
        this.objetoCompartido = objetoCompartido;
        this.identificador = identificador;
        try {
            fsalida = new ObjectOutputStream(socket.getOutputStream());
            fentrada = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        System.out.println("=>Cliente conectado: " + identificador);

        //Preparar primer envio al cliente
        Datos datos = new Datos("Adivina un número entre 1 y 25", intentos, identificador);
        if (objetoCompartido.haTerminado()){
            datos.setCadena("Lo sentimos el juego ha terminado, han adivinado el número");
            datos.setJuega(false); // Ya no tiene que jugar
        }
        try {
            fsalida.reset();
            fsalida.writeObject(datos);
        } catch (IOException e) {
            System.out.println("Error en el hilo al realizar el primer envío al jugador: " + identificador);
            return;
        }
        while (!objetoCompartido.haTerminado() || !(datos.getIntentos() == 5)){
            int numecli = 0;
            try {
                Datos d = (Datos) fentrada.readObject();
                numecli = Integer.parseInt(d.getCadena());
            } catch (IOException e) {
                System.out.println("Error en el Hilo al leer del jugador: " + identificador);
                break;
            } catch (NumberFormatException e){
                System.out.println("El jugador " + identificador + " se ha desconectado");
                break;
            } catch (ClassNotFoundException e){
                e.printStackTrace();
                break;
            }
            String cad = objetoCompartido.nuevaJugada(identificador, numecli);
            intentos++;

            datos = new Datos(cad, intentos, identificador);

            if (objetoCompartido.haTerminado()){
                datos.setJuega(false);
                if (identificador == objetoCompartido.getGanador()){
                    datos.setGana(true);
                }
            }
            try {
                // enviar datos al cliente
                fsalida.reset();
                fsalida.writeObject(datos);
<<<<<<< HEAD
            } catch (I)
=======
            } catch (IOException n1){
                System.out.println("Error escribiendo en flujo de salida del jugador " + identificador + " " +
                        n1.getMessage());
                break;
            } catch (NullPointerException n) {
                System.out.println("El jugador " + identificador + " ha desconectado ");
                break;
            }
        }
        if (objetoCompartido.haTerminado()){
            System.out.println("EL JUEGO SE HA ACABADO ....");
            System.out.println("\t==>Desconecta: " + identificador);
        }
        try {
            fsalida.hashCode();
            fentrada.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("Error en Hilo al cerrar cliente: " + identificador);
            e.printStackTrace();
>>>>>>> aa69997 (Haciendo ejemplo adivina)
        }
    }
}
