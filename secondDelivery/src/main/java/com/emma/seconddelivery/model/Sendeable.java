package com.emma.firstdelivery.model;

import java.util.List;

public interface Sendeable {
    List<String> sendMessage(List<Message> message);
}
