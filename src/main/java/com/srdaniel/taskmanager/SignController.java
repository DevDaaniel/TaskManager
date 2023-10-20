package com.srdaniel.taskmanager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.IOException;
import java.util.Objects;

public class SignController {
    @FXML
    public TextField loginUsernameField;
    @FXML
    public PasswordField loginPasswordField;
    @FXML
    public PasswordField confirmPasswordField;

    @FXML
    private Button logInButton;

    @FXML
    private Button registerButton;

    public void logInAction() {
        String loginPassword = loginPasswordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        if (!loginPassword.equals(confirmPassword)) {
            System.out.println("Passwords do not match.");
        } else {
            System.out.println("Passwords match.");
            loadLoginScene();
        }
    }

    public void registerAction(ActionEvent event) {
        loadRegisterScene();
    }

    public void exitAction() {
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Register.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) registerButton.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);

            UserAuthentication auth = new UserAuthentication();
            boolean registrationResult = auth.registerUser(loginUsernameField.getText(), loginPasswordField.getText());
            if (registrationResult) {
                System.out.println("Successfully registered!");
            } else {
                System.out.println("Registration error.");
            }
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
