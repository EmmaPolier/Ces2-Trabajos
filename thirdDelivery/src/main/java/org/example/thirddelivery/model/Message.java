package org.example.thirddelivery.model;

import java.util.Stack;
import java.util.function.Function;

public class Message {
    private String sender;
    private String reciber;
    private EnumMessage message;
    private Category category;
    private Stack<Integer> count;

    public Message () {
        this.count = new Stack<>();
    }

    public Message(String sender, String reciber, EnumMessage message, Category category, Stack<Integer> count) {
        this.sender = sender;
        this.reciber = reciber;
        this.message = message;
        this.category = category;
        this.count = count;
    }

    public String getSender() {
        return sender;
    }

    public String getReciber() {
        return reciber;
    }

    public EnumMessage getMessage() {
        return message;
    }

    public Category getCategory() {
        return category;
    }

    public Stack<Integer> getCount() {
        return count;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setReciber(String reciber) {
        this.reciber = reciber;
    }

    public void setMessage(EnumMessage message) {
        this.message = message;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setCount(Stack<Integer> count) {
        this.count = count;
    }

    public void addToStack(Integer item) {
        this.count.push(item);
    }

    public int seeTotals(Function<Message, Integer> funcSum) {
        return funcSum.apply(this);
    }

    @Override
    public String toString() {
        return "Message{" +
                "sender='" + sender + '\'' +
                ", reciber='" + reciber + '\'' +
                ", message=" + message +
                ", category=" + category +
                ", count=" + count +
                '}';
    }
}