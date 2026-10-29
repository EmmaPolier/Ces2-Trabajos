package org.example.thirddelivery.model;

import java.util.ArrayDeque;
import java.util.Deque;

public class TopicsHistory {
    private String historyCode;
    private EnumMessage message;
    private Category category;
    private Deque<Message> messages;

    public TopicsHistory() {
        this.messages = new ArrayDeque<>();
    }

    public TopicsHistory(String historyCode, EnumMessage message, Category category) {
        this.historyCode = historyCode;
        this.message = message;
        this.category = category;
        this.messages = new ArrayDeque<>();
    }

    public void setHistoryCode(String historyCode) {
        this.historyCode = historyCode;
    }

    public void setMessage(EnumMessage message) {
        this.message = message;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setMessages(Deque<Message> messages) {
        this.messages = messages;
    }

    public void addToDeque(Message message) {
        this.messages.add(message);
    }

    public String getHistoryCode() {
        return historyCode;
    }

    public EnumMessage getMessage() {
        return message;
    }

    public Category getCategory() {
        return category;
    }

    public Deque<Message> getMessages() {
        return messages;
    }

    @Override
    public String toString() {
        return "TopicsHistory{" +
                "historyCode='" + historyCode + '\'' +
                ", message=" + message +
                ", category=" + category +
                ", messages=" + messages +
                '}';
    }
}
