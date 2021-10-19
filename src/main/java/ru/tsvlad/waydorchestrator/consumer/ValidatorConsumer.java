package ru.tsvlad.waydorchestrator.consumer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.tsvlad.waydorchestrator.producer.EventProducer;

@Component
@Slf4j
@AllArgsConstructor
public class ValidatorConsumer {
    private final EventProducer eventProducer;

    @KafkaListener(id = "orchestrator-event-validation-customer", topics = {"event-validation-to-orchestrator"}, containerFactory = "singleFactory")
    public void consume(EventValidationMessage message) {
        eventProducer.eventValidationToEvent(message);
    }
}
