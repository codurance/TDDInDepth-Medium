package com.codurance.solid.srp.testable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class UserServiceShould {

    private UserRepository userRepository;
    private StringValidator usernameValidator;
    private StringValidator emailValidator;
    private UserService userService;

    @BeforeEach
    void setUp() {
        userRepository = Mockito.mock(UserRepository.class);
        usernameValidator = Mockito.mock(StringValidator.class);
        emailValidator = Mockito.mock(StringValidator.class);
        userService = new UserService(usernameValidator, emailValidator, userRepository);
    }

    @Test
    public void saveTheUserToTheDatabase() {
        String email = "admin@codurance.com";
        String username = "admin";
        Mockito.when(usernameValidator.validate(username)).thenReturn(true);
        Mockito.when(emailValidator.validate(email)).thenReturn(true);

        userService.createUser(username, email);

        Mockito.verify(userRepository).saveUser(username, email);
    }
}