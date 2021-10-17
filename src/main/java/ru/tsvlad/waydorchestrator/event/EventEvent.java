package ru.tsvlad.waydorchestrator.event;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.tsvlad.waydorchestrator.event.dto.EventDTO;
import ru.tsvlad.waydorchestrator.event.type.EventEventType;

@EqualsAndHashCode(callSuper = true)
@Data
public class EventEvent extends AbstractEvent {
    private EventEventType type;
    private EventDTO eventDTO;

    public EventEvent() {
        super();
    }

    public EventEvent(EventEventType type, EventDTO eventDTO) {
        super();
        this.type = type;
        this.eventDTO = eventDTO;
    }
}
