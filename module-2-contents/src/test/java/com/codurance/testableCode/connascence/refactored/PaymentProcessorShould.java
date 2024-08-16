package com.codurance.testableCode.connascence.refactored;

import org.junit.jupiter.api.Test;

import static com.codurance.testableCode.connascence.refactored.CreditCardBuilder.aCreditCard;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class PaymentProcessorShould {
    @Test
    public void processPayment() {
        PaymentGateway paymentGateway = mock(PaymentGateway.class);
        PaymentProcessor paymentProcessor = new PaymentProcessor(paymentGateway);
        CreditCard cardDetails = new CreditCard("1234123412341234",
            "John Doe",
            "12/24",
            "123");
        double amount = 100.0;

        paymentProcessor.processPayment(cardDetails, amount);

        verify(paymentGateway).pay(cardDetails, amount);
    }

    @Test
    public void processPaymentWithBuilder() {
        PaymentGateway paymentGateway = mock(PaymentGateway.class);
        PaymentProcessor paymentProcessor = new PaymentProcessor(paymentGateway);
        CreditCard cardDetails = aCreditCard()
            .withCardCVC("123")
            .withCardExpiry("12/24")
            .withCardName("John Doe")
            .withCardNumber("1234123412341234")
            .build();
        double amount = 100.0;

        paymentProcessor.processPayment(cardDetails, amount);

        verify(paymentGateway).pay(cardDetails, amount);
    }
}