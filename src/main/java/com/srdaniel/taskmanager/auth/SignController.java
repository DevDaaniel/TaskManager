package com.srdaniel.taskmanager.auth;

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
    public TextField registerUsernameField;
    @FXML
    public PasswordField registerPasswordField;
    @FXML
    public PasswordField loginPasswordField;
    @FXML
    public TextField loginUsernameField;
    @FXML
    public PasswordField confirmPasswordField;

    @FXML
    private Button logInButton;

    @FXML
    private Button registerButton;

    public String logInAction() {
        {
            loadLoginScene();
        }
        return null;
    }
    public void registerAction() {
        {
            loadRegisterScene();
        }
    }

    public void exitAction() {
        Stage stage = (Stage) logInButton.getScene().getWindow();
        stage.close();
    }

    private void loadLoginScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/LogIn.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) logInButton.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);

            UserAuthentication auth = new UserAuthentication();
            boolean loginResult = auth.authenticateUser(loginUsernameField.getText(), loginPasswordField.getText());
            if (loginResult) {
                System.out.println("Successfully logged in!");
            } else {
                System.out.println("Login error.");
            }
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
            boolean registrationResult = auth.registerUser(registerUsernameField.getText(), registerPasswordField.getText());
            if (registrationResult) {
                System.out.println("Successfully registered!");
                loadLoginScene();
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
