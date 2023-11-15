package com.example.ca_8_u2hilos;

import com.example.ca_8_u2hilos.model.Hilo;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    private Hilo hilo1;
    private Hilo hilo2;

    @FXML
    private Label lHilo1, lHilo2;

    public void setValoresHilos(){
        Platform.runLater(() -> {
            lHilo1.setText(String.valueOf(hilo1.getCont()));
            lHilo2.setText(String.valueOf(hilo2.getCont()));
        });
    }

    @FXML
   protected void comenzarProceso(){
        hilo1 = new Hilo("Hilo1", 600, this);
        hilo2 = new Hilo("Hilo2", 300, this);
        hilo1.start();
        hilo2.start();
   }

   @FXML
    protected void suspender1(){
        hilo1.Suspender();
    }

    @FXML
    protected void reanudar1(){
        hilo1.Reanuda();
    }


    @FXML
    protected void suspender2(){
        hilo2.Suspender();
    }

    @FXML
    protected void reanudar2(){
        hilo2.Reanuda();
    }
    @FXML
    protected void finalizarProceso(){
        System.out.printf("Valor del Hilo 1 : %d, Valor del Hilo 2: %d %n", hilo1.getCont(), hilo2.getCont());
        hilo1.stopHilo();
        hilo2.stopHilo();
    }
}