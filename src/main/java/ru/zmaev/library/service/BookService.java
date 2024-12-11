package ru.zmaev.library.service;

import org.springframework.data.domain.Page;
import ru.zmaev.library.model.Book;
import ru.zmaev.library.model.dto.request.BookRequest;
import ru.zmaev.library.model.dto.response.BookResponse;

import java.util.UUID;

public interface BookService {
    BookResponse save(BookRequest bookRequest);

    Page<BookResponse> findAll(int pageNumber, int pageSize);

    BookResponse findById(UUID id);
    BookResponse update(UUID id, BookRequest bookRequest);
    void delete(UUID id);

    Book findByIdOrThrow(UUID id);
}
