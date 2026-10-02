package com.emma.firstdelivery.model;

import java.util.ArrayList;
import java.util.List;

public class Email implements MessageActions {
    private String email;
    public List<Message> messages;

    public Email(String email, List<Message> messages) {
        this.email = email;
        this.messages = messages;
    }

    @Override
    public String getNames() {
        return this.email;
    }

    @Override
    public List<Message> getMessages() {
        return messages;
    }

    @Override
    public List<String> sendMessage(List<Message> messages) {
        List<String> result = new ArrayList<>();
        for (Message message: messages) {
             result.add(message.getSender() + " envio mensaje a " + message.getReciber() + " desde email: " + this.email + ". Mensaje: " + message.getMessage());
        }
        return result;
    }

    @Override
    public List<String> reciveMessage(List<Message> messages) {
        List<String> result = new ArrayList<>();
        for (Message message: messages) {
            result.add(message.getSender() + " recibio mensaje de " + message.getReciber() + " desde email: " + this.email + ". Mensaje: " + message.getMessage());
        }
        return result;
    }

    @Override
    public List<String> respondMessage(List<Message> messages) {
        List<String> result = new ArrayList<>();
        for (Message message : messages) {
            result.add(message.getReciber() + " respondio a " + message.getSender() + " desde email: " + this.email);
        }
        return result;
    }
}
