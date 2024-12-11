package ru.zmaev.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.zmaev.library.model.Client;

import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {
}
