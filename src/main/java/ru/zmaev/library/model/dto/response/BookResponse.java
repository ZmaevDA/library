package ru.zmaev.library.model.dto.response;

import lombok.Data;

import java.util.UUID;

@Data
public class BookResponse {
    private UUID id;
    private String title;
    private String author;
    private String isbn;
}