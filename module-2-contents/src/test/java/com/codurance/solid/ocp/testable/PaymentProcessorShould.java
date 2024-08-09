package com.codurance.solid.ocp.testable;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class PaymentProcessorShould {

    @Test
    public void makePaymentWithReceivedPaymentMethod() {
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        PaymentMethod paymentMethod = mock(PaymentMethod.class);

        paymentProcessor.payWith(paymentMethod);
        paymentProcessor.processPayment(100.0);

        verify(paymentMethod, times(1)).pay(100.0);
    }
}