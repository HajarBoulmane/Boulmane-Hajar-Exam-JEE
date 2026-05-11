// services/impl/PaiementServiceImpl.java
package net.hajar.boulmanehajarexamjee.services;

import net.hajar.boulmanehajarexamjee.dtos.PaiementDTO;
import net.hajar.boulmanehajarexamjee.entities.Contrat;
import net.hajar.boulmanehajarexamjee.entities.Paiement;
import net.hajar.boulmanehajarexamjee.mappers.PaiementMapper;
import net.hajar.boulmanehajarexamjee.repositories.ContratRepository;
import net.hajar.boulmanehajarexamjee.repositories.PaiementRepository;
import net.hajar.boulmanehajarexamjee.services.PaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class PaiementServiceImpl implements PaiementService {

    @Autowired PaiementRepository paiementRepository;
    @Autowired ContratRepository contratRepository;
    @Autowired PaiementMapper paiementMapper;

    @Override
    public PaiementDTO addPaiement(Long contratId, PaiementDTO dto) {
        Contrat contrat = contratRepository.findById(contratId)
                .orElseThrow(() ->
                        new RuntimeException("Contrat non trouvé : " + contratId));
        Paiement paiement = new Paiement();
        paiement.setContrat(contrat);
        paiement.setDate(dto.getDate());
        paiement.setMontant(dto.getMontant());
        paiement.setTypePaiement(dto.getTypePaiement());
        return paiementMapper.toDTO(paiementRepository.save(paiement));
    }

    @Override
    public List<PaiementDTO> getPaiementsByContrat(Long contratId) {
        return paiementRepository.findByContratId(contratId)
                .stream()
                .map(paiementMapper::toDTO)
                .toList();
    }

    @Override
    public double getTotalPaiementsByContrat(Long contratId) {
        return paiementRepository.findByContratId(contratId)
                .stream()
                .mapToDouble(Paiement::getMontant)
                .sum();
    }
}