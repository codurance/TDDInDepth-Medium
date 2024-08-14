package com.codurance.testableCode.overloadedConstructors.untestable;

import java.io.File;

public class OrderProcessor {
    private final EmailSender emailSender;
    private final OrderRepository orderRepository;

    public OrderProcessor(File file) {
        String connectionString = readConnectionStringFromFile(file);
        DatabaseConnection databaseConnection = new DatabaseConnectionFactory().createFromConnectionString(connectionString);
        this.orderRepository = new OrderRepository(databaseConnection);
        SmtpConfig smtpConfig = readSmtpConfigFromFile(file);
        this.emailSender = new EmailSender(smtpConfig);
    }

    public void process(Order order) {
        orderRepository.saveOrder(order);
        emailSender.sendOrderConfirmation(order);
    }

    private SmtpConfig readSmtpConfigFromFile(File file) {
        return new SmtpConfig();
    }

    private String readConnectionStringFromFile(File file) {
        return "jdbc:sqlite:memory";
    }
}

