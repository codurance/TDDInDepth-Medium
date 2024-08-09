package com.codurance.solid.lcp.testable;

public class Customer {
    public String emailAddress;
    public Address address;
    public InvoiceType preferredInvoice;

    public Customer(String emailAddress, Address address, InvoiceType preferredInvoice) {
        this.emailAddress = emailAddress;
        this.address = address;
        this.preferredInvoice = preferredInvoice;
    }
}
