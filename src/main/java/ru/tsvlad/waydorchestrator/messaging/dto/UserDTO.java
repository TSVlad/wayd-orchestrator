package ru.tsvlad.waydorchestrator.messaging.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class UserDTO {
    private long id;
    private String username;
    private List<RoleDTO> roles;
    private String description;
    private String contacts;
    private String email;
    private Validity validityBadWords;
    private UserStatus status;
    private LocalDate dateOfBirth;
}
