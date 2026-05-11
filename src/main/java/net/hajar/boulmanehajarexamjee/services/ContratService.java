// services/ContratService.java
package net.hajar.boulmanehajarexamjee.services;

import net.hajar.boulmanehajarexamjee.dtos.*;
import net.hajar.boulmanehajarexamjee.enums.StatutContrat;
import java.util.List;

public interface ContratService {
    ContratAutoDTO saveContratAuto(ContratAutoDTO dto);
    ContratHabitationDTO saveContratHabitation(ContratHabitationDTO dto);
    ContratSanteDTO saveContratSante(ContratSanteDTO dto);
    ContratDTO getContratById(Long id);
    List<ContratDTO> getAllContrats();
    List<ContratDTO> getContratsByClient(Long clientId);
    List<ContratDTO> getContratsByStatut(StatutContrat statut);
    ContratDTO updateStatut(Long id, StatutContrat statut);
    void deleteContrat(Long id);
}