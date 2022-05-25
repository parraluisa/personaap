package co.edu.javeriana.fbd.personapp.view;

import co.edu.javeriana.fbd.personapp.model.dao.PersonaDAO;
import co.edu.javeriana.fbd.personapp.model.dao.impl.PersonaDAOImpl;
import co.edu.javeriana.fbd.personapp.model.dto.PersonaDTO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Principal extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Principal.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
}
}
