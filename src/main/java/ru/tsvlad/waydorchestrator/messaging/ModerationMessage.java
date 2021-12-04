package ru.tsvlad.waydorchestrator.messaging;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.tsvlad.waydorchestrator.messaging.dto.BanDTO;
import ru.tsvlad.waydorchestrator.messaging.type.ModerationMessageType;

@EqualsAndHashCode(callSuper = true)
@Data
public class ModerationMessage extends AbstractMessage {
    private ModerationMessageType type;
    private BanDTO banDTO;
}