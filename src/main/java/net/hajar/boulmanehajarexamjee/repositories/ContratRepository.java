// repositories/ContratRepository.java
package net.hajar.boulmanehajarexamjee.repositories;

import net.hajar.boulmanehajarexamjee.entities.Contrat;
import net.hajar.boulmanehajarexamjee.enums.StatutContrat;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ContratRepository extends JpaRepository<Contrat, Long> {
    List<Contrat> findByClientId(Long clientId);
    List<Contrat> findByStatut(StatutContrat statut);
}