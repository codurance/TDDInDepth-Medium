package com.codurance.testableCode.cohesion.refactored;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class UserService {

    private final UserRepository userRepository;
    private final EmailSender emailSender;

    public UserService(UserRepository userRepository, EmailSender emailSender) {
        this.userRepository = userRepository;
        this.emailSender = emailSender;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public double calculateAverageAge() {
        return userRepository.calculateAverageAge();
    }

    public void sendWelcomeEmail(User user) {
        String subject = "Welcome to our platform!";
        String body = "Hello " + user.getName() + ",\n\nWelcome!";
        emailSender.send(user.getEmail(), subject, body);
    }
}
