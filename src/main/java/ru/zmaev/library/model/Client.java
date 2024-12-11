package ru.zmaev.library.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "client")
@Getter
@Setter
@RequiredArgsConstructor
public class Client {
    @Id
    @GeneratedValue
    private UUID id = UUID.randomUUID();
    @Column(name = "full_name")
    private String fullName;

    @Column(name = "birth_date")
    private LocalDate birthDate;
}
