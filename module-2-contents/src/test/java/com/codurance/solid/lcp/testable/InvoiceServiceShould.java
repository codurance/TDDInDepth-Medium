package com.codurance.solid.lcp.testable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class InvoiceServiceShould {

    public static final Customer CUSTOMER = new Customer("john.doe@admin.com", new Address(), InvoiceType.EMAIL);
    private InvoiceFactory invoiceFactory;
    private Invoice invoice;

    @BeforeEach
    void setUp() {
        invoiceFactory = mock(InvoiceFactory.class);
        invoice = mock(Invoice.class);
    }

    @Test
    public void sendEmailInvoice() {
        when(invoiceFactory.createInvoice(isA(InvoiceType.class))).thenReturn(invoice);
        InvoiceService invoiceService = new InvoiceService(invoiceFactory);

        invoiceService.sendInvoice(CUSTOMER);

        verify(invoice, times(1)).sendInvoice(CUSTOMER);
    }
}