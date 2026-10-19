package org.example.thirddelivery.model;

import java.util.List;

public interface Sendeable {
    List<String> sendMessage(List<Message> message);
}
