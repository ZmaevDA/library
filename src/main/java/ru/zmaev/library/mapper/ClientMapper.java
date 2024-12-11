package ru.zmaev.library.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ru.zmaev.library.model.Client;
import ru.zmaev.library.model.dto.request.ClientRequest;
import ru.zmaev.library.model.dto.response.ClientResponse;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    Client toEntity(ClientRequest clientRequest);
    ClientResponse toResponse(Client client);

    void updateClientFromRequest(ClientRequest request, @MappingTarget Client client);
}
