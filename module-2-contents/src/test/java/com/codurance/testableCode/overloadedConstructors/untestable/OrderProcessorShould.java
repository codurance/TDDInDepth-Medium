package com.codurance.testableCode.overloadedConstructors.untestable;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class OrderProcessorShould {

    @Test
    public void beUntestable() {
        File file = new File("config.json");
        Order order = new Order();
        OrderProcessor orderProcessor = new OrderProcessor(file);

        orderProcessor.process(order);

        // How to test this?
        // Create a configuration file
        // needs database to connect to
        // needs smtp server to connect to
        // needs to send an email
        // needs to access file system
        // this is not a unit test
    }
}