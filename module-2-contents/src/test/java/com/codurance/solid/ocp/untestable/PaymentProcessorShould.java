package com.codurance.solid.ocp.untestable;

import org.junit.jupiter.api.Test;

import javax.naming.OperationNotSupportedException;

class PaymentProcessorShould {

    @Test
    public void beUntestable() throws OperationNotSupportedException {
        PaymentProcessor paymentProcessor = new PaymentProcessor();

        paymentProcessor.processPayment("credit-card", 100.0);

        // how can we test this?
        // what happens if we decide to add a new payment method? (e.g. Stripe, Lemon Squeezy, etc.)
    }
}