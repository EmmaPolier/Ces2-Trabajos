package com.emma.firstdelivery.model;

import java.util.ArrayList;
import java.util.List;

public class SmokeSign implements MessageActions {
    private String smokeSign;
    public List<Message> messages;

    public SmokeSign(String smokeSign, List<Message> messages) {
        this.smokeSign = smokeSign;
        this.messages = messages;
    }

    @Override
    public String getNames() {
        return this.smokeSign;
    }

    @Override
    public List<Message> getMessages() {
        return messages;
    }

    @Override
    public List<String> sendMessage(List<Message> messages) {
        List<String> result = new ArrayList<>();
        for (Message message: messages) {
            result.add(message.getSender() + " envio mensaje a " + message.getReciber() + " desde la señal de humo: " + this.smokeSign + ". Mensaje: " + message.getMessage());
        }
        return result;
    }

    @Override
    public List<String> reciveMessage(List<Message> messages) {
        List<String> result = new ArrayList<>();
        for (Message message: messages) {
            result.add(message.getReciber() + " recibio mensaje de " + message.getSender() + " desde la señal de humo: " + this.smokeSign + ". Mensaje: " + message.getMessage());
        }
        return result;
    }

    @Override
    public List<String> respondMessage(List<Message> messages) {
        List<String> result = new ArrayList<>();
        for (Message message: messages) {
            result.add(message.getReciber() + " respondio a " + message.getSender() + " desde la señal de humo: " + this.smokeSign);
        }
        return result;
    }
}
