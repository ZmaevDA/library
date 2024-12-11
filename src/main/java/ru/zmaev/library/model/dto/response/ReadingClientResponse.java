package ru.zmaev.library.model.dto.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReadingClientResponse {
    private String fullName;
    private LocalDate birthDate;
    private String bookTitle;
    private String author;
    private String isbn;
    private LocalDate dateOfIssue;
}
