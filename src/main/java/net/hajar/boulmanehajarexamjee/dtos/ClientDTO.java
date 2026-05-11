// dtos/ClientDTO.java
package net.hajar.boulmanehajarexamjee.dtos;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientDTO {
    private Long id;
    private String nom;
    private String email;
}