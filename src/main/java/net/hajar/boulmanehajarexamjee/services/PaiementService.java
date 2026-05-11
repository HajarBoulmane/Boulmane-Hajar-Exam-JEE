// services/PaiementService.java
package net.hajar.boulmanehajarexamjee.services;

import net.hajar.boulmanehajarexamjee.dtos.PaiementDTO;
import java.util.List;

public interface PaiementService {
    PaiementDTO addPaiement(Long contratId, PaiementDTO dto);
    List<PaiementDTO> getPaiementsByContrat(Long contratId);
    double getTotalPaiementsByContrat(Long contratId);
}