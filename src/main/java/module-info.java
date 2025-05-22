module com.example.javafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.javafx to javafx.fxml;
    exports com.example.javafx.controller;
    opens com.example.javafx.controller to javafx.fxml;
    exports com.example.javafx.view;
    opens com.example.javafx.view to javafx.fxml;
    exports com.example.javafx.models;
    opens com.example.javafx.models to javafx.fxml;
}