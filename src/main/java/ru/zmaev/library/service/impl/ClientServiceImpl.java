package ru.zmaev.library.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.zmaev.library.exception.NotFoundException;
import ru.zmaev.library.mapper.ClientMapper;
import ru.zmaev.library.model.Client;
import ru.zmaev.library.model.dto.request.ClientRequest;
import ru.zmaev.library.model.dto.response.ClientResponse;
import ru.zmaev.library.repository.ClientRepository;
import ru.zmaev.library.service.ClientService;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    public static final String CLIENT_NOT_FOUND = "CLIENT_NOT_FOUND";

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public Page<ClientResponse> findAll(
            int pageNumber,
            int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return clientRepository.findAll(pageable).map(clientMapper::toResponse);
    }

    @Override
    public ClientResponse findById(UUID id) {
        Client client = findByIdOrThrow(id);
        return clientMapper.toResponse(client);
    }

    @Override
    @Transactional
    public ClientResponse save(ClientRequest request) {
        Client client = clientMapper.toEntity(request);
        Client savedClient = clientRepository.save(client);
        return clientMapper.toResponse(savedClient);
    }

    @Override
    @Transactional
    public ClientResponse update(UUID id, ClientRequest clientRequest) {
        Client client = findByIdOrThrow(id);
        clientMapper.updateClientFromRequest(clientRequest, client);
        Client savedClient = clientRepository.save(client);
        return clientMapper.toResponse(savedClient);
    }

    @Override
    public void delete(UUID id) {
        Client client = findByIdOrThrow(id);
        clientRepository.delete(client);
    }

    @Override
    public Client findByIdOrThrow(UUID id) {
        return clientRepository.findById(id).orElseThrow(() ->
                new NotFoundException(CLIENT_NOT_FOUND, "Client with id " + id + " not found")
        );
    }
}
