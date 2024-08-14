package com.codurance.testableCode.constructionOfObjects.untestable;

public class UserService {
    private final UserRepository userRepository;
    private final EmailService emailService;

    public UserService() {
        this.userRepository = new UserRepository();
        this.emailService = new EmailService();
    }

    public void register(String username, String email) {
        User user = new User(username, email);
        userRepository.save(user);
        emailService.sendWelcomeEmail(user);
    }
}
