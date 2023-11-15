package com.example.ca_8_u2hilos.model;

import com.example.ca_8_u2hilos.HelloController;
import javafx.application.Platform;

public class Hilo extends Thread{

    private final HelloController controller;
    private int tiempoSleep;

    public Hilo(String nombre, int tiempoSleep, HelloController controller) {
        setName(nombre);
        this.tiempoSleep = tiempoSleep;
        this.controller = controller; // Asignar la referencia del controlador
    }
    private int cont = 0;
    private boolean comprobacion = false;
    private SolicitarSuspender suspender = new SolicitarSuspender();

    public void Suspender() {suspender.set(true);}

    public void Reanuda() {suspender.set(false);}

    public void stopHilo(){
        cont = 0;
        comprobacion = true;
    }

    public int getCont(){
        return cont;
    }

    public void run(){
        try {
            while (!comprobacion){ // haya trabajo por hacer
                cont++;
                sleep(tiempoSleep);
                suspender.esperandoParaReanudar(); // comprobar
                // Llama al método en el controlador para actualizar los valores en la interfaz gráfica
                Platform.runLater(controller::setValoresHilos);
            }
            System.out.println("Fin del bucle");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
