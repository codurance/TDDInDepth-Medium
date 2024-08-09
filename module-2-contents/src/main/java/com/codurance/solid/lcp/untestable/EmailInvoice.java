package com.codurance.solid.lcp.untestable;

public class EmailInvoice implements Invoice {
    private String paymentType;

    public void sendEmailInvoice(String email) {
        System.out.println("Sending pdf invoice to " + email);
    }
}
