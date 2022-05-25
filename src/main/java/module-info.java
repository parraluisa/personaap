module com.example.test {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens co.edu.javeriana.fbd.personapp to javafx.fxml;
    exports co.edu.javeriana.fbd.personapp;
    exports co.edu.javeriana.fbd.personapp.controller;
    opens co.edu.javeriana.fbd.personapp.controller to javafx.fxml;
}