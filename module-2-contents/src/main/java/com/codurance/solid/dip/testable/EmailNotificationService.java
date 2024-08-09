package com.codurance.solid.dip.testable;

public class EmailNotificationService implements NotificationService {
    private final Mailer mailer;

    public EmailNotificationService(Mailer mailer) {
        this.mailer = mailer;
    }

    @Override
    public void sendNotification(Customer customer, String content) {
        mailer.sendEmail(customer.emailAddress, content);
    }
}
