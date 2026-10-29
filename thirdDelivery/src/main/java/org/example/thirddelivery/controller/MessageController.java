package org.example.thirddelivery.controller;

import org.example.thirddelivery.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Controller
public class MessageController {

    // http://localhost:8080/execute
    @GetMapping("/execute")
    public String execute(Model model) {
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(1);
        stack1.push(10);
        Stack<Integer> stack2 = new Stack<>();
        stack2.push(2);
        stack2.push(9);
        Stack<Integer> stack3 = new Stack<>();
        stack3.push(3);
        stack3.push(8);
        Stack<Integer> stack4 = new Stack<>();
        stack4.push(4);
        stack4.push(7);
        Stack<Integer> stack5 = new Stack<>();
        stack5.push(5);
        stack5.push(6);
        stack5.push(5);

        Message m1 = new Message("Emma", "Joel", EnumMessage.CHAT, Category.GENERAL, stack1);
        Message m2 = new Message("Raquel", "Stivens", EnumMessage.EMAIL, Category.URGENT, stack2);
        Message m3 = new Message("Sara", "Emma", EnumMessage.SMS, Category.INFORMATIVE, stack3);
        Message m4 = new Message("Miguel", "Laura", EnumMessage.NOTIFICATION, Category.URGENT, stack4);
        Message m5 = new Message("Emma", "Sara", EnumMessage.ALERT, Category.GENERAL, stack5);

        Stack<Message> stackMessages = new Stack<>();
        stackMessages.push(m1);
        stackMessages.push(m2);
        stackMessages.push(m3);
        stackMessages.push(m4);
        stackMessages.push(m5);

        TopicsHistory history = new TopicsHistory("My history", EnumMessage.ALERT, Category.URGENT);
        history.addToDeque(m1);
        history.addToDeque(m2);
        history.addToDeque(m3);
        history.addToDeque(m4);
        history.addToDeque(m5);

        List<String> resultsListIt = new ArrayList<>();
        ListIterator<Message> listIterator = stackMessages.listIterator();
        while (listIterator.hasNext()) {
            Message m = listIterator.next();
            resultsListIt.add(m.toString());
        }

        List<String> resultsIt = new ArrayList<>();
        Iterator<Message> iterator = history.getMessages().iterator();
        while (iterator.hasNext()) {
            Message m = iterator.next();
            resultsIt.add(m.toString());
        }

        Deque<Message> dequeConverted = new ArrayDeque<>(stackMessages);
        List<Message> functionalFilter = dequeConverted.stream()
                .filter(m -> m.getMessage() == EnumMessage.EMAIL)
                .collect(Collectors.toList());

        Function<Message, Integer> sumCount = msg -> {
            int sum = 0;
            for (Integer num : msg.getCount()) {
                sum += num;
            }
            return sum;
        };

        int totalObjs1 = m1.seeTotals(sumCount);

        model.addAttribute("resultsListIt", resultsListIt);
        model.addAttribute("resultsIt", resultsIt);
        model.addAttribute("functionalFilter", functionalFilter);
        model.addAttribute("totalObj1", totalObjs1);

        return "result";
    }
}