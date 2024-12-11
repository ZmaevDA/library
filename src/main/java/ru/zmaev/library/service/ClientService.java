package ru.zmaev.library.service;

import org.springframework.data.domain.Page;
import ru.zmaev.library.model.Client;
import ru.zmaev.library.model.dto.request.ClientRequest;
import ru.zmaev.library.model.dto.response.ClientResponse;

import java.util.UUID;

public interface ClientService {
    Page<ClientResponse> findAll(int pageNumber, int pageSize);

    ClientResponse findById(UUID id);

    ClientResponse save(ClientRequest request);

    ClientResponse update(UUID id, ClientRequest clientRequest);

    void delete(UUID id);

    Client findByIdOrThrow(UUID id);
}
