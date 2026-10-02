package com.emma.firstdelivery.model;

public class Message {
    private String sender;
    private String reciber;
    private String message;
    private int priority;

    public Message(String sender, String reciber, String message, int priority) {
        this.sender = sender;
        this.reciber = reciber;
        this.message = message;
        this.priority = priority;
    }

    public String getSender() {
        return sender;
    }

    public String getReciber() { return reciber; }

    public String getMessage() {
        return message;
    }

    public int getPriority() { return priority; }
}