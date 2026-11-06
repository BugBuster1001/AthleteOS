package com.athleteos.repository;

import com.athleteos.model.Message;
import com.athleteos.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface MessageRepository extends JpaRepository<Message, UUID> {

    // Posteingang: Alle Nachrichten, die dieser User empfangen hat
    List<Message> findByEmpfaenger(User empfaenger);

    // Postausgang: Alle Nachrichten, die dieser User gesendet hat
    List<Message> findBySender(User sender);
}
