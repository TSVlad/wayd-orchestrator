package ru.tsvlad.waydorchestrator.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.tsvlad.waydorchestrator.messaging.EventMessage;

@Component
@Slf4j
@AllArgsConstructor
public class EventConsumer {

    private final ObjectMapper objectMapper;

    @KafkaListener(id = "orchestrator-event-customer", topics = {"event-to-orchestrator"}, containerFactory = "singleFactory")
    public void consume(EventMessage dto) {
        log.info("=> consumed {}", writeValueAsString(dto));
    }

    private String writeValueAsString(EventMessage dto) {
        try {
            return objectMapper.writeValueAsString(dto);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("Writing value to JSON failed: " + dto.toString());
        }
    }
}
