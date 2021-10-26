package ru.tsvlad.waydorchestrator.messaging.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    private long id;
    private String username;
    private List<RoleDTO> roles;
    private String contacts;
    private String email;
}
