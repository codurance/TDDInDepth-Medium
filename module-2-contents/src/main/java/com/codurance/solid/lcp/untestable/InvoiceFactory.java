package com.codurance.solid.lcp.untestable;

import com.codurance.solid.lcp.untestable.InvoiceType;

public class InvoiceFactory {
    public Invoice createInvoice(InvoiceType type) {
        if (type.equals(InvoiceType.EMAIL)) {
            return new EmailInvoice();
        } else if (type.equals(InvoiceType.PAPER)) {
            return new PaperInvoice();
        } {
            throw new IllegalArgumentException("Invalid invoice type");
        }
    }
}
