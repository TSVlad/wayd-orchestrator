package ru.tsvlad.waydorchestrator.producer;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.tsvlad.waydorchestrator.messaging.EventMessage;

@Service
@AllArgsConstructor
public class EventToValidatorProducer {
    private final KafkaTemplate<Long, EventMessage> eventMessageKafkaTemplate;

    public void eventToValidator(EventMessage message) {
        send(message);
    }

    private void send(EventMessage message) {
        eventMessageKafkaTemplate.send("event-to-validator", message);
    }
}
