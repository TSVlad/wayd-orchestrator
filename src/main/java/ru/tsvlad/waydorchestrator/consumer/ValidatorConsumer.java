package ru.tsvlad.waydorchestrator.consumer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.tsvlad.waydorchestrator.messaging.ValidatorMessage;
import ru.tsvlad.waydorchestrator.messaging.type.ValidatorMessageType;
import ru.tsvlad.waydorchestrator.producer.ValidatorToEventProducer;

@Component
@Slf4j
@AllArgsConstructor
public class ValidatorConsumer {
    private final ValidatorToEventProducer validatorToEventProducer;

    @KafkaListener(id = "orchestrator-event-validation-customer", topics = {"validator-topic"}, containerFactory = "singleFactory")
    public void consume(ValidatorMessage message) {
        switch (message.getType()) {
            case EVENT_VALIDATED:
                eventValidated(message);
                break;
        }

    }

    private void eventValidated(ValidatorMessage message) {
        validatorToEventProducer.eventValidationToEvent(message);
    }
}
