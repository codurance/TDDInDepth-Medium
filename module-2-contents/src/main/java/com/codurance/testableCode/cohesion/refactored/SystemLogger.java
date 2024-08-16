package com.codurance.testableCode.cohesion.refactored;

public class SystemLogger implements Logger {
    @Override
    public void logError(String errorMessage) {
        System.err.println("ERROR: " + errorMessage); // Basic error logging to console
    }
}