package com.codurance.first.thorough.password;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordValidatorShould {
    private PasswordValidator validator;

    @BeforeEach
    public void setup() {
        validator = new PasswordValidator();
    }

    @Test
    public void takeAsValidAPasswordWithMinimumLength() {
        String password = "abc123";
        assertTrue(validator.isValid(password), "Password with minimum length should be valid");
    }

    @Test
    public void takeAsInvalidAPasswordUnderMinimumLength() {
        String password = "abc12";
        assertFalse(validator.isValid(password), "Password under minimum length should be invalid");
    }

    @Test
    public void takeAsValidAPasswordWithMaximumLength() {
        String password = "aVeryLongPassword123";
        assertTrue(validator.isValid(password), "Password with maximum length should be valid");
    }

    @Test
    public void takeAsInvalidAPasswordAboveMaximumLength() {
        String password = "aVeryLongPassword123!";
        assertFalse(validator.isValid(password), "Password above maximum length should be invalid");
    }

    @Test
    public void takeAsInvalidAEmptyPassword() {
        String password = "";
        assertFalse(validator.isValid(password), "Empty password should be invalid");
    }

    @Test
    public void takeAsValidAPasswordWithSpecialCharacters() {
        String password = "Pa$$w0rd!";
        assertTrue(validator.isValid(password), "Password with special characters should be valid");
    }
}
