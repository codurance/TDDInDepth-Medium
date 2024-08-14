package com.codurance.testableCode.constructionOfObjects.untestable;

public class User {
    private final String username;
    private final String email;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }
}
