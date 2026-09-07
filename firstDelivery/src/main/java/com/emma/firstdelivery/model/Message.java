package com.emma.firstdelivery.model;

public class Message {
    private String sender;
    private String reciber;
    private String message;

    public Message(String sender, String reciber, String message) {
        this.sender = sender;
        this.reciber = reciber;
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public String getReciber() {
        return reciber;
    }

    public String getMessage() {
        return message;
    }
}