package com.codurance.solid.srp.testable;

public class UserService {
    private final StringValidator usernameValidator;
    private final StringValidator emailValidator;
    private final UserRepository userRepository;

    public UserService(StringValidator usernameValidator, StringValidator emailValidator, UserRepository userRepository) {
        this.usernameValidator = usernameValidator;
        this.emailValidator = emailValidator;
        this.userRepository = userRepository;
    }

    public void createUser(String username, String email) {
        if (!isValidUsername(username) || !isValidEmail(email)) {
            return;
        }

        userRepository.saveUser(username, email);
    }

    private boolean isValidUsername(String username) {
        return usernameValidator.validate(username);
    }

    private boolean isValidEmail(String email) {
        return emailValidator.validate(email);
    }

}



