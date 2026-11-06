package com.athleteos.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "workout_sets")
public class WorkoutSet {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "set_id",updatable = false, nullable = false )
    private UUID setId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workout_id", nullable = false)
    private Workout workout;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exercise_id", nullable = false)
    private Exercise exercise;

    @Column(name = "satznummer", nullable = false)
    private Integer satznummer;

    @Column(name = "gewicht_kg")
    private Float gewichtKg;

    @Column(name = "wiederholungen", nullable = false)
    private Integer wiederholungen;

    // Standard-Konstruktor
    public WorkoutSet() {}

    // Komfort-Konstruktor
    public WorkoutSet(Workout workout, Exercise exercise, Integer satznummer, Float gewichtKg, Integer wiederholungen) {
        this.workout = workout;
        this.exercise = exercise;
        this.satznummer = satznummer;
        this.gewichtKg = gewichtKg;
        this.wiederholungen = wiederholungen;
    }

    // Getter & Setter
    public UUID getSetId() { return setId; }
    public void setSetId(UUID setId) { this.setId = setId; }

    public Workout getWorkout() { return workout; }
    public void setWorkout(Workout workout) { this.workout = workout; }

    public Exercise getExercise() { return exercise; }
    public void setExercise(Exercise exercise) { this.exercise = exercise; }

    public Integer getSatznummer() { return satznummer; }
    public void setSatznummer(Integer satznummer) { this.satznummer = satznummer; }

    public Float getGewichtKg() { return gewichtKg; }
    public void setGewichtKg(Float gewichtKg) { this.gewichtKg = gewichtKg; }

    public Integer getWiederholungen() { return wiederholungen; }
    public void setWiederholungen(Integer wiederholungen) { this.wiederholungen = wiederholungen; }


}
