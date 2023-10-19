package com.srdaniel.taskmanager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.IOException;
import java.util.Objects;

public class SignController {

    @FXML
    private Button logInButton;

    @FXML
    private Button registerButton;

    public void logInAction(ActionEvent event) {
        loadLoginScene();
    }

    public void registerAction(ActionEvent event) {
        loadRegisterScene();
    }
    public void exitAction(ActionEvent event) {
        Stage stage = (Stage) logInButton.getScene().getWindow();
        stage.close();
    }

    private void loadSignButtonsScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXMLButton.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            String css = Objects.requireNonNull(getClass().getResource("/home.css")).toExternalForm();
            scene.getStylesheets().add(css);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void loadLoginScene() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/LogIn.fxml")));
            Stage stage = (Stage) logInButton.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadRegisterScene() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Register.fxml")));
            Stage stage = (Stage) registerButton.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setStage(Stage stage) {
        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/icon.png")));
        stage.getIcons().add(icon);
        stage.setTitle("Task Manager");
        stage.show();
    }
}
