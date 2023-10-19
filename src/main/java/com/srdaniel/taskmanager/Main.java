package com.srdaniel.taskmanager;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        try {
            FirebaseConfig.verifyConnection();
            FirebaseConfig.initialize();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXMLButton.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            String css = Objects.requireNonNull(getClass().getResource("/home.css")).toExternalForm();
            scene.getStylesheets().add(css);

            SignController controller = loader.getController();
            controller.setStage(primaryStage);

            primaryStage.setScene(scene);
            primaryStage.setTitle("Task Manager");
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}