package com.codurance.solid.lcp.untestable;

public class PaperInvoice implements Invoice {

    public void sendPaperInvoice(Address address) {
        System.out.println("Sending paper invoice to " + address);
    }
}
