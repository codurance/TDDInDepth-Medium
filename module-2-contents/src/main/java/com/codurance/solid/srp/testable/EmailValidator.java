package com.codurance.solid.srp.testable;

class EmailValidator implements StringValidator {
    @Override
    public boolean validate(String email) {
        return email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }
}
