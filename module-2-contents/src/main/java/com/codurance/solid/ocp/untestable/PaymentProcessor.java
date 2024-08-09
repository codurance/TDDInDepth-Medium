package com.codurance.solid.ocp.untestable;

import javax.naming.OperationNotSupportedException;

public class PaymentProcessor {
    public void processPayment(String paymentType, double amount) throws OperationNotSupportedException {
        if (paymentType.equals("credit-card")) {
            processCreditCardPayment(amount);
        } else if (paymentType.equals("paypal")) {
            processPaypalPayment(amount);
        }
    }

    private void processCreditCardPayment(double amount) throws OperationNotSupportedException {
        throw new OperationNotSupportedException("Trying to process credit card payment in unit test");
    }

    private void processPaypalPayment(double amount) throws OperationNotSupportedException {
        throw new OperationNotSupportedException("Trying to process credit card payment in unit test");
    }
}
