module com.example.javaapplicationdevelopmentfinal {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.javaapplicationdevelopmentfinal to javafx.fxml;
    exports com.example.javaapplicationdevelopmentfinal;
}