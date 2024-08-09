package com.codurance.solid.dip.untestable;

public class EmailNotificationService implements NotificationService {
    // private final SESMailer mailer = new SESMailer();

    // public EmailNotificationService() {
    //     this.mailer = new SESMailer();
    // }

    @Override
    public void sendNotification(Customer customer, String content) {
        SESMailer mailer = new SESMailer();
        mailer.sendEmail(customer.emailAddress, content);
    }
}
