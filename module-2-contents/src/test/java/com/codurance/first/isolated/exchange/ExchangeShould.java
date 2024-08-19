package com.codurance.first.isolated.exchange;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ExchangeShould {
    private Configuration config;
    private Exchange exchange;

    @BeforeEach
    public void setUp() {
        config = mock(Configuration.class);
        exchange = new Exchange(config);
   }

    @Test
    public void changeMoneyInEURToUSD() {
        when(config.getRateOf("EUR")).thenReturn(new Currency("EUR", 1.1));
        when(config.getCurrency()).thenReturn(new Currency("USD", 1));

        assertEquals(220, exchange.fromEur(200), 0.001);

        verify(config).getRateOf("EUR");
    }

    @Test
    public void changeMoneyInEURToGBP() {
        when(config.getRateOf("EUR")).thenReturn(new Currency("EUR", 1.1));
        when(config.getCurrency()).thenReturn(new Currency("GBP", 1.4));

        assertEquals(157.14, exchange.fromEur(200), 0.01);

        verify(config).getRateOf("EUR");
    }
}
