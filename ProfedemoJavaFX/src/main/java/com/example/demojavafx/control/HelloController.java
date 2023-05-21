package com.example.demojavafx.control;

import com.example.demojavafx.HelloApplication;
import com.example.demojavafx.model.Person;
import com.example.demojavafx.model.User;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML
    private CheckBox checkTerminos;

    @FXML
    private RadioButton rbopcion1;

    @FXML
    private TableColumn colName;

    @FXML
    private TableColumn colLastname;

    @FXML
    private TableColumn colGender;

    @FXML
    private TableColumn colDate;

    @FXML
    private TableView<Person> tablePerson;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfLastname;

    @FXML
    private ChoiceBox cbGender;

    @FXML
    private DatePicker dpDate;

    private ObservableList<Person> people;

    @FXML
    protected void onHelloButtonClick() {
        boolean aceptoTerminos = checkTerminos.isSelected();
        String texto = "Welcome to JavaFX Application! option 1 is selected";
        if(!rbopcion1.isSelected()){
            texto = "Welcome to JavaFX Application! option 2 is selected";
        }
        if (!aceptoTerminos) texto = "Debe aceptar los términos y condiciones :)";
        welcomeText.setText(texto);
    }

    @FXML
    protected void onOpenWindow(){
        User.getInstance().setUsername("juan");

        HelloApplication.hideWindow((Stage) welcomeText.getScene().getWindow());
        HelloApplication.showWindow("message-window");
    }

    public void onAddPerson() {
        String name = tfName.getText();
        String lastName = tfLastname.getText();
        int gender = cbGender.getValue().equals("Hombre") ? 0 : 1;
        Person person = new Person(name,lastName,gender);
        people.add(person);
        tablePerson.setItems(people);
        tfName.setText("");
        tfLastname.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        cbGender.getItems().add("Hombre");
        cbGender.getItems().add("Mujer");

        people = FXCollections.observableArrayList();
        colName.setCellValueFactory(new PropertyValueFactory<Person,String>("name"));
        colLastname.setCellValueFactory(new PropertyValueFactory<Person,String>("lastName"));
        colGender.setCellValueFactory(new PropertyValueFactory<Person,Integer>("gender"));
    }
}