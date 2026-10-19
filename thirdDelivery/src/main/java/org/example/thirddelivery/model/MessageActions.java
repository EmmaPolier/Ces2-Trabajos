package org.example.thirddelivery.model;

import java.util.List;

public interface MessageActions extends Respondeable {
    String getNames();
    List<Message> getMessages();
}
