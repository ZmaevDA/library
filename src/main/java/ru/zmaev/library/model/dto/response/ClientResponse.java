package ru.zmaev.library.model.dto.response;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class ClientResponse {
    private UUID id;
    private String fullName;
    private LocalDate birthDate;
}
