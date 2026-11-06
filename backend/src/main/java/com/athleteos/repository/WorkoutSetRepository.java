package com.athleteos.repository;

import com.athleteos.model.Workout;
import com.athleteos.model.WorkoutSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface WorkoutSetRepository extends JpaRepository<WorkoutSet, UUID> {

    // Holt alle Trainingssätze, die zu einem bestimmten Workout gehören
    List<WorkoutSet> findByWorkout(Workout workout);
}
