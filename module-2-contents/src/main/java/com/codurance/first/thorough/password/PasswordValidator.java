package com.codurance.first.thorough.password;

public class PasswordValidator {
    private final int MIN_LENGTH = 6;
    private final int MAX_LENGTH = 20;

    public boolean isValid(String password) {
        return password.length() >= MIN_LENGTH && password.length() <= MAX_LENGTH;
    }
}
