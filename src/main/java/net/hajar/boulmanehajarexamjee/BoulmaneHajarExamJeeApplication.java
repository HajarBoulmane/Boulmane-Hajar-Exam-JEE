package net.hajar.boulmanehajarexamjee;

import net.hajar.boulmanehajarexamjee.entities.*;
import net.hajar.boulmanehajarexamjee.enums.*;
import net.hajar.boulmanehajarexamjee.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class BoulmaneHajarExamJeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoulmaneHajarExamJeeApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(
            ClientRepository clientRepo,
            ContratAutoRepository autoRepo,
            ContratHabitationRepository habitRepo,
            ContratSanteRepository santeRepo,
            PaiementRepository paiementRepo) {

        return args -> {

            // ── Clients ──────────────────────────────────
            Client c1 = new Client();
            c1.setNom("Ahmed Benali");
            c1.setEmail("ahmed@mail.com");

            Client c2 = new Client();
            c2.setNom("Sara Alami");
            c2.setEmail("sara@mail.com");

            clientRepo.saveAll(List.of(c1, c2));

            // ── Contrat Auto pour c1 ─────────────────────
            ContratAuto auto = new ContratAuto();
            auto.setClient(c1);
            auto.setDateSouscription(LocalDate.of(2024, 1, 15));
            auto.setStatut(StatutContrat.VALIDE);
            auto.setDateValidation(LocalDate.of(2024, 1, 20));
            auto.setMontantCotisation(1200.0);
            auto.setDureeContrat(12);
            auto.setTauxCouverture(80.0);
            auto.setNumeroImmatriculation("12345-A-1");
            auto.setMarqueVehicule("Toyota");
            auto.setModeleVehicule("Corolla");
            autoRepo.save(auto);

            // ── Contrat Habitation pour c1 ───────────────
            ContratHabitation hab = new ContratHabitation();
            hab.setClient(c1);
            hab.setDateSouscription(LocalDate.of(2024, 3, 1));
            hab.setStatut(StatutContrat.EN_COURS);
            hab.setMontantCotisation(600.0);
            hab.setDureeContrat(24);
            hab.setTauxCouverture(90.0);
            hab.setTypeLogement(TypeLogement.APPARTEMENT);
            hab.setAdresseLogement("12 Rue Hassan II, Casablanca");
            hab.setSuperficie(85.0);
            habitRepo.save(hab);

            // ── Contrat Santé pour c2 ────────────────────
            ContratSante sante = new ContratSante();
            sante.setClient(c2);
            sante.setDateSouscription(LocalDate.of(2024, 5, 10));
            sante.setStatut(StatutContrat.EN_COURS);
            sante.setMontantCotisation(2400.0);
            sante.setDureeContrat(12);
            sante.setTauxCouverture(95.0);
            sante.setNiveauCouverture(NiveauCouverture.PREMIUM);
            sante.setNombrePersonnesCouvertes(4);
            santeRepo.save(sante);

            // ── Paiements ────────────────────────────────
            Paiement p1 = new Paiement();
            p1.setContrat(auto);
            p1.setDate(LocalDate.of(2024, 2, 1));
            p1.setMontant(100.0);
            p1.setTypePaiement(TypePaiement.MENSUALITE);

            Paiement p2 = new Paiement();
            p2.setContrat(auto);
            p2.setDate(LocalDate.of(2024, 3, 1));
            p2.setMontant(100.0);
            p2.setTypePaiement(TypePaiement.MENSUALITE);

            Paiement p3 = new Paiement();
            p3.setContrat(sante);
            p3.setDate(LocalDate.of(2024, 6, 1));
            p3.setMontant(2400.0);
            p3.setTypePaiement(TypePaiement.PAIEMENT_ANNUEL);

            paiementRepo.saveAll(List.of(p1, p2, p3));

            System.out.println("✅ Données insérées avec succès !");
        };
    }
}