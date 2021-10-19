package ru.tsvlad.waydorchestrator.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.tsvlad.waydorchestrator.messaging.EventMessage;
import ru.tsvlad.waydorchestrator.producer.ValidatorProducer;

@Component
@Slf4j
@AllArgsConstructor
public class EventConsumer {

    private final ObjectMapper objectMapper;
    private final ValidatorProducer validatorProducer;

    @KafkaListener(id = "orchestrator-event-customer", topics = {"event-to-orchestrator"}, containerFactory = "singleFactory")
    public void consume(EventMessage message) {
        validatorProducer.eventToValidator(message);
    }
}
