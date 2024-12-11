package ru.zmaev.library.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "book")
@Getter
@Setter
@RequiredArgsConstructor
public class Book {
    @Id
    @GeneratedValue
    private UUID id = UUID.randomUUID();
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "isbn")
    private String isbn;
}
