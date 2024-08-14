package com.codurance.testableCode.overloadedConstructors.untestable;

public class EmailSender {
    public EmailSender(SmtpConfig smtpConfig) {
    }

    public void sendOrderConfirmation(Order order) {

    }
}
