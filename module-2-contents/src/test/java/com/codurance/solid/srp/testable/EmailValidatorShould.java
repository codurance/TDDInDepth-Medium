package com.codurance.solid.srp.testable;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmailValidatorShould {
    @ParameterizedTest
    @CsvSource({
        "admin@codurance.com, true",
        "admin, false",
    })
    public void validateEmailAddress(String email, boolean isValid) {
        EmailValidator emailValidator = new EmailValidator();

        boolean isValidEmail = emailValidator.validate(email);

        assertEquals(isValid, isValidEmail);
    }
}