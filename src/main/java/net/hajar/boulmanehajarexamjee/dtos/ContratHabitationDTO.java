// dtos/ContratHabitationDTO.java
package net.hajar.boulmanehajarexamjee.dtos;

import lombok.*;
import net.hajar.boulmanehajarexamjee.enums.StatutContrat;
import net.hajar.boulmanehajarexamjee.enums.TypeLogement;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContratHabitationDTO {
    private Long id;
    private LocalDate dateSouscription;
    private StatutContrat statut;
    private LocalDate dateValidation;
    private double montantCotisation;
    private int dureeContrat;
    private double tauxCouverture;
    private Long clientId;
    private TypeLogement typeLogement;
    private String adresseLogement;
    private double superficie;
}