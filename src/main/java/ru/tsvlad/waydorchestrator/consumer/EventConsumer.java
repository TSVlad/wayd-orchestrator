package ru.tsvlad.waydorchestrator.consumer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.tsvlad.waydorchestrator.messaging.EventMessage;
import ru.tsvlad.waydorchestrator.producer.EventProducer;

@Component
@Slf4j
@AllArgsConstructor
public class EventConsumer {

    private final EventProducer eventProducer;

    @KafkaListener(id = "orchestrator-event-customer", topics = {"event-topic"}, containerFactory = "singleFactory")
    public void consume(EventMessage message) {
        switch (message.getType()) {
            case CREATED:
                eventCreated(message);
                break;
        }

    }

    private void eventCreated(EventMessage eventMessage) {
        eventProducer.sendToValidator(eventMessage);
    }
}
