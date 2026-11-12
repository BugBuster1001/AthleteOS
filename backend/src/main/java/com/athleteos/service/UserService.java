package com.athleteos.service;

import com.athleteos.model.User;
import com.athleteos.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User registerUser(String vorname, String nachname, String email, String passwordKlartext){

        if (userRepository.existsByEmail(email)){
            throw new IllegalArgumentException("Diese E-Mail-Adresse ist bereits registriert!");
        }
        User newUser = new User();
        newUser.setFirstName(vorname);
        newUser.setLastName(nachname);
        newUser.setEmail(email);
        // TODO: Das Passwort MUSS später noch verschlüsselt (gehasht) werden!
        // Für den allerersten Test speichern wir es kurz im Klartext.
        newUser.setPassword(passwordKlartext);

        return userRepository.save(newUser);
    }

}
