package com.athleteos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface Exercise extends JpaRepository<Exercise,UUID>{

List<Exercise> findByMuskelgruppe(String muskelgruppe);

Optional<Exercise> findByName(String name);
}
