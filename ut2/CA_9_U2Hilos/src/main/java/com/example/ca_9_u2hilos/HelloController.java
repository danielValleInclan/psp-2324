package com.example.ca_9_u2hilos;

import com.example.ca_9_u2hilos.model.Hilo;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    private Hilo hilo1, hilo2;
    @FXML
    private Label lHilo1, lHilo2;
    @FXML
    private Button bComenzarP, bFinalizarP, bInterrumpirH1, bInterrumpirH2;
    @FXML
    private TextField tfHilo1, tfHilo2;



    @FXML
    private void comenzarProceso(){
        hilo1 = new Hilo("Hilo 1", 500, this);
        hilo2 = new Hilo("Hilo 2", 1000, this);
        hilo1.start();
        hilo2.start();
        lHilo1.setText(hilo1.getName() + " ejecutando");
        lHilo2.setText(hilo2.getName() + " ejecutando");
    }

    public void setValoresHilos(){
        Platform.runLater(() -> {
            tfHilo1.setText(String.valueOf(hilo1.getCont()));
            tfHilo2.setText(String.valueOf(hilo2.getCont()));
        });
    }
    @FXML
    public void finalizarProceso(){
        interrumpirH1();
        interrumpirH2();
    }

    @FXML
    private void interrumpirH1(){
        hilo1.interrumpir();
        lHilo1.setText("Interrumpido!");
    }
    @FXML
    private void interrumpirH2(){
        hilo2.interrumpir();
        lHilo2.setText("Interrumpido!");
    }
}