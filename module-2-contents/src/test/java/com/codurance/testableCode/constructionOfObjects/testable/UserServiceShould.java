package com.codurance.testableCode.constructionOfObjects.testable;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;

class UserServiceShould {

    @Test
    public void beEasierToTestInIsolation() {
        UserRepository userRepository = Mockito.mock(UserRepository.class);
        EmailService emailService = Mockito.mock(EmailService.class);
        UserService userService = new UserService(userRepository, emailService);
        String username = "username";
        String email = "email";
        User user = new User(username, email);

        userService.register(username, email);

        // now you can test user service in isolation
        // now you can verify that userRepository.save() was called
        // now you can verify that emailService.sendWelcomeEmail() was called
        verify(userRepository).save(user);
        verify(emailService).sendWelcomeEmail(user);
    }
}