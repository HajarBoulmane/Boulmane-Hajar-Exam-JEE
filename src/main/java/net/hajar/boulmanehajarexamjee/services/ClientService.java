// services/ClientService.java
package net.hajar.boulmanehajarexamjee.services;

import net.hajar.boulmanehajarexamjee.dtos.ClientDTO;
import java.util.List;

public interface ClientService {
    ClientDTO saveClient(ClientDTO dto);
    ClientDTO getClientById(Long id);
    List<ClientDTO> getAllClients();
    List<ClientDTO> searchClients(String nom);
    ClientDTO updateClient(Long id, ClientDTO dto);
    void deleteClient(Long id);
}