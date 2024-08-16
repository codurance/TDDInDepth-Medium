package com.codurance.testableCode.connascence.example;

public class PaymentProcessor {
    private final PaymentGateway paymentGateway;

    public PaymentProcessor(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public void processPayment(String cardNumber, String cardName, String cardExpiry, String cardCVC, double amount) {
        paymentGateway.pay(cardNumber, cardName, cardExpiry, cardCVC, amount);
    }
}
