// mappers/PaiementMapper.java
package net.hajar.boulmanehajarexamjee.mappers;

import net.hajar.boulmanehajarexamjee.dtos.PaiementDTO;
import net.hajar.boulmanehajarexamjee.entities.Paiement;
import org.springframework.stereotype.Component;

@Component
public class PaiementMapper {

    public PaiementDTO toDTO(Paiement p) {
        if (p == null) return null;
        return PaiementDTO.builder()
                .id(p.getId())
                .date(p.getDate())
                .montant(p.getMontant())
                .typePaiement(p.getTypePaiement())
                .contratId(p.getContrat() != null ?
                        p.getContrat().getId() : null)
                .build();
    }
}