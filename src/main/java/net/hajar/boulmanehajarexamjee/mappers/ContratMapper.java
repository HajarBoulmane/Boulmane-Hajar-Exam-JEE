// mappers/ContratMapper.java
package net.hajar.boulmanehajarexamjee.mappers;

import net.hajar.boulmanehajarexamjee.dtos.*;
import net.hajar.boulmanehajarexamjee.entities.*;
import org.springframework.stereotype.Component;

@Component
public class ContratMapper {

    public ContratDTO toDTO(Contrat c) {
        if (c == null) return null;
        return ContratDTO.builder()
                .id(c.getId())
                .type(c.getClass().getSimpleName())
                .dateSouscription(c.getDateSouscription())
                .statut(c.getStatut())
                .dateValidation(c.getDateValidation())
                .montantCotisation(c.getMontantCotisation())
                .dureeContrat(c.getDureeContrat())
                .tauxCouverture(c.getTauxCouverture())
                .clientId(c.getClient() != null ?
                        c.getClient().getId() : null)
                .clientNom(c.getClient() != null ?
                        c.getClient().getNom() : null)
                .build();
    }

    public ContratAutoDTO toAutoDTO(ContratAuto c) {
        if (c == null) return null;
        return ContratAutoDTO.builder()
                .id(c.getId())
                .dateSouscription(c.getDateSouscription())
                .statut(c.getStatut())
                .dateValidation(c.getDateValidation())
                .montantCotisation(c.getMontantCotisation())
                .dureeContrat(c.getDureeContrat())
                .tauxCouverture(c.getTauxCouverture())
                .clientId(c.getClient() != null ?
                        c.getClient().getId() : null)
                .numeroImmatriculation(c.getNumeroImmatriculation())
                .marqueVehicule(c.getMarqueVehicule())
                .modeleVehicule(c.getModeleVehicule())
                .build();
    }

    public ContratHabitationDTO toHabitationDTO(ContratHabitation c) {
        if (c == null) return null;
        return ContratHabitationDTO.builder()
                .id(c.getId())
                .dateSouscription(c.getDateSouscription())
                .statut(c.getStatut())
                .dateValidation(c.getDateValidation())
                .montantCotisation(c.getMontantCotisation())
                .dureeContrat(c.getDureeContrat())
                .tauxCouverture(c.getTauxCouverture())
                .clientId(c.getClient() != null ?
                        c.getClient().getId() : null)
                .typeLogement(c.getTypeLogement())
                .adresseLogement(c.getAdresseLogement())
                .superficie(c.getSuperficie())
                .build();
    }

    public ContratSanteDTO toSanteDTO(ContratSante c) {
        if (c == null) return null;
        return ContratSanteDTO.builder()
                .id(c.getId())
                .dateSouscription(c.getDateSouscription())
                .statut(c.getStatut())
                .dateValidation(c.getDateValidation())
                .montantCotisation(c.getMontantCotisation())
                .dureeContrat(c.getDureeContrat())
                .tauxCouverture(c.getTauxCouverture())
                .clientId(c.getClient() != null ?
                        c.getClient().getId() : null)
                .niveauCouverture(c.getNiveauCouverture())
                .nombrePersonnesCouvertes(c.getNombrePersonnesCouvertes())
                .build();
    }
}