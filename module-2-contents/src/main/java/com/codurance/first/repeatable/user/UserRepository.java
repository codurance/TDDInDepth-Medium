package com.codurance.first.repeatable.user;

public class UserRepository {
    private final UserGateway userGateway;

    public UserRepository(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public void save(User user) {
        if (null == userGateway.findByUsername(user.getUsername())) {
            userGateway.insert(user.getUsername());
        }
    }
}
