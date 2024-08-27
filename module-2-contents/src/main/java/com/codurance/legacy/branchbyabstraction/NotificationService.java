package com.codurance.legacy.branchbyabstraction;

public class NotificationService {
    private final ThirdPartyNotificationClient notificationClient;

    NotificationService(ThirdPartyNotificationClient notificationClient) {

        this.notificationClient = notificationClient;
    }

    public void notify(User user, MessageType messageType) throws Throwable {
        String message = String.format(messageType.template(), user.fullName());

        notificationClient.send(message);
    }
}
