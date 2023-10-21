package com.srdaniel.taskmanager.auth;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserAuthentication {

    private static final String DB_URL = "jdbc:sqlite:database.db";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }
    public boolean registerUser(String username, String password) {
        try (Connection connection = connect()) {
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            int rowsInserted = preparedStatement.executeUpdate();

            return rowsInserted > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Registration error", e);
        }
    }

    public boolean authenticateUser(String username, String password) {
        try (Connection connection = connect()) {
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next();

        } catch (SQLException e) {
            throw new RuntimeException("Authentication error", e);
        }
    }
}
