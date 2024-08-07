package com.codurance.solid.srp.testable;

class UsernameValidator implements StringValidator {
    @Override
    public boolean validate(String username) {
        return username.matches("^[a-zA-Z0-9_-]{3,15}$");
    }
}
