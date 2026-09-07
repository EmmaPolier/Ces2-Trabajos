package com.emma.firstdelivery.model;

public class Email implements MessageActions {
    private String email;
    public Message message;

    public Email(String email, Message message) {
        this.email = email;
        this.message = message;
    }

    @Override
    public String sendMessage(Message message) {
        return message.getSender() + " envio mensaje a " + message.getReciber() + " desde email: " + this.email + ". Mensaje: " + message.getMessage();
    }

    @Override
    public String reciveMessage(Message message) {
        return message.getReciber() + " recibio mensaje de " + message.getSender() + " desde email: " + this.email + ". Mensaje: " + message.getMessage();
    }

    @Override
    public String respondMessage(Message message) {
        return message.getReciber() + " respondio a " + message.getSender() + " desde email: " + this.email;
    }
}
