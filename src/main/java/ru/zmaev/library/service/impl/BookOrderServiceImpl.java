package ru.zmaev.library.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.zmaev.library.mapper.BookOrderMapper;
import ru.zmaev.library.model.Book;
import ru.zmaev.library.model.BookOrder;
import ru.zmaev.library.model.Client;
import ru.zmaev.library.model.dto.response.ReadingClientResponse;
import ru.zmaev.library.repository.BookOrderRepository;
import ru.zmaev.library.service.BookOrderService;
import ru.zmaev.library.service.BookService;
import ru.zmaev.library.service.ClientService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookOrderServiceImpl implements BookOrderService {

    private final BookService bookService;
    private final ClientService clientService;

    private final BookOrderRepository bookOrderRepository;
    private final BookOrderMapper bookOrderMapper;

    @Override
    @Transactional
    public void assignBookToClient(UUID bookId, UUID clientId) {
        Book book = bookService.findByIdOrThrow(bookId);
        Client client = clientService.findByIdOrThrow(clientId);

        BookOrder bookOrder = bookOrderMapper.toEntity(book, client);
        bookOrderRepository.save(bookOrder);
    }

    @Override
    public Page<ReadingClientResponse> findAllReading(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return bookOrderRepository.findAll(pageable).map(bookOrderMapper::toFullResponse);
    }
}
