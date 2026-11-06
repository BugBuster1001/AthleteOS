package com.athleteos.repository;

import com.athleteos.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    // Spring Boot übersetzt den Methodennamen automatisch in eine SQL-Abfrage:
    // SELECT * FROM users WHERE email = ?
    Optional<User> findByEmail(String email);

    // Nützlich für die Registrierung, um zu prüfen, ob die E-Mail schon existiert
    boolean existsByEmail(String email);
}
