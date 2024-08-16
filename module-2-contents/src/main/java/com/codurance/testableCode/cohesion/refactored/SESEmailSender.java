package com.codurance.testableCode.cohesion.refactored;

public class SESEmailSender implements EmailSender {
    @Override
    public void send(String email, String subject, String body) {
        throw new UnsupportedOperationException("Method not implemented");

    }
}
