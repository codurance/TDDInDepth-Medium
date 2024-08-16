package com.codurance.testableCode.connascence.example;

public interface PaymentGateway {
    void pay(String cardNumber, String cardName, String cardExpiry, String cardCVC, double amount);
}
