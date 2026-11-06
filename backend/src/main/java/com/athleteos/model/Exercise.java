package com.athleteos.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "exercise")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "exercise_id", updatable = false, nullable = false)
    private UUID exerciseId;

    // Normale Attribute aus dem Diagramm
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "muskelgruppe")
    private String muskelgruppe;

    // Explizit als TEXT definiert für längere Beschreibungen
    @Column(name = "beschreibung", columnDefinition = "TEXT")
    private String beschreibung;

    // Standard-Konstruktor
    public Exercise() {}

    // Komfort-Konstruktor
    public Exercise(String name, String muskelgruppe, String beschreibung) {
        this.name = name;
        this.muskelgruppe = muskelgruppe;
        this.beschreibung = beschreibung;
    }

    // Getter & Setter
    public UUID getExerciseId() { return exerciseId; }
    public void setExerciseId(UUID exerciseId) { this.exerciseId = exerciseId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getMuskelgruppe() { return muskelgruppe; }
    public void setMuskelgruppe(String muskelgruppe) { this.muskelgruppe = muskelgruppe; }

    public String getBeschreibung() { return beschreibung; }
    public void setBeschreibung(String beschreibung) { this.beschreibung = beschreibung; }


}
