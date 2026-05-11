// entities/ContratAuto.java
package net.hajar.boulmanehajarexamjee.entities;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
public class ContratAuto extends Contrat {
    private String numeroImmatriculation;
    private String marqueVehicule;
    private String modeleVehicule;
}