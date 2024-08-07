package com.codurance.solid.srp.testable;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UsernameValidatorShould {
    @ParameterizedTest
    @CsvSource({
        "admin, true",
        "hi, false",
        "thisisaverylongusername123, false",
        "with space, false",
        "with@symbol, false",
    })
    public void validateUsername(String username, boolean expected) {
        UsernameValidator usernameValidator = new UsernameValidator();

        boolean isValidUsername = usernameValidator.validate(username);

        assertEquals(expected, isValidUsername);
    }
}