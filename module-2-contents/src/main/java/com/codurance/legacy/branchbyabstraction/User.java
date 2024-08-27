package com.codurance.legacy.branchbyabstraction;

public class User {
    private String fullName;

    public User(String fullName) {
        this.fullName = fullName;
    }

    public String fullName() {
        return fullName;
    }
}
