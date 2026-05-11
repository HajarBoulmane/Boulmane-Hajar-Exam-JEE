// dtos/ContratDTO.java
package net.hajar.boulmanehajarexamjee.dtos;

import lombok.*;
import net.hajar.boulmanehajarexamjee.enums.StatutContrat;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContratDTO {
    private Long id;
    private String type;
    private LocalDate dateSouscription;
    private StatutContrat statut;
    private LocalDate dateValidation;
    private double montantCotisation;
    private int dureeContrat;
    private double tauxCouverture;
    private Long clientId;
    private String clientNom;
}