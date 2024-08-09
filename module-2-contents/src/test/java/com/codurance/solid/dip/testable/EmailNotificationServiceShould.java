package com.codurance.solid.dip.testable;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

class EmailNotificationServiceShould {
    @Test
    public void sendAnEmailNotification() {
        Mailer mailer = mock(Mailer.class);
        EmailNotificationService emailNotificationService = new EmailNotificationService(mailer);
        Customer customer = new Customer("john.doe@codurance.com");

        emailNotificationService.sendNotification(customer, "Hello, John!");

        verify(mailer, times(1)).sendEmail(customer.emailAddress, "Hello, John!");
    }

}