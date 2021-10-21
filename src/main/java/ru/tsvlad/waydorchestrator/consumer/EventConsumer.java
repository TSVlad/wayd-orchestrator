package ru.tsvlad.waydorchestrator.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.tsvlad.waydorchestrator.messaging.EventMessage;
import ru.tsvlad.waydorchestrator.producer.EventToValidatorProducer;

@Component
@Slf4j
@AllArgsConstructor
public class EventConsumer {

    private final ObjectMapper objectMapper;
    private final EventToValidatorProducer eventToValidatorProducer;

    @KafkaListener(id = "orchestrator-event-customer", topics = {"event-topic"}, containerFactory = "singleFactory")
    public void consume(EventMessage message) {
        switch (message.getType()) {
            case CREATED:
                eventCreated(message);
                break;
        }

    }

    private void eventCreated(EventMessage eventMessage) {
        eventToValidatorProducer.eventToValidator(eventMessage);
    }
}
