package com.codurance.testableCode.overloadedConstructors.testable;

public class OrderProcessor {
    private final EmailSender emailSender;
    private final OrderRepository orderRepository;

    public OrderProcessor(OrderRepository orderRepository, EmailSender emailSender) {
        this.orderRepository = orderRepository;
        this.emailSender = emailSender;
    }

    public void process(Order order) {
        orderRepository.saveOrder(order);
        emailSender.sendOrderConfirmation(order);
    }
}

