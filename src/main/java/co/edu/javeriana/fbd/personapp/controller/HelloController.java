package co.edu.javeriana.fbd.personapp.controller;

import co.edu.javeriana.fbd.personapp.model.dao.PersonaDAO;
import co.edu.javeriana.fbd.personapp.model.dao.impl.PersonaDAOImpl;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {



    @FXML
    private Label welcomeText;

    private ChoiceBox fuck;

    ObservableList<String> choice= FXCollections.observableArrayList("Claro");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    protected void initial()
    {
        fuck.setItems(choice);
        fuck.setValue("FUCCK");
    }

    @FXML
    protected void newWindow()
    {
        try
        {
            FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("telefono-view.fxml"));
            Parent root1=(Parent) fxmlLoader.load();
            Stage stage= new Stage();
            stage.setTitle("Telefono");
            stage.setScene(new Scene(root1));
            stage.show();
        }
        catch (Exception e)
        {
            System.out.println(e.getLocalizedMessage());
        }
    }


    @FXML
    protected void exit(){
        System.exit(0);
    }

    @FXML
    protected void insertar(){
        /*    private Long cedula;
    private String nombre;
    private String apellido;
    private Short edad;
    private char genero;*/
        PersonaDAO pDAO =new PersonaDAOImpl();
        //pDAO.create();
    }
}