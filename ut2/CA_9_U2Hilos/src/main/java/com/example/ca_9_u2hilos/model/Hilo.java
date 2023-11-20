package com.example.ca_9_u2hilos.model;

import com.example.ca_9_u2hilos.HelloController;
import javafx.application.Platform;

public class Hilo extends Thread{
    private final int timeSleep;
    private final HelloController controller;
    private int cont;

    public Hilo (String name, int timeSleep, HelloController controller){
        this.timeSleep = timeSleep;
        this.controller = controller;
        setName(name);
    }

    public void run(){
        try {
            while (!isInterrupted()){
                cont++;
                Platform.runLater(controller::setValoresHilos);
                Thread.sleep(timeSleep);
            }
        } catch (InterruptedException e) {
            System.out.println("Ha ocurrido una excepción");;
        }
        System.out.println("Fin de ciclo");
    }

    public int getCont() {
        return cont;
    }

    public void interrumpir(){interrupt();}
}
