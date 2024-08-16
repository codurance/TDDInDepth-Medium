package com.codurance.testableCode.connascence.refactored;

public class PaymentProcessor {
    private final PaymentGateway paymentGateway;

    public PaymentProcessor(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public void processPayment(CreditCard cardDetails, double amount) {
        paymentGateway.pay(cardDetails, amount);
    }
}
