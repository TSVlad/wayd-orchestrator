package ru.tsvlad.waydorchestrator.producer;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.tsvlad.waydorchestrator.messaging.ValidatorMessage;

@Service
@AllArgsConstructor
public class ValidatorToEventProducer {
    private final KafkaTemplate<Long, ValidatorMessage> eventValidationMessageKafkaTemplate;

    public void eventValidationToEvent(ValidatorMessage message) {
        send(message);
    }

    private void send(ValidatorMessage message) {
        eventValidationMessageKafkaTemplate.send("validator-to-event", message);
    }
}
