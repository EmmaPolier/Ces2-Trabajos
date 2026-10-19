package org.example.thirddelivery.model;

import java.util.List;

public interface Respondeable extends Reciveable {
    List<String> respondMessage(List<Message> message);
}
