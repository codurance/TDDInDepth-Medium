package com.codurance.solid.lcp.testable;

public class PaperInvoice implements Invoice {

    @Override()
    public void sendInvoice(Customer customer) {
        System.out.println("Sending paper invoice to " + customer.address);
    }
}
