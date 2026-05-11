// services/impl/ContratServiceImpl.java
package net.hajar.boulmanehajarexamjee.services;

import net.hajar.boulmanehajarexamjee.dtos.*;
import net.hajar.boulmanehajarexamjee.entities.*;
import net.hajar.boulmanehajarexamjee.enums.StatutContrat;
import net.hajar.boulmanehajarexamjee.mappers.ContratMapper;
import net.hajar.boulmanehajarexamjee.repositories.*;
import net.hajar.boulmanehajarexamjee.services.ContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class ContratServiceImpl implements ContratService {

    @Autowired ContratRepository contratRepository;
    @Autowired ContratAutoRepository autoRepository;
    @Autowired ContratHabitationRepository habitationRepository;
    @Autowired ContratSanteRepository santeRepository;
    @Autowired ClientRepository clientRepository;
    @Autowired ContratMapper contratMapper;

    @Override
    public ContratAutoDTO saveContratAuto(ContratAutoDTO dto) {
        Client client = clientRepository.findById(dto.getClientId())
                .orElseThrow(() ->
                        new RuntimeException("Client non trouvé"));
        ContratAuto auto = new ContratAuto();
        auto.setClient(client);
        auto.setDateSouscription(dto.getDateSouscription());
        auto.setStatut(StatutContrat.EN_COURS);
        auto.setMontantCotisation(dto.getMontantCotisation());
        auto.setDureeContrat(dto.getDureeContrat());
        auto.setTauxCouverture(dto.getTauxCouverture());
        auto.setNumeroImmatriculation(dto.getNumeroImmatriculation());
        auto.setMarqueVehicule(dto.getMarqueVehicule());
        auto.setModeleVehicule(dto.getModeleVehicule());
        return contratMapper.toAutoDTO(autoRepository.save(auto));
    }

    @Override
    public ContratHabitationDTO saveContratHabitation(
            ContratHabitationDTO dto) {
        Client client = clientRepository.findById(dto.getClientId())
                .orElseThrow(() ->
                        new RuntimeException("Client non trouvé"));
        ContratHabitation hab = new ContratHabitation();
        hab.setClient(client);
        hab.setDateSouscription(dto.getDateSouscription());
        hab.setStatut(StatutContrat.EN_COURS);
        hab.setMontantCotisation(dto.getMontantCotisation());
        hab.setDureeContrat(dto.getDureeContrat());
        hab.setTauxCouverture(dto.getTauxCouverture());
        hab.setTypeLogement(dto.getTypeLogement());
        hab.setAdresseLogement(dto.getAdresseLogement());
        hab.setSuperficie(dto.getSuperficie());
        return contratMapper.toHabitationDTO(
                habitationRepository.save(hab));
    }

    @Override
    public ContratSanteDTO saveContratSante(ContratSanteDTO dto) {
        Client client = clientRepository.findById(dto.getClientId())
                .orElseThrow(() ->
                        new RuntimeException("Client non trouvé"));
        ContratSante sante = new ContratSante();
        sante.setClient(client);
        sante.setDateSouscription(dto.getDateSouscription());
        sante.setStatut(StatutContrat.EN_COURS);
        sante.setMontantCotisation(dto.getMontantCotisation());
        sante.setDureeContrat(dto.getDureeContrat());
        sante.setTauxCouverture(dto.getTauxCouverture());
        sante.setNiveauCouverture(dto.getNiveauCouverture());
        sante.setNombrePersonnesCouvertes(
                dto.getNombrePersonnesCouvertes());
        return contratMapper.toSanteDTO(santeRepository.save(sante));
    }

    @Override
    public ContratDTO getContratById(Long id) {
        Contrat contrat = contratRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Contrat non trouvé : " + id));
        return contratMapper.toDTO(contrat);
    }

    @Override
    public List<ContratDTO> getAllContrats() {
        return contratRepository.findAll()
                .stream()
                .map(contratMapper::toDTO)
                .toList();
    }

    @Override
    public List<ContratDTO> getContratsByClient(Long clientId) {
        return contratRepository.findByClientId(clientId)
                .stream()
                .map(contratMapper::toDTO)
                .toList();
    }

    @Override
    public List<ContratDTO> getContratsByStatut(StatutContrat statut) {
        return contratRepository.findByStatut(statut)
                .stream()
                .map(contratMapper::toDTO)
                .toList();
    }

    @Override
    public ContratDTO updateStatut(Long id, StatutContrat statut) {
        Contrat contrat = contratRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Contrat non trouvé : " + id));
        contrat.setStatut(statut);
        if (statut == StatutContrat.VALIDE) {
            contrat.setDateValidation(LocalDate.now());
        }
        return contratMapper.toDTO(contratRepository.save(contrat));
    }

    @Override
    public void deleteContrat(Long id) {
        contratRepository.deleteById(id);
    }
}