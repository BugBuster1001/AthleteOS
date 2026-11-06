package com.athleteos.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "nachricht_id", updatable = false, nullable = false)
    private UUID nachrichtId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id", nullable = false)
    private User sender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empfaenger_id", nullable = false)
    private User empfaenger;

    @Column(name = "inhalt", columnDefinition = "Text", nullable = false)
    private String inhalt;

    @Column(name = "datum", nullable = false)
    private LocalDateTime datum;

    @Column(name = "status")
    private String status;

    public Message() {}

    public Message(User sender, User empfaenger, String inhalt, LocalDateTime datum, String status){
        this.sender = sender;
        this.empfaenger = empfaenger;
        this.inhalt = inhalt;
        this.datum = datum;
        this.status = status;
    }

    public UUID getNachrichtId() {return nachrichtId;}
    public void setNachrichtId(UUID nachrichtId) {this.nachrichtId = nachrichtId;}

    public User getSender() { return sender; }
    public void setSender(User sender) { this.sender = sender; }

    public User getEmpfaenger() { return empfaenger; }
    public void setEmpfaenger(User empfaenger) { this.empfaenger = empfaenger; }

    public String getInhalt() { return inhalt; }
    public void setInhalt(String inhalt) { this.inhalt = inhalt; }

    public LocalDateTime getDatum() { return datum; }
    public void setDatum(LocalDateTime datum) { this.datum = datum; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }


}
