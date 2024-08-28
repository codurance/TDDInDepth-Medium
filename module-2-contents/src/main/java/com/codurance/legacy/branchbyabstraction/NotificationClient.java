package com.codurance.legacy.branchbyabstraction;

public interface NotificationClient {
    void send(String message) throws Throwable;
}
