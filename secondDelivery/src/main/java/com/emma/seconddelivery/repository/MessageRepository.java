package com.emma.firstdelivery.repository;

import com.emma.firstdelivery.model.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class MessageRepository {

    List<MessageActions> objects = new ArrayList<>();

    public MessageRepository () {
        // Email messages
        List<Message> lista0 = new ArrayList<>();

        List<Message> lista1a = Arrays.asList(
                new Message("Lila", "Arturo", "Bienvenido a mi app", 1)
        );
        List<Message> lista1b = Arrays.asList(
                new Message("Arturo", "Lila", "Que bonita app", 1)
        );

        List<Message> lista2a = Arrays.asList(
                new Message("Juan", "María", "Hola, lista para la salida", 2),
                new Message("María", "Juan", "Hola, si la estoy esperando", 2)
        );
        List<Message> lista2b = Arrays.asList(
                new Message("Juan", "María", "Nos vemos a las 5pm", 2),
                new Message("María", "Juan", "Aqui te espero", 2)
        );

        List<Message> lista3a = Arrays.asList(
                new Message("Emmanuel", "Sara", "Hola, te llamaba para saber como estas", 3),
                new Message("Sara", "Emmanuel", "Hola, bien gracias por preguntar, y tu?", 3),
                new Message("Emmanuel", "Sara", "Muy bien, me alegro que estes bien", 3)
        );
        List<Message> lista3b = Arrays.asList(
                new Message("Emmanuel", "Sara", "Que vas a hacer ahora en la tarde?", 3),
                new Message("Sara", "Emmanuel", "Nada, y tu?", 3),
                new Message("Emmanuel", "Sara", "Ir al centro comercial contigo", 3)
        );

        List<Message> lista4a = Arrays.asList(
                new Message("Naufrago", "Barco", "S.O.S", 4),
                new Message("Barco", "Naufrago", "Ya vamos hacia ti", 4),
                new Message("Naufrago", "Barco", "Gracias, y porfavor traigan comida", 4),
                new Message("Barco", "Naufrago", "Comida?", 4)
        );
        List<Message> lista4b = Arrays.asList(
                new Message("Naufrago", "Barco", "Si, necesito comida", 4),
                new Message("Barco", "Naufrago", "Y que te apetece?", 4),
                new Message("Naufrago", "Barco", "Un pollo Frisby", 4),
                new Message("Barco", "Naufrago", "Se le tiene", 4)
        );

        List<Message> lista5a = Arrays.asList(
                new Message("Hermana", "Hermano", "Ya estas en la casa?", 5),
                new Message("Hermano", "Hermana", "Si", 5),
                new Message("Hermana", "Hermano", "A bueno, ayudame descongelando el pollo", 5),
                new Message("Hermano", "Hermana", "La pechuga de 500g?", 5),
                new Message("Hermana", "Hermano", "Mjum, esa misma", 5)
        );
        List<Message> lista5b = Arrays.asList(
                new Message("Hermano", "Hermana", "Ya esta descongelandose", 5),
                new Message("Hermana", "Hermano", "Ya la habias puesto?", 5),
                new Message("Hermano", "Hermana", "Si, incluso le prepare un marinado especial", 5),
                new Message("Hermana", "Hermano", "Okey, me das un plato porfavor", 5),
                new Message("Hermano", "Hermana", "Va", 6)
        );

        // ---- 12 objetos ----
        objects.add(new Email("none@mail.com", lista0));
        objects.add(new Email("anything@mail.com", lista0));

        objects.add(new SmokeSign("L.A.R", lista1a));
        objects.add(new SmokeSign("J.I.N", lista1b));

        objects.add(new Email("juan@email.com", lista2a));
        objects.add(new Email("maria@email.com", lista2b));

        objects.add(new PhoneNumber("3210000000", lista3a));
        objects.add(new PhoneNumber("3210000000", lista3b));

        objects.add(new SmokeSign("S.O.S", lista4a));
        objects.add(new SmokeSign("OO.SS.OO", lista4b));

        objects.add(new PhoneNumber("3215500000", lista5a));
        objects.add(new PhoneNumber("3216600000", lista5b));
    }

    public List<MessageActions> findAll() {
        return objects;
    }
}
