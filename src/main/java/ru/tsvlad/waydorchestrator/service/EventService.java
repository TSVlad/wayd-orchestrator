package ru.tsvlad.waydorchestrator.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.tsvlad.waydorchestrator.event.EventEvent;

@Service
@AllArgsConstructor
public class EventService {
    private final KafkaTemplate<Long, EventEvent> kafkaStarshipTemplate;


    public void send(EventEvent dto) {
        kafkaStarshipTemplate.send("server.starship", dto);
    }
}
