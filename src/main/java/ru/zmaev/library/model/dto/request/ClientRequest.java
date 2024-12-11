package ru.zmaev.library.model.dto.request;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class ClientRequest {
    private String fullName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
}
