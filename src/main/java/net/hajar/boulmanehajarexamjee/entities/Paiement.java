// entities/Paiement.java
package net.hajar.boulmanehajarexamjee.entities;

import jakarta.persistence.*;
import lombok.*;
import net.hajar.boulmanehajarexamjee.enums.TypePaiement;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paiement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private double montant;

    @Enumerated(EnumType.STRING)
    private TypePaiement typePaiement;

    @ManyToOne
    @JoinColumn(name = "contrat_id")
    private Contrat contrat;
}