// repositories/PaiementRepository.java
package net.hajar.boulmanehajarexamjee.repositories;

import net.hajar.boulmanehajarexamjee.entities.Paiement;
import net.hajar.boulmanehajarexamjee.enums.TypePaiement;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PaiementRepository
        extends JpaRepository<Paiement, Long> {
    List<Paiement> findByContratId(Long contratId);
    List<Paiement> findByTypePaiement(TypePaiement type);
}