# 🛡️ Gestion des Contrats d'Assurance

> Exam project — Architecture Distribuée et Middleware  
> ENSET Mohammedia, Université Hassan II — Pr. YOUSSFI  
> Filières : GLSID / II-BDCC

---

## 📋 Table of Contents

- [Overview](#overview)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [Database Configuration](#database-configuration)
- [API Documentation](#api-documentation)
- [Security](#security)
- [Frontend](#frontend)
- [Class Diagram](#class-diagram)
- [Author](#author)

---

## Overview

A full-stack web application for managing insurance contracts. Clients can subscribe to three types of contracts:

- 🚗 **Auto** — vehicle insurance with registration number, brand, and model
- 🏠 **Habitation** — property insurance (apartment, house, commercial premises)
- 🏥 **Santé** — health insurance with coverage level and number of covered persons

Each contract can have multiple payments. The application exposes a secured REST API consumed by an Angular frontend.

---

## Tech Stack

### Backend
| Technology | Purpose |
|---|---|
| Java 17 + Spring Boot 3 | Application framework |
| Spring Data JPA + Hibernate | ORM / persistence |
| Spring Security + JWT (jjwt 0.11.5) | Stateless authentication |
| Spring Web (REST Controllers) | REST API |
| Spring Validation | DTO validation |
| Springdoc OpenAPI 2.3.0 | Swagger UI |
| MySQL 8 | Production database |
| H2 | In-memory DB for dev/tests |
| Lombok | Boilerplate reduction |

### Frontend
| Technology | Purpose |
|---|---|
| Angular 17 | SPA framework |
| Angular HttpClient | REST consumption |
| JWT Interceptor | Auto-inject Bearer token |
| Route Guards | Role-based navigation |
| Bootstrap 5 | Responsive UI |

---

## Project Structure

```
backend/
├── src/main/java/com/yourname/assurance/
│   ├── entities/
│   │   ├── Client.java
│   │   ├── Contrat.java              ← abstract @Inheritance(JOINED)
│   │   ├── ContratAuto.java
│   │   ├── ContratHabitation.java
│   │   ├── ContratSante.java
│   │   └── Paiement.java
│   ├── enums/
│   │   ├── StatutContrat.java        ← EN_COURS, VALIDE, RESILIE
│   │   ├── TypePaiement.java         ← MENSUALITE, ANNUEL, EXCEPTIONNEL
│   │   ├── TypeLogement.java         ← APPARTEMENT, MAISON, LOCAL_COMMERCIAL
│   │   └── NiveauCouverture.java     ← BASIQUE, INTERMEDIAIRE, PREMIUM
│   ├── repositories/
│   │   ├── ClientRepository.java
│   │   ├── ContratRepository.java
│   │   ├── ContratAutoRepository.java
│   │   ├── ContratHabitationRepository.java
│   │   ├── ContratSanteRepository.java
│   │   └── PaiementRepository.java
│   ├── dtos/
│   │   ├── ClientDTO.java
│   │   ├── ContratDTO.java
│   │   ├── ContratAutoDTO.java
│   │   ├── ContratHabitationDTO.java
│   │   ├── ContratSanteDTO.java
│   │   └── PaiementDTO.java
│   ├── mappers/
│   │   └── ContratMapper.java
│   ├── services/
│   │   ├── IContratService.java
│   │   ├── IClientService.java
│   │   ├── IPaiementService.java
│   │   └── impl/
│   │       ├── ContratServiceImpl.java
│   │       ├── ClientServiceImpl.java
│   │       └── PaiementServiceImpl.java
│   ├── web/
│   │   ├── ContratController.java
│   │   ├── ClientController.java
│   │   ├── PaiementController.java
│   │   └── AuthController.java
│   ├── security/
│   │   ├── SecurityConfig.java
│   │   ├── JwtService.java
│   │   ├── JwtAuthFilter.java
│   │   └── UserDetailsServiceImpl.java
│   └── DataInitializer.java          ← seeds test data on startup
└── src/main/resources/
    └── application.properties

frontend/
└── src/app/
    ├── core/
    │   ├── services/         ← auth, contrat, client, paiement
    │   ├── interceptors/     ← jwt.interceptor.ts
    │   └── guards/           ← auth.guard.ts
    ├── modules/
    │   ├── auth/login/
    │   ├── clients/
    │   ├── contrats/
    │   └── paiements/
    └── shared/models/        ← TypeScript interfaces
```

---

## Getting Started

### Prerequisites

- Java 17+
- Maven 3.8+
- MySQL 8 (or use H2 for quick start)
- Node.js 18+ and Angular CLI 17+

### 1. Clone the repository

```bash
git clone https://github.com/VotreNom-VotrePrenom-Exam-JEE.git
cd VotreNom-VotrePrenom-Exam-JEE
```

### 2. Run the backend

```bash
cd backend
mvn spring-boot:run
```

The server starts on **http://localhost:8080**

> On first launch, `DataInitializer` automatically seeds sample clients, contracts, and payments.

### 3. Run the frontend

```bash
cd frontend
npm install
ng serve
```

The app starts on **http://localhost:4200**

---

## Database Configuration

### MySQL (production)

```properties
# application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/assurance_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Create the database first:
```sql
CREATE DATABASE assurance_db;
```

### H2 (development / quick test)

```properties
spring.datasource.url=jdbc:h2:mem:assurance_db
spring.datasource.driver-class-name=org.h2.Driver
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
```

H2 console available at: **http://localhost:8080/h2-console**

---

## API Documentation

Swagger UI is available once the backend is running:

**http://localhost:8080/swagger-ui.html**

### Main endpoints

| Method | Endpoint | Role required | Description |
|---|---|---|---|
| POST | `/api/auth/login` | Public | Get JWT token |
| GET | `/api/clients` | EMPLOYE, ADMIN | List all clients |
| POST | `/api/clients` | ADMIN | Create a client |
| GET | `/api/clients/{id}` | EMPLOYE, ADMIN | Get client by ID |
| GET | `/api/clients/{id}/contrats` | EMPLOYE, ADMIN | Get contracts for a client |
| POST | `/api/contrats/auto` | EMPLOYE, ADMIN | Create auto contract |
| POST | `/api/contrats/habitation` | EMPLOYE, ADMIN | Create habitation contract |
| POST | `/api/contrats/sante` | EMPLOYE, ADMIN | Create santé contract |
| GET | `/api/contrats/{id}` | CLIENT, EMPLOYE, ADMIN | Get contract details |
| PATCH | `/api/contrats/{id}/statut` | ADMIN | Update contract status |
| DELETE | `/api/contrats/{id}` | ADMIN | Delete a contract |
| POST | `/api/contrats/{id}/paiements` | EMPLOYE, ADMIN | Add a payment |
| GET | `/api/contrats/{id}/paiements` | CLIENT, EMPLOYE, ADMIN | List payments |

### Authentication example

```bash
# 1. Login
curl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{"username":"admin","password":"1234"}'

# Response
{ "token": "eyJhbGciOiJIUzI1NiJ9..." }

# 2. Use the token
curl http://localhost:8080/api/clients \
  -H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9..."
```

---

## Security

Authentication is **stateless** using JSON Web Tokens (JWT).

### Roles & permissions

| Action | ROLE_CLIENT | ROLE_EMPLOYE | ROLE_ADMIN |
|---|:---:|:---:|:---:|
| View own contracts | ✅ | ✅ | ✅ |
| View all contracts | ❌ | ✅ | ✅ |
| Create contract | ❌ | ✅ | ✅ |
| Validate / Résilie contract | ❌ | ❌ | ✅ |
| Add payment | ❌ | ✅ | ✅ |
| Manage clients | ❌ | ✅ | ✅ |
| Manage users | ❌ | ❌ | ✅ |

### Default test users (seeded on startup)

| Username | Password | Role |
|---|---|---|
| `admin` | `1234` | ROLE_ADMIN |
| `employe1` | `1234` | ROLE_EMPLOYE |
| `client1` | `1234` | ROLE_CLIENT |

> ⚠️ Change these credentials before any deployment.

---

## Class Diagram

```
Client
  ├── id: Long
  ├── nom: String
  ├── email: String
  └── contrats: List<Contrat>

Contrat  (abstract — @Inheritance JOINED)
  ├── id: Long
  ├── dateSouscription: LocalDate
  ├── statut: StatutContrat
  ├── dateValidation: LocalDate
  ├── montantCotisation: double
  ├── dureeContrat: int
  ├── tauxCouverture: double
  ├── client: Client
  └── paiements: List<Paiement>
       ├── ContratAuto      → numeroImmatriculation, marque, modele
       ├── ContratHabitation → typeLogement, adresseLogement, superficie
       └── ContratSante     → niveauCouverture, nombrePersonnesCouvertes

Paiement
  ├── id: Long
  ├── date: LocalDate
  ├── montant: double
  ├── typePaiement: TypePaiement
  └── contrat: Contrat
```

