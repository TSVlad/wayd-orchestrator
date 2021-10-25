package ru.tsvlad.waydorchestrator.messaging;

import lombok.*;
import ru.tsvlad.waydorchestrator.messaging.dto.ConfirmationCodeDTO;
import ru.tsvlad.waydorchestrator.messaging.dto.UserPublicDTO;
import ru.tsvlad.waydorchestrator.messaging.type.UserMessageType;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserMessage extends AbstractMessage {
    private UserMessageType type;
    private UserPublicDTO userDTO;
    private ConfirmationCodeDTO confirmationCodeDTO;
}
