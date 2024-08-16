package com.codurance.testableCode.cohesion.refactored;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLUserRepository implements UserRepository {
    private final Connection databaseConnection;
    private final Logger logger;

    public SQLUserRepository(Connection databaseConnection, Logger logger) {
        this.databaseConnection = databaseConnection;
        this.logger = logger;
    }

    @Override
    public void save(User user) {
        String sql = "INSERT INTO users (name, email, age) VALUES (?, ?, ?)";
        try (PreparedStatement statement = databaseConnection.prepareStatement(sql)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setInt(3, user.getAge());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.logError("Failed to save user to database");
        }
    }

    @Override
    public double calculateAverageAge() {
        String sql = "SELECT AVG(age) FROM users";
        try (PreparedStatement statement = databaseConnection.prepareStatement(sql)) {
            return statement.executeQuery().getDouble(1);
        } catch (SQLException e) {
            logger.logError("Failed to calculate average age");
            return 0;
        }
    }

}