package net.hajar.boulmanehajarexamjee.controller;

import net.hajar.boulmanehajarexamjee.dtos.PaiementDTO;
import net.hajar.boulmanehajarexamjee.services.PaiementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class PaiementController {

    private final PaiementService paiementService;

    @PostMapping("/contrats/{contratId}/paiements")
    @PreAuthorize("hasAnyRole('EMPLOYE','ADMIN')")
    public ResponseEntity<PaiementDTO> addPaiement(@PathVariable Long contratId, @RequestBody PaiementDTO dto) {
        return ResponseEntity.ok(paiementService.addPaiement(contratId, dto));
    }

    @GetMapping("/contrats/{contratId}/paiements")
    @PreAuthorize("hasAnyRole('CLIENT','EMPLOYE','ADMIN')")
    public List<PaiementDTO> getPaiementsByContrat(@PathVariable Long contratId) {
        return paiementService.getPaiementsByContrat(contratId);
    }

    @DeleteMapping("/paiements/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deletePaiement(@PathVariable Long id) {
        paiementService.deletePaiement(id);
        return ResponseEntity.noContent().build();
    }
}