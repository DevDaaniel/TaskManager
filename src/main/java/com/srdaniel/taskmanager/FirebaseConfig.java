package com.srdaniel.taskmanager;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class FirebaseConfig {
    public static void initialize() {
        verifyConnection();

        try {
            FileInputStream serviceAccount = new FileInputStream("/firebaseKey.json");
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://task-manager-7b0e0.firebaseio.com")
                    .build();

            FirebaseApp.initializeApp(options);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void verifyConnection() {
        try {
            URL url = new URL("https://www.google.com");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("Conexão com a Internet bem-sucedida.");
            } else {
                System.out.println("Falha na conexão com a Internet.");
            }
        } catch (IOException e) {
            System.out.println("Erro na conexão com a Internet: " + e.getMessage());
        }
    }
}