package ru.zmaev.library.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ru.zmaev.library.model.Book;
import ru.zmaev.library.model.dto.request.BookRequest;
import ru.zmaev.library.model.dto.response.BookResponse;

@Mapper(componentModel = "spring")
public interface BookMapper {
    Book toEntity(BookRequest request);

    BookResponse toResponse(Book book);

    void updateBookFromRequest(BookRequest request, @MappingTarget Book book);
}
