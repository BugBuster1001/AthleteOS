package com.athleteos.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "trainer_mitglied")
public class TrainerMitglied {

    // Von JPA benötigter Primary Key (haben wir als Standard-UUID ergänzt)
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    // Erster Foreign Key: Welcher User ist der Trainer?
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trainer_id", nullable = false)
    private User trainer;

    // Zweiter Foreign Key: Welcher User ist das Mitglied/der Klient?
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mitglied_id", nullable = false)
    private User mitglied;

    // Status der Betreuung (z. B. "AKTIV", "ANGEFRAGT")
    @Column(name = "status")
    private String status;

    public TrainerMitglied() {}

    public TrainerMitglied(User trainer, User mitglied, String status) {
        this.trainer = trainer;
        this.mitglied = mitglied;
        this.status = status;
    }

    // Getter & Setter
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public User getTrainer() { return trainer; }
    public void setTrainer(User trainer) { this.trainer = trainer; }

    public User getMitglied() { return mitglied; }
    public void setMitglied(User mitglied) { this.mitglied = mitglied; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }


}
