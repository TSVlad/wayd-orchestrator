package ru.tsvlad.waydorchestrator.messaging.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.ZonedDateTime;

@Data
public class BanDTO {
    private String id;

    private long userId;
    private String reason;
    private String comment;
    private ZonedDateTime banDateTime;
    private LocalDate banUntil;

    private long moderatorId;
}
