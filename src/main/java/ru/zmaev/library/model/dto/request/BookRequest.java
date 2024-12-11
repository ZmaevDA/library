package ru.zmaev.library.model.dto.request;

import lombok.Data;

@Data
public class BookRequest {
    private String title;
    private String author;
    private String isbn;
}