package com.codurance.testableCode.cohesion.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class GodClass {

    private Connection databaseConnection;
    private Properties configuration;

    public GodClass(Properties configuration) {
        this.configuration = configuration;
    }

    public void saveUserToDatabase(User user) throws SQLException {
        if (databaseConnection == null) {
            establishDatabaseConnection();
        }

        String sql = "INSERT INTO users (name, email) VALUES (?, ?)";
        try (PreparedStatement statement = databaseConnection.prepareStatement(sql)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.executeUpdate();
        }
    }

    private void establishDatabaseConnection() throws SQLException {
        String url = getConfigValue("db.url");
        String username = getConfigValue("db.username");
        String password = getConfigValue("db.password");
        databaseConnection = DriverManager.getConnection(url, username, password);
    }

    public void sendWelcomeEmail(User user) {
        String subject = "Welcome to our platform!";
        String body = "Hello " + user.getName() + ",\n\nWelcome!";
        EmailSender.send(user.getEmail(), subject, body); // Assuming an EmailSender utility class
    }


    public void logError(String errorMessage) {
        System.err.println("ERROR: " + errorMessage); // Basic error logging to console
    }

    public String getConfigValue(String key) {
        return configuration.getProperty(key);
    }

}
