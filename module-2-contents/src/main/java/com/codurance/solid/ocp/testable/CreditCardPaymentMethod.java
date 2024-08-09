package com.codurance.solid.ocp.testable;

public class CreditCardPaymentMethod implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Processing credit card payment");
    }
}
