package com.codurance.testableCode.cohesion.refactored;

public interface EmailSender {
    void send(String email, String subject, String body);
}
