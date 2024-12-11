package ru.zmaev.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.zmaev.library.model.Book;

import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {
}
