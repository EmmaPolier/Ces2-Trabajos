package com.emma.firstdelivery.controller;

import com.emma.firstdelivery.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class MessageController {

    //

    @GetMapping("/message")
    public String showMenssages(Model model) {
        // Email messages
        Message m1 = new Message("Juan", "María", "Hola, lista para la salida");
        Message m2 = new Message("María", "Juan", "Hola, si la estoy esperando");
        Message m3 = new Message("Juan", "María", "Nos vemos a las 5pm");
        Email email1 = new Email("juan@email.com", m1);
        Email email2 = new Email("maria@email.com", m2);
        Email email3 = new Email("juan@email.com", m3);

        // PhoneNumber messages
        Message m4 = new Message("Emmanuel", "Sara", "Hola, te llamaba para saber como estas");
        Message m5 = new Message("Sara", "Emmanuel", "Hola, bien gracias por preguntar, y tu?");
        Message m6 = new Message("Emmanuel", "Sara", "Muy bien, me alegro que estes bien");
        PhoneNumber phoneNumber1 = new PhoneNumber("3210000000", m4);
        PhoneNumber phoneNumber2 = new PhoneNumber("3120000000", m5);
        PhoneNumber phoneNumber3 = new PhoneNumber("3210000000", m6);

        // SmokeSign messages
        Message m7 = new Message("Naufrago", "Barco", "S.O.S");
        Message m8 = new Message("Barco", "Naufrago", "Ya vamos hacia ti");
        Message m9 = new Message("Naufrago", "Barco", "Gracias, y porfavor traigan comida");
        SmokeSign smokeSign1 = new SmokeSign("S.O.S", m7);
        SmokeSign smokeSign2 = new SmokeSign("OO.SS.OO", m8);
        SmokeSign smokeSign3 = new SmokeSign("SO.AO.SO", m9);

        // Lista de canales
        List<MessageActions> canales = new ArrayList<>();
        canales.add(email1);
        canales.add(email2);
        canales.add(email3);
        canales.add(phoneNumber1);
        canales.add(phoneNumber2);
        canales.add(phoneNumber3);
        canales.add(smokeSign1);
        canales.add(smokeSign2);
        canales.add(smokeSign3);

        // Lista de mensajes
        List<Message> messages = new ArrayList<>();
        messages.add(m1);
        messages.add(m2);
        messages.add(m3);
        messages.add(m4);
        messages.add(m5);
        messages.add(m6);
        messages.add(m7);
        messages.add(m8);
        messages.add(m9);

        // Lista de resultados
        List<List<String>> results = new ArrayList<>();

        // For para recorrer las dos listas
        for (int i = 0; i < canales.size(); i++) {
            MessageActions canal = canales.get(i);
            Message msg = messages.get(i);

            // Guardar los 3 mensajes
            String r1 = canal.sendMessage(msg);
            String r2 = canal.reciveMessage(msg);
            String r3 = canal.respondMessage(msg);

            // Guardar los resultados en la lista resultados
            results.add(Arrays.asList(r1, r2, r3));
        }

        // Añadir al modelo
        model.addAttribute("results", results);

        return "message";
    }
}
