package com.codurance.testableCode.overloadedConstructors.testable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class OrderProcessorShould {

    @Test
    public void beEasierToTestInIsolation() {
        OrderRepository orderRepository = mock(OrderRepository.class);
        EmailSender emailSender = mock(EmailSender.class);
        OrderProcessor orderProcessor = new OrderProcessor(orderRepository, emailSender);
        Order order = new Order();

        orderProcessor.process(order);

        verify(orderRepository).saveOrder(order);
        verify(emailSender).sendOrderConfirmation(order);
    }
}