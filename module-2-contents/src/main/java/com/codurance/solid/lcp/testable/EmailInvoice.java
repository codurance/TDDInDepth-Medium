package com.codurance.solid.lcp.testable;

public class EmailInvoice implements Invoice {
    private String paymentType;

    @Override
    public void sendInvoice(Customer customer) {
        System.out.println("Sending pdf invoice to " + customer.emailAddress);
    }
}
