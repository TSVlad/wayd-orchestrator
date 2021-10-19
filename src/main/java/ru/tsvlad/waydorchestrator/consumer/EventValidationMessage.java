package ru.tsvlad.waydorchestrator.consumer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.tsvlad.waydorchestrator.messaging.AbstractMessage;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventValidationMessage extends AbstractMessage {
    private String eventId;
    private boolean isValid;
}
