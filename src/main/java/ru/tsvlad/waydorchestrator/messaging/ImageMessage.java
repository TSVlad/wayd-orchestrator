package ru.tsvlad.waydorchestrator.messaging;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import ru.tsvlad.waydorchestrator.messaging.type.ImageMessageType;

@EqualsAndHashCode(callSuper = true)
@Data
public class ImageMessage extends AbstractMessage {
    private ImageMessageType type;
    private String imageName;
    private byte[] image;
}
