package com.example.ca_9_u2hilos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        // Agregar el manejo de eventos para el cierre de la ventana
        stage.setOnCloseRequest((WindowEvent event) -> {
            ((HelloController) fxmlLoader.getController()).finalizarProceso();
        });
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}