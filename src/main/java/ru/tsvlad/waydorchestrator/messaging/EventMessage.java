package ru.tsvlad.waydorchestrator.messaging;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.tsvlad.waydorchestrator.messaging.dto.EventDTO;
import ru.tsvlad.waydorchestrator.messaging.type.EventEventType;

@EqualsAndHashCode(callSuper = true)
@Data
public class EventMessage extends AbstractMessage {
    private EventEventType type;
    private EventDTO eventDTO;

    public EventMessage() {
        super();
    }

    public EventMessage(EventEventType type, EventDTO eventDTO) {
        super();
        this.type = type;
        this.eventDTO = eventDTO;
    }
}
