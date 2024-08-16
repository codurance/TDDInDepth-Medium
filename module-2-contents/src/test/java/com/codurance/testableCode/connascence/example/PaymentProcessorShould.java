package com.codurance.testableCode.connascence.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class PaymentProcessorShould {
    @Test
    public void processPayment() {
        PaymentGateway paymentGateway = mock(PaymentGateway.class);
        PaymentProcessor paymentProcessor = new PaymentProcessor(paymentGateway);
        String cardNumber = "1234123412341234";
        String cardName = "John Doe";
        String cardExpiry = "12/24";
        String cardCVC = "123";
        double amount = 100.0;

        paymentProcessor.processPayment(cardNumber, cardName, cardExpiry, cardCVC, amount);

        verify(paymentGateway).pay(cardNumber, cardName, cardExpiry, cardCVC, amount);
    }
}