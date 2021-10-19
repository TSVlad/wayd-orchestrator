package ru.tsvlad.waydorchestrator.producer;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.tsvlad.waydorchestrator.consumer.EventValidationMessage;

@Service
@AllArgsConstructor
public class EventProducer {
    private final KafkaTemplate<Long, EventValidationMessage> eventValidationMessageKafkaTemplate;

    public void eventValidationToEvent(EventValidationMessage message) {
        send(message);
    }

    private void send(EventValidationMessage message) {
        eventValidationMessageKafkaTemplate.send("event-validation-to-event", message);
    }
}
