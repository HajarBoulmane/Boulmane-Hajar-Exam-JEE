package net.hajar.boulmanehajarexamjee.repositories;

import net.hajar.boulmanehajarexamjee.security.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole, String> {
}