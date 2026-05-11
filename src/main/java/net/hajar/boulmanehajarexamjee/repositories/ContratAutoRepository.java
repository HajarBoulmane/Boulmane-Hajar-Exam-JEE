// repositories/ContratAutoRepository.java
package net.hajar.boulmanehajarexamjee.repositories;

import net.hajar.boulmanehajarexamjee.entities.ContratAuto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratAutoRepository
        extends JpaRepository<ContratAuto, Long> {}