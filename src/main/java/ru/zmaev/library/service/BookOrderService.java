package ru.zmaev.library.service;

import org.springframework.data.domain.Page;
import ru.zmaev.library.model.dto.response.ReadingClientResponse;

import java.util.UUID;

public interface BookOrderService {
    void assignBookToClient(UUID bookId, UUID clientId);

    Page<ReadingClientResponse> findAllReading(int pageNumber, int pageSize);
}
