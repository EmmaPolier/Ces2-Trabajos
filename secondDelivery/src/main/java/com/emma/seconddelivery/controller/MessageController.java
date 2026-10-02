package com.emma.firstdelivery.controller;

import com.emma.firstdelivery.model.*;
import com.emma.firstdelivery.repository.MessageRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class MessageController {

    private final MessageRepository repository;

    public MessageController(MessageRepository repository) {
        this.repository = repository;
    }

    // http://localhost:8080/get-names
    @GetMapping("/get-names")
    public String getNames(Model model) {
        List<MessageActions> objects = repository.findAll();

        String names = objects.stream()
                .map(MessageActions::getNames)
                .collect(Collectors.joining(", "));

        model.addAttribute("names", names);
        return "get-names";
    }

    // http://localhost:8080/get-statistics
    @GetMapping("/get-statistics")
    public String getStatistics(Model model) {
        IntSummaryStatistics stats = allMessages().stream()
                .mapToInt(Message::getPriority)
                .summaryStatistics();

        model.addAttribute("conteo", stats.getCount());
        model.addAttribute("suma", stats.getSum());
        model.addAttribute("promedio", stats.getAverage());
        model.addAttribute("minimo", stats.getMin());
        model.addAttribute("maximo", stats.getMax());
        return "get-statistics";
    }

    // http://localhost:8080/get-string-attribute
    @GetMapping("/get-string-attribute")
    public String getStringAttribute(Model model) {
        List<Message> messages = allMessages();

        List<String> senders = messages.stream()
                .map(Message::getSender)
                .collect(Collectors.toList());

        model.addAttribute("messagesCount", messages.size());
        model.addAttribute("senders", senders);
        return "get-string-attribute";
    }

    // http://localhost:8080/get-any-none-match
    @GetMapping("/get-any-none-match")
    public String getAnyNoneMatch(Model model) {
        List<Message> messages = allMessages();

        boolean hasEmailSender = messages.stream()
                .anyMatch(m -> m.getSender() != null && m.getSender().contains("@"));

        boolean hasHighPriority = messages.stream()
                .anyMatch(m -> m.getPriority() > 4);

        boolean noMissingReceiver = messages.stream()
                .noneMatch(m -> m.getReciber() == null || m.getReciber().isBlank());

        model.addAttribute("hasEmailSender", hasEmailSender);
        model.addAttribute("hasHighPriority", hasHighPriority);
        model.addAttribute("noMissingReceiver", noMissingReceiver);
        return "get-any-none-match";
    }

    // http://localhost:8080/get-max-priority
    @GetMapping("/get-max-priority")
    public String getMaxPriority(Model model) {
        Optional<Message> maxPriority = allMessages().stream()
                .max(Comparator.comparingInt(Message::getPriority));

        model.addAttribute("maxPriority", maxPriority.orElse(null));
        return "get-max-priority";
    }

    // Evita repetir el mismo flatMap en cada endpoint
    private List<Message> allMessages() {
        return repository.findAll().stream()
                .flatMap(o -> o.getMessages().stream())
                .collect(Collectors.toList());
    }
}