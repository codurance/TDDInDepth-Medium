package com.codurance.solid.dip.untestable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailNotificationServiceShould {
    @Test
    public void beUntestable() {
        EmailNotificationService emailNotificationService = new EmailNotificationService();
        Customer customer = new Customer("john.doe@codurance.com");

        emailNotificationService.sendNotification(customer, "Hello, John!");

        // how can we test this?
        // what happens if we decide to add a new notification mailer? (Sendinblue, Twilio, etc.)
    }
}