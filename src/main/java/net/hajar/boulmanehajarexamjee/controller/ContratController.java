package net.hajar.boulmanehajarexamjee.controller;

import net.hajar.boulmanehajarexamjee.dtos.*;
import net.hajar.boulmanehajarexamjee.enums.StatutContrat;
import net.hajar.boulmanehajarexamjee.services.ContratService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/contrats")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ContratController {

    private final ContratService contratService;

    @GetMapping
    @PreAuthorize("hasAnyRole('EMPLOYE','ADMIN')")
    public List<ContratDTO> getAllContrats() {
        return contratService.getAllContrats();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('CLIENT','EMPLOYE','ADMIN')")
    public ResponseEntity<ContratDTO> getContratById(@PathVariable Long id) {
        return ResponseEntity.ok(contratService.getContratById(id));
    }

    @PostMapping("/auto")
    @PreAuthorize("hasAnyRole('EMPLOYE','ADMIN')")
    public ResponseEntity<ContratAutoDTO> createAuto(@RequestBody ContratAutoDTO dto) {
        return ResponseEntity.ok(contratService.saveContratAuto(dto));
    }

    @PostMapping("/habitation")
    @PreAuthorize("hasAnyRole('EMPLOYE','ADMIN')")
    public ResponseEntity<ContratHabitationDTO> createHabitation(@RequestBody ContratHabitationDTO dto) {
        return ResponseEntity.ok(contratService.saveContratHabitation(dto));
    }

    @PostMapping("/sante")
    @PreAuthorize("hasAnyRole('EMPLOYE','ADMIN')")
    public ResponseEntity<ContratSanteDTO> createSante(@RequestBody ContratSanteDTO dto) {
        return ResponseEntity.ok(contratService.saveContratSante(dto));
    }

    @PatchMapping("/{id}/statut")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ContratDTO> updateStatut(@PathVariable Long id, @RequestParam StatutContrat statut) {
        return ResponseEntity.ok(contratService.updateStatut(id, statut));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteContrat(@PathVariable Long id) {
        contratService.deleteContrat(id);
        return ResponseEntity.noContent().build();
    }
}