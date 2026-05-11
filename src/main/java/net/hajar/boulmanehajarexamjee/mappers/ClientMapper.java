// mappers/ClientMapper.java
package net.hajar.boulmanehajarexamjee.mappers;

import net.hajar.boulmanehajarexamjee.dtos.ClientDTO;
import net.hajar.boulmanehajarexamjee.entities.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public ClientDTO toDTO(Client client) {
        if (client == null) return null;
        return ClientDTO.builder()
                .id(client.getId())
                .nom(client.getNom())
                .email(client.getEmail())
                .build();
    }

    public Client toEntity(ClientDTO dto) {
        if (dto == null) return null;
        Client client = new Client();
        client.setId(dto.getId());
        client.setNom(dto.getNom());
        client.setEmail(dto.getEmail());
        return client;
    }
}