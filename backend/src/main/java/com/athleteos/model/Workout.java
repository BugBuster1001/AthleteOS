package com.athleteos.model;

import  jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "workouts")
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "workout_id", updatable = false, nullable = false)
    private UUID workoutId;

    // Deklaration des Foreign Keys
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "datum", nullable = false)
    private LocalDateTime datum;

    @Column(name = "dauer_min")
    private Integer dauer_Min;

    @Column(name = "status")
    private String status;

    public Workout() {}

    public Workout(User user, LocalDateTime datum, Integer dauer_Min, String status){
        this.user = user;
        this.datum = datum;
        this.dauer_Min = dauer_Min;
        this.status = status;
    }

    public UUID getWorkoudId() { return workoutId; }
    public void setWorkoutId(UUID workoutId) { this.workoutId = workoutId; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public LocalDateTime getDatum() {return datum; }
    public void setDatum(LocalDateTime datum) {this.datum = datum;}

    public Integer getDauer_Min() {return dauer_Min; }
    public void setDauer_Min(Integer dauer_Min) {this.dauer_Min = dauer_Min;}

    public String getStatus() { return status; }
    public void setStatus(String status) {this.status = status; }
}
