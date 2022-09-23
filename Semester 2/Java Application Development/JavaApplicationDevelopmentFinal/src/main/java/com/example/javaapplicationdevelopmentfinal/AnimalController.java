package com.example.javaapplicationdevelopmentfinal;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AnimalController implements Initializable
{
    @FXML
    private TextField nameTxt;
    @FXML
    private TextField genderTxt;
    @FXML
    private TextField ageTxt;
    @FXML
    private TextField animalTxt;
    @FXML
    private Button insertBtn;
    @FXML
    private Button updateBtn;
    @FXML
    private Button deleteBtn;
    @FXML
    private Button homeBtn;
    @FXML
    private TableView<Animal> animalsTbl;
    @FXML
    private TableColumn<Animal, Integer> idCol;
    @FXML
    private TableColumn<Animal, String> nameCol;
    @FXML
    private TableColumn<Animal, String> genderCol;
    @FXML
    private TableColumn<Animal, Integer> ageCol;
    @FXML
    private TableColumn<Animal, String> animalCol;

    Database database = new Database();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        idCol.setCellValueFactory(new PropertyValueFactory<Animal, Integer>("ID"));
        nameCol.setCellValueFactory(new PropertyValueFactory<Animal, String>("NAME"));
        genderCol.setCellValueFactory(new PropertyValueFactory<Animal, String>("GENDER"));
        ageCol.setCellValueFactory(new PropertyValueFactory<Animal, Integer>("AGE"));
        animalCol.setCellValueFactory(new PropertyValueFactory<Animal, String>("ANIMAL"));
        animalsTbl.setItems(database.getAnimal());
    }

    public void insertAnimal()
    {
        database.insertAnimal(nameTxt.getText(), genderTxt.getText(), Integer.parseInt(ageTxt.getText()), animalTxt.getText());
        animalsTbl.setItems(database.getAnimal());
    }

    public void updateAnimal()
    {
        Animal selectedAnimal = animalsTbl.getSelectionModel().getSelectedItem();
        database.updateAnimal(selectedAnimal.getID(), nameTxt.getText(), genderTxt.getText(), Integer.parseInt(ageTxt.getText()), animalTxt.getText());
        animalsTbl.setItems(database.getAnimal());
    }

    public void deleteAnimal()
    {
        Animal selectedAnimal = animalsTbl.getSelectionModel().getSelectedItem();
        database.deleteAnimal(selectedAnimal.getID());
        animalsTbl.setItems(database.getAnimal());
    }

    public void viewHome() throws IOException
    {
        Stage previousStage = (Stage) animalsTbl.getScene().getWindow();
        previousStage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 300);
        Stage stage = new Stage();
        stage.setTitle("Home");
        stage.setScene(scene);
        stage.show();
    }
}
