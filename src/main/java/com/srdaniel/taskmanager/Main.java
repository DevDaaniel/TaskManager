package com.srdaniel.taskmanager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXMLButton.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/icon.png")));
            String css = Objects.requireNonNull(getClass().getResource("/home.css")).toExternalForm();
            scene.getStylesheets().add(css);

            stage.getIcons().add(icon);
            stage.setTitle("Task Manager");
            stage.setScene(scene);

            ControllerSignButtons controller = loader.getController();

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
