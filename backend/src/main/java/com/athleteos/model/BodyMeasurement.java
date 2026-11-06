package com.athleteos.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "body_measurement")
public class BodyMeasurement {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "gewicht_kg", nullable = false)
    private Float gewichtKg;

    // Neue Spalte für die Körpergröße
    @Column(name = "groesse_cm")
    private Integer groesseCm;

    // Optional vorbereitet für weitere Körperkompositions-Daten
    @Column(name = "koerperfett_prozent")
    private Float koerperfettProzent;

    @Column(name = "datum", nullable = false)
    private LocalDateTime datum;

    public BodyMeasurement() {}

    // Konstruktor 1: Nur Gewicht und Größe
    public BodyMeasurement(User user, Float gewichtKg, Integer groesseCm, LocalDateTime datum) {
        this.user = user;
        this.gewichtKg = gewichtKg;
        this.groesseCm = groesseCm;
        this.datum = datum;
    }

    // Konstruktor 2: Mit Körperfettanteil
    public BodyMeasurement(User user, Float gewichtKg, Integer groesseCm, Float koerperfettProzent, LocalDateTime datum) {
        this.user = user;
        this.gewichtKg = gewichtKg;
        this.groesseCm = groesseCm;
        this.koerperfettProzent = koerperfettProzent;
        this.datum = datum;
    }

    // Getter & Setter
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Float getGewichtKg() { return gewichtKg; }
    public void setGewichtKg(Float gewichtKg) { this.gewichtKg = gewichtKg; }

    public Integer getGroesseCm() { return groesseCm; }
    public void setGroesseCm(Integer groesseCm) { this.groesseCm = groesseCm; }

    public Float getKoerperfettProzent() { return koerperfettProzent; }
    public void setKoerperfettProzent(Float koerperfettProzent) { this.koerperfettProzent = koerperfettProzent; }

    public LocalDateTime getDatum() { return datum; }
    public void setDatum(LocalDateTime datum) { this.datum = datum; }
}
