package com.codurance.first.isolated.exchange;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConfigurationShould {
    private Configuration config;

    @BeforeEach
    public void setUp() {
        config = new Configuration();
        config.setCurrency(new Currency("USD", 1));
        config.addExchangeRate(new Currency("EUR", 1.1));
        config.addExchangeRate(new Currency("GBP", 1.4));
    }

    @Test
    public void useDefaultCurrencySetting() {
        assertEquals("USD", config.getCurrency().name());
    }

    @Test
    public void allowChangingCurrencySetting() {
        config.setCurrency(new Currency("EUR", 1.12));

        assertEquals("EUR", config.getCurrency().name());
    }

    @Test
    public void knowDifferentCurrencyExchangeRates() {

        assertEquals(2, config.getExchangeRates().size());
    }

    @Test
    public void getExchangeRateCurrencyByName() {
        assertEquals(1.1, config.getRateOf("EUR"));
    }
}
