package ru.tsvlad.waydorchestrator.messaging.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class JwtPayload {
    private long id;
    private String username;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate expiredAt;
    private List<Role> roles;
}
