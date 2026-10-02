package com.emma.firstdelivery.model;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumber implements MessageActions {
    private String phoneNumber;
    public List<Message> messages;

    public PhoneNumber(String phoneNumber, List<Message> messages) {
        this.phoneNumber = phoneNumber;
        this.messages = messages;
    }

    @Override
    public String getNames() {
        return this.phoneNumber;
    }

    @Override
    public List<Message> getMessages() {
        return messages;
    }

    @Override
    public List<String> sendMessage(List<Message> messages) {
        List<String> result = new ArrayList<>();
        for (Message message: messages) {
            result.add(message.getSender() + " envio mensaje a " + message.getReciber() + " desde telefono: " + this.phoneNumber + ". Mensaje: " + message.getMessage());
        }
        return result;
    }

    @Override
    public List<String> reciveMessage(List<Message> messages) {
        List<String> result = new ArrayList<>();
        for (Message message: messages) {
            result.add(message.getReciber() + " recibio mensaje de " + message.getSender() + " desde telefono: " + this.phoneNumber + ". Mensaje: " + message.getMessage());
        }
        return result;
    }

    @Override
    public List<String> respondMessage(List<Message> messages) {
        List<String> result = new ArrayList<>();
        for (Message message: messages) {
            result.add(message.getReciber() + " respondio a " + message.getSender() + " desde telefono: " + this.phoneNumber);
        }
        return result;
    }
}
