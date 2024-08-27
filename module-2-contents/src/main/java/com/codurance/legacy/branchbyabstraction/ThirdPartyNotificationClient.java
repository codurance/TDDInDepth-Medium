package com.codurance.legacy.branchbyabstraction;

import jdk.jshell.spi.ExecutionControl.NotImplementedException;

public final class ThirdPartyNotificationClient {
    public void send(String message) throws NotImplementedException {
        throw new NotImplementedException("Calling third party Service");
    }
}
