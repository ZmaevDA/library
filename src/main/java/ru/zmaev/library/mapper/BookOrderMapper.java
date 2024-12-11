package ru.zmaev.library.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.zmaev.library.model.Book;
import ru.zmaev.library.model.BookOrder;
import ru.zmaev.library.model.Client;
import ru.zmaev.library.model.dto.response.ReadingClientResponse;

@Mapper(componentModel = "spring")
public interface BookOrderMapper {
    @Mapping(target = "borrowDate", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "id", ignore = true)
    BookOrder toEntity(Book book, Client client);

    @Mapping(source = "book.title", target = "bookTitle")
    @Mapping(source = "book.author", target = "author")
    @Mapping(source = "book.isbn", target = "isbn")
    @Mapping(source = "client.fullName", target = "fullName")
    @Mapping(source = "client.birthDate", target = "birthDate")
    ReadingClientResponse toFullResponse(BookOrder bookOrder);
}
