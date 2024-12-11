package ru.zmaev.library.repository;

import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.zmaev.library.model.BookOrder;

import java.util.UUID;

@Repository
public interface BookOrderRepository extends JpaRepository<BookOrder, UUID> {

    @Override
    @NonNull
    @EntityGraph(attributePaths = {"book", "client"})
    Page<BookOrder> findAll(@NonNull Pageable pageable);
}
