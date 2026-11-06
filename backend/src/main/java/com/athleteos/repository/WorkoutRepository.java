package com.athleteos.repository;

import com.athleteos.model.User;
import com.athleteos.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface WorkoutRepository  extends JpaRepository<Workout, UUID> {
    // Findet alle Workouts eines bestimmten Users
    List<Workout> findByUser(User user);

    // Findet Workouts anhand des Status (z.B. "PLANNED" oder "COMPLETED")
    List<Workout> findByStatus(String status);
}
