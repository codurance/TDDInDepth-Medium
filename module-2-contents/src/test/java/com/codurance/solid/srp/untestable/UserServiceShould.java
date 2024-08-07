package com.codurance.solid.srp.untestable;

import org.junit.jupiter.api.Test;

import javax.naming.OperationNotSupportedException;

class UserServiceShould {
    @Test
    public void beUntestable() throws OperationNotSupportedException {
        UserService userService = new UserService();

        // userService.createUser("admin", "admin@codurance.com");
        // How can I assert on this method?
    }
}