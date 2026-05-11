// entities/ContratSante.java
package net.hajar.boulmanehajarexamjee.entities;

import jakarta.persistence.*;
import lombok.*;
import net.hajar.boulmanehajarexamjee.enums.NiveauCouverture;

@Entity
@Data
@NoArgsConstructor
public class ContratSante extends Contrat {

    @Enumerated(EnumType.STRING)
    private NiveauCouverture niveauCouverture;

    private int nombrePersonnesCouvertes;
}