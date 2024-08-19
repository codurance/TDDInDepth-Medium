package com.codurance.first.isolated.exchange;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Configuration {
    private Currency currency;
    private List<Currency> currencies = new ArrayList<>();

    public void setCurrency(Currency currency) {

        this.currency = currency;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void addExchangeRate(Currency currency) {
        currencies.add(currency);
    }

    public List<Currency> getExchangeRates() {
        return currencies;
    }

    public Currency getRateOf(String currencyName) {
        return currencies
            .stream()
            .filter(currentCurrency -> currentCurrency.name().equals(currencyName))
            .findFirst()
            .orElse(null);
    }
}
