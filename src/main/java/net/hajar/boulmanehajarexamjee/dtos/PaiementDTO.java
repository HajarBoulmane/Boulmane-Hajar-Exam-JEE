// dtos/PaiementDTO.java
package net.hajar.boulmanehajarexamjee.dtos;

import lombok.*;
import net.hajar.boulmanehajarexamjee.enums.TypePaiement;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaiementDTO {
    private Long id;
    private LocalDate date;
    private double montant;
    private TypePaiement typePaiement;
    private Long contratId;
}