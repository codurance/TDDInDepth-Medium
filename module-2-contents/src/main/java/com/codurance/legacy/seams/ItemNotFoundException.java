package com.codurance.legacy.seams;

public class ItemNotFoundException extends Throwable {
    private final String message;

    public ItemNotFoundException(String message) {

        this.message = message;
    }
}
