package ru.zmaev.library.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "book_order")
@Getter
@Setter
@RequiredArgsConstructor
public class BookOrder {
    @Id
    @GeneratedValue
    private UUID id = UUID.randomUUID();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    @Column(name = "borrow_date")
    private LocalDateTime borrowDate;
}
