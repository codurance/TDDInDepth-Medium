package com.codurance.solid.ocp.testable;

import java.util.HashMap;

public class PaymentProcessor {
    public PaymentMethod paymentMethod;

    public void payWith(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void processPayment(double amount) {
        paymentMethod.pay(amount);
    }
}

