package com.athleteos.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "task")
public class Task {

    // 1. Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "task_id", updatable = false, nullable = false)
    private UUID taskId;

    // 2. Erster Foreign Key: Wer hat die Aufgabe erstellt?
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ersteller_id", nullable = false)
    private User ersteller;

    // 3. Zweiter Foreign Key: Wer soll die Aufgabe erledigen?
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empfaenger_id", nullable = false)
    private User empfaenger;

    // 4. Titel der Aufgabe
    @Column(name = "titel", nullable = false)
    private String titel;

    // 5. Beschreibung (wieder als TEXT für längere Inhalte)
    @Column(name = "beschreibung", columnDefinition = "TEXT")
    private String beschreibung;

    // 6. Fälligkeitsdatum (Timestamp)
    @Column(name = "faellig_am")
    private LocalDateTime faelligAm;

    // 7. Status der Aufgabe (Boolean)
    @Column(name = "is_completed", nullable = false)
    private Boolean isCompleted = false; // Standardmäßig auf 'false' gesetzt

    public Task() {}

    public Task(User ersteller, User empfaenger, String titel, String beschreibung, LocalDateTime faelligAm) {
        this.ersteller = ersteller;
        this.empfaenger = empfaenger;
        this.titel = titel;
        this.beschreibung = beschreibung;
        this.faelligAm = faelligAm;
        this.isCompleted = false;
    }

    // Getter & Setter
    public UUID getTaskId() { return taskId; }
    public void setTaskId(UUID taskId) { this.taskId = taskId; }

    public User getErsteller() { return ersteller; }
    public void setErsteller(User ersteller) { this.ersteller = ersteller; }

    public User getEmpfaenger() { return empfaenger; }
    public void setEmpfaenger(User empfaenger) { this.empfaenger = empfaenger; }

    public String getTitel() { return titel; }
    public void setTitel(String titel) { this.titel = titel; }

    public String getBeschreibung() { return beschreibung; }
    public void setBeschreibung(String beschreibung) { this.beschreibung = beschreibung; }

    public LocalDateTime getFaelligAm() { return faelligAm; }
    public void setFaelligAm(LocalDateTime faelligAm) { this.faelligAm = faelligAm; }

    public Boolean getIsCompleted() { return isCompleted; }
    public void setIsCompleted(Boolean isCompleted) { this.isCompleted = isCompleted; }


}
