package com.codurance.legacy.branchbyabstraction;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class NotificationServiceShould {
    @Test
    public void sendFormatedNotificationToAUser() throws Throwable {
        ThirdPartyNotificationClient thirdPartyNotificationClient = mock(ThirdPartyNotificationClient.class);
        NotificationService notificationService = new NotificationService(thirdPartyNotificationClient);

        User user = new User("Test1");
        MessageType messageType = new MessageType("%s: Notification message.");

        notificationService.notify(user, messageType);

        verify(thirdPartyNotificationClient).send("Test1: Notification message.");
    }
}
