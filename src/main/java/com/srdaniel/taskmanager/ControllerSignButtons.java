package com.srdaniel.taskmanager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.IOException;
import java.util.Objects;

public class ControllerSignButtons {

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
    public void logOutAction(ActionEvent event) {
        loadSignButtonsScene();
    }
    public void exitAction(ActionEvent event) {
        Stage stage = (Stage) logInButton.getScene().getWindow();
        stage.close();
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

    private void loadSignButtonsScene() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXMLButton.fxml")));
            Stage stage = (Stage) logInButton.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
