package ru.tsvlad.waydorchestrator.messaging;

import lombok.*;
import ru.tsvlad.waydorchestrator.messaging.type.ValidatorMessageType;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ValidatorMessage extends AbstractMessage {
    private ValidatorMessageType type;
    private String eventId;
    private boolean isValid;
}
