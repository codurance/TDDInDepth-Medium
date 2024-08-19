package com.codurance.first.repeatable.user;

public interface UserGateway {
    User findByUsername(String username);

    void insert(String username);
}
