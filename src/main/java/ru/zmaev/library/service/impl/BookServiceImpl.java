package ru.zmaev.library.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.zmaev.library.exception.NotFoundException;
import ru.zmaev.library.mapper.BookMapper;
import ru.zmaev.library.model.Book;
import ru.zmaev.library.model.dto.request.BookRequest;
import ru.zmaev.library.model.dto.response.BookResponse;
import ru.zmaev.library.repository.BookRepository;
import ru.zmaev.library.service.BookService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    public static final String BOOK_NOT_FOUND = "BOOK_NOT_FOUND";

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    @Transactional
    public BookResponse save(BookRequest bookRequest) {
        Book book = bookMapper.toEntity(bookRequest);
        Book savedBook = bookRepository.save(book);
        return bookMapper.toResponse(savedBook);
    }

    @Override
    public Page<BookResponse> findAll(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return bookRepository.findAll(pageable).map(bookMapper::toResponse);
    }

    @Override
    public BookResponse findById(UUID id) {
        Book book = findByIdOrThrow(id);
        return bookMapper.toResponse(book);
    }

    @Override
    @Transactional
    public BookResponse update(UUID id, BookRequest bookRequest) {
        Book book = findByIdOrThrow(id);
        bookMapper.updateBookFromRequest(bookRequest, book);
        Book updatedBook = bookRepository.save(book);
        return bookMapper.toResponse(updatedBook);
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        Book book = findByIdOrThrow(id);
        bookRepository.delete(book);
    }

    @Override
    public Book findByIdOrThrow(UUID id) {
        return bookRepository.findById(id).orElseThrow(() ->
                new NotFoundException(BOOK_NOT_FOUND, "Book with id " + id + " not found"));
    }
}
