package com.codurance.first.fast;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TemperatureConverterShould {
    private TemperatureConverter converter;

    @BeforeEach
    public void setup() {
        converter = new TemperatureConverter();
    }

    @ParameterizedTest
    @CsvSource({
        "32.0, 0",
        "98.6, 37",
        "212.0, 100"
    })
    public void convertFromCelsiusToFahrenheit(double fahrenheit, double celsius) {
        assertEquals(fahrenheit, converter.celsiusToFahrenheit(celsius), 0.001);
    }

    @ParameterizedTest
    @CsvSource({
        "0, 32.0",
        "37, 98.6",
        "100, 212.0"
    })
    public void convertFromFahrenheitToCelsius(double celsius, double fahrenheit) {
        assertEquals(celsius, converter.fahrenheitToCelsius(fahrenheit), 0.001);
    }
}
