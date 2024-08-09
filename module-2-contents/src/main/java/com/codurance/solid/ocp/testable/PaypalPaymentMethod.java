package com.codurance.solid.ocp.testable;

public class PaypalPaymentMethod implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Processing paypal payment");
    }
}
