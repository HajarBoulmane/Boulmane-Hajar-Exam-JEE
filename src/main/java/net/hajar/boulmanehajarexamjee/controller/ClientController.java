package net.hajar.boulmanehajarexamjee.controller;

import net.hajar.boulmanehajarexamjee.dtos.ClientDTO;
import net.hajar.boulmanehajarexamjee.services.ClientService;
import lombok.RequiredArgsConstructor;
import net.hajar.boulmanehajarexamjee.services.ContratService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ClientController {

    private final ClientService clientService;
    private final ContratService contratService;

    @GetMapping
    @PreAuthorize("hasAnyRole('EMPLOYE','ADMIN')")
    public List<ClientDTO> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('EMPLOYE','ADMIN')")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ClientDTO> createClient(@RequestBody ClientDTO dto) {
        return ResponseEntity.ok(clientService.saveClient(dto));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ClientDTO> updateClient(@PathVariable Long id, @RequestBody ClientDTO dto) {
        return ResponseEntity.ok(clientService.updateClient(id, dto));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/contrats")
    @PreAuthorize("hasAnyRole('CLIENT','EMPLOYE','ADMIN')")
    public ResponseEntity<?> getContratsByClient(@PathVariable Long id) {
        return ResponseEntity.ok(contratService.getContratsByClient(id)); // from contratService
    }
}