package com.example.javaapplicationdevelopmentfinal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {

    @FXML
    private Button viewStaff;
    @FXML
    private Button viewAnimals;

    @FXML
    protected void viewStaff(ActionEvent actionEvent) throws IOException
    {
        Stage previousStage = (Stage) viewStaff.getScene().getWindow();
        previousStage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("staff.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 500);
        Stage stage = new Stage();
        stage.setTitle("Staff");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void viewAnimals(ActionEvent actionEvent) throws IOException
    {
        Stage previousStage = (Stage) viewAnimals.getScene().getWindow();
        previousStage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("animals.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        Stage stage = new Stage();
        stage.setTitle("Animals");
        stage.setScene(scene);
        stage.show();
    }
}