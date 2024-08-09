package com.codurance.solid.lcp.testable;

public class InvoiceService {
    private final InvoiceFactory invoiceFactory;

    public InvoiceService(InvoiceFactory invoiceFactory) {
        this.invoiceFactory = invoiceFactory;
    }

    public void sendInvoice(Customer customer) {
        Invoice invoice = invoiceFactory.createInvoice(customer.preferredInvoice);
        invoice.sendInvoice(customer);
    }
}
