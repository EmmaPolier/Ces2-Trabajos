package com.emma.firstdelivery.model;

public class SmokeSign implements MessageActions {
    private String smokeSign;
    public Message message;

    public SmokeSign(String smokeSign, Message message) {
        this.smokeSign = smokeSign;
        this.message = message;
    }

    @Override
    public String sendMessage(Message message) {
        return message.getSender() + " envio mensaje a " + message.getReciber() + " desde la señal de humo: " + this.smokeSign + ". Mensaje: " + message.getMessage();
    }

    @Override
    public String reciveMessage(Message message) {
        return message.getReciber() + " recibio mensaje de " + message.getSender() + " desde la señal de humo: " + this.smokeSign + ". Mensaje: " + message.getMessage();
    }

    @Override
    public String respondMessage(Message message) {
        return message.getReciber() + " respondio a " + message.getSender() + " desde la señal de humo: " + this.smokeSign;
    }
}
