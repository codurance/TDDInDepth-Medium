package com.codurance.solid.lcp.untestable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class InvoiceServiceShould {

    public static final Customer CUSTOMER = new Customer("john.doe@codurance.com", new Address(), InvoiceType.EMAIL);
    private InvoiceFactory invoiceFactory;

    @Test
    public void beUntestable() {
        InvoiceFactory invoiceFactory = new InvoiceFactory();
        InvoiceService invoiceService = new InvoiceService(invoiceFactory);

        invoiceService.sendInvoice(CUSTOMER);

        // how can we test this?
        // what happens if we decide to add a new invoice type? (e.g. SMS, WhatsApp, etc.)
    }

    @BeforeEach
    void setUp() {
        invoiceFactory = mock(InvoiceFactory.class);
    }

    @Test
    public void beHardToTestWithoutTooMuchKnowledgeOfImplementationDetails() {
        EmailInvoice emailInvoice = mock(EmailInvoice.class);
        when(invoiceFactory.createInvoice(InvoiceType.EMAIL)).thenReturn(emailInvoice);
        InvoiceService invoiceService = new InvoiceService(invoiceFactory);

        invoiceService.sendInvoice(CUSTOMER);

        verify(emailInvoice, times(1)).sendEmailInvoice(CUSTOMER.emailAddress);
    }
}