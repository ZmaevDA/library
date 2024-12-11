package ru.zmaev.library.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class BookOrderRequest {
    private UUID bookId;
    private UUID clientId;
}
