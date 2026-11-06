package com.athleteos.repository;

import com.athleteos.model.TrainerMitglied;
import com.athleteos.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TrainerMitgliedRepository extends JpaRepository<TrainerMitglied, UUID> {

    // Gibt alle Mitglieder zurück, die ein bestimmter Trainer betreut
    List<TrainerMitglied> findByTrainer(User trainer);

    // Prüft, von welchem Trainer ein bestimmtes Mitglied betreut wird
    List<TrainerMitglied> findByMitglied(User mitglied);
}
