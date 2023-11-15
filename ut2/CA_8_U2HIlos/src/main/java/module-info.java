module com.example.ca_8_u2hilos {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    opens com.example.ca_8_u2hilos to javafx.fxml;
    exports com.example.ca_8_u2hilos;
}