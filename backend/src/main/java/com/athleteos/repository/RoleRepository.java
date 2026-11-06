package com.athleteos.repository;

import com.athleteos.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    // Findet eine Rolle anhand ihres Namens (z.B. "ADMIN" oder "TRAINER")
    Optional<Role> findByName(String name);
}
