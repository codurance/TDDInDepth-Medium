package com.codurance.legacy.branchbyabstraction;

public class MessageType {
    private final String template;

    public MessageType(String template) {
        this.template = template;
    }

    public String template() {
        return template;
    }
}
