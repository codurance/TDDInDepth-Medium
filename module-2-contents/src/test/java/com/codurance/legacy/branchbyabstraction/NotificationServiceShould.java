package com.codurance.legacy.branchbyabstraction;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class NotificationServiceShould {
    @Test
    public void sendFormatedNotificationToAUser() throws Throwable {
        NotificationClient notificationClient = mock(NotificationClient.class);
        NotificationService notificationService = new NotificationService(notificationClient);

        User user = new User("Test1");
        MessageType messageType = new MessageType("%s: Notification message.");

        notificationService.notify(user, messageType);

        verify(notificationClient).send("Test1: Notification message.");
    }
}
