package ru.tsvlad.waydorchestrator.producer;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.tsvlad.waydorchestrator.messaging.ModerationMessage;

@Service
@AllArgsConstructor
public class ModerationProducer {
    private final KafkaTemplate<Long, ModerationMessage> eventMessageKafkaTemplate;

    public void sendToUser(ModerationMessage moderationMessage) {
        eventMessageKafkaTemplate.send("moderation-to-user", moderationMessage);
    }
}
