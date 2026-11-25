package com.findlayt.calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class CalculatorApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(
                CalculatorApp.class.getResource("ui/calculator-view.fxml"));
        Scene scene = new Scene(loader.load(), 320, 480);
        String css = Objects.requireNonNull(this.getClass().getResource("ui/style.css")).toExternalForm();
        scene.getStylesheets().add(css);
        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.show();
    }
}
