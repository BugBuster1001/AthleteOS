package com.athleteos.repository;

import com.athleteos.model.Task;
import com.athleteos.model.User;
import com.athleteos.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {

    List<Task> findByEmpfaenger(User empfaenger);

    // Profi-Trick: Mehrere Bedingungen verknüpfen (z.B. nur unerledigte Aufgaben)
    List<Task> findByEmpfaengerAndIsCompleted(User empfaenger, Boolean isCompleted);

}
