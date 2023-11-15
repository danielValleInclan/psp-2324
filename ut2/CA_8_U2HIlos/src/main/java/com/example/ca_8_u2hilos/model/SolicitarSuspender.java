package com.example.ca_8_u2hilos.model;

public class SolicitarSuspender {
    private boolean suspender;

    public synchronized void set (boolean b){
        suspender = b;
        notifyAll();
    }

    public synchronized void esperandoParaReanudar() throws InterruptedException {
        while (suspender){
            wait();
        }
    }
}
