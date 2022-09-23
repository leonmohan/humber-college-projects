package com.example.javaapplicationdevelopmentfinal;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StaffController implements Initializable
{
    @FXML
    private TextField nameTxt;
    @FXML
    private TextField jobTxt;
    @FXML
    private Button insertBtn;
    @FXML
    private Button updateBtn;
    @FXML
    private Button deleteBtn;
    @FXML
    private Button homeBtn;
    @FXML
    private TableView<Staff> staffTbl;
    @FXML
    private TableColumn<Staff, Integer> idCol;
    @FXML
    private TableColumn<Staff, String> nameCol;
    @FXML
    private TableColumn<Staff, String> jobCol;

    Database database = new Database();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        idCol.setCellValueFactory(new PropertyValueFactory<Staff, Integer>("ID"));
        nameCol.setCellValueFactory(new PropertyValueFactory<Staff, String>("Name"));
        jobCol.setCellValueFactory(new PropertyValueFactory<Staff, String>("Job"));
        staffTbl.setItems(database.getStaff());
    }

    public void insertStaff()
    {
        database.insertStaff(nameTxt.getText(), jobTxt.getText());
        staffTbl.setItems(database.getStaff());
    }

    public void updateStaff()
    {
        Staff selectedStaff = staffTbl.getSelectionModel().getSelectedItem();
        database.updateStaff(selectedStaff.getID(), nameTxt.getText(), jobTxt.getText());
        staffTbl.setItems(database.getStaff());
    }

    public void deleteStaff()
    {
        Staff selectedStaff = staffTbl.getSelectionModel().getSelectedItem();
        database.deleteStaff(selectedStaff.getID());
        staffTbl.setItems(database.getStaff());
    }

    public void viewHome() throws IOException
    {
        Stage previousStage = (Stage) staffTbl.getScene().getWindow();
        previousStage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 300);
        Stage stage = new Stage();
        stage.setTitle("Home");
        stage.setScene(scene);
        stage.show();
    }

}