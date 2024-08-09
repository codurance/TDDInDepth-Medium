package com.codurance.solid.dip.testable;

public class SESMailer implements Mailer {
    @Override
    public void sendEmail(String emailAddress, String content) {
        throw new UnsupportedOperationException("Method not implemented");

    }
}
