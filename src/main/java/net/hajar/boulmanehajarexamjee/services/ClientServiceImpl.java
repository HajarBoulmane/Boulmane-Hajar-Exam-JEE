package net.hajar.boulmanehajarexamjee.services;

import net.hajar.boulmanehajarexamjee.dtos.ClientDTO;
import net.hajar.boulmanehajarexamjee.entities.Client;
import net.hajar.boulmanehajarexamjee.mappers.ClientMapper;
import net.hajar.boulmanehajarexamjee.repositories.ClientRepository;
import net.hajar.boulmanehajarexamjee.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    @Autowired ClientRepository clientRepository;
    @Autowired ClientMapper clientMapper;

    @Override
    public ClientDTO saveClient(ClientDTO dto) {
        Client client = clientMapper.toEntity(dto);
        return clientMapper.toDTO(clientRepository.save(client));
    }

    @Override
    public ClientDTO getClientById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Client non trouvé : " + id));
        return clientMapper.toDTO(client);
    }

    @Override
    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll()
                .stream()
                .map(clientMapper::toDTO)
                .toList();
    }

    @Override
    public List<ClientDTO> searchClients(String nom) {
        return clientRepository
                .findByNomContainingIgnoreCase(nom)
                .stream()
                .map(clientMapper::toDTO)
                .toList();
    }

    @Override
    public ClientDTO updateClient(Long id, ClientDTO dto) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Client non trouvé : " + id));
        client.setNom(dto.getNom());
        client.setEmail(dto.getEmail());
        return clientMapper.toDTO(clientRepository.save(client));
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}