package ru.tsvlad.waydorchestrator.service;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.tsvlad.waydorchestrator.messaging.EventMessage;

@Service
@AllArgsConstructor
public class EventService {
    private final KafkaTemplate<Long, EventMessage> kafkaStarshipTemplate;


    public void send(EventMessage dto) {
        kafkaStarshipTemplate.send("server.starship", dto);
    }
}
