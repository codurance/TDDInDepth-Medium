package com.codurance.testableCode.constructionOfObjects.untestable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceShould {
    @Test
    public void beUntestableInIsolation() {
        UserService userService = new UserService();
        userService.register("username", "email");

        // can't replace anything
        // can't verify anything
    }
}