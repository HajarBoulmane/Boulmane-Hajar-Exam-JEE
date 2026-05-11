// entities/ContratHabitation.java
package net.hajar.boulmanehajarexamjee.entities;

import jakarta.persistence.*;
import lombok.*;
import net.hajar.boulmanehajarexamjee.enums.TypeLogement;

@Entity
@Data
@NoArgsConstructor
public class ContratHabitation extends Contrat {

    @Enumerated(EnumType.STRING)
    private TypeLogement typeLogement;

    private String adresseLogement;
    private double superficie;
}