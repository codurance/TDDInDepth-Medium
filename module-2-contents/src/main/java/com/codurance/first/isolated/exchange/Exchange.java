package com.codurance.first.isolated.exchange;

public class Exchange {
    private final Configuration config;

    public Exchange(Configuration config) {
        this.config = config;
    }

    public double fromEur(int amount) {
        return (
            amount * config.getRateOf("EUR").exchangeRate()
        ) / config.getCurrency().exchangeRate();
    }
}
