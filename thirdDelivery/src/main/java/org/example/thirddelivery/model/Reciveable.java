package org.example.thirddelivery.model;

import java.util.List;

public interface Reciveable extends Sendeable {
    List<String> reciveMessage(List<Message> message);
}
