package com.codurance.solid.srp.untestable;

import javax.naming.OperationNotSupportedException;

public class UserService {
    public void createUser(String username, String email) throws OperationNotSupportedException {
        if (!isValidUsername(username) || !isValidEmail(email)) {
            return;
        }
        saveUserToDatabase(username, email);
    }

    private boolean isValidUsername(String username) {
        return username.matches("^[a-zA-Z0-9_-]{3,15}$");
    }

    private boolean isValidEmail(String email) {
        return email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
    }

    private void saveUserToDatabase(String username, String email) throws OperationNotSupportedException {
        throw new OperationNotSupportedException("Trying to access database from unit test");
    }
}