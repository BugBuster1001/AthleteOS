package com.athleteos.config;

import com.athleteos.model.Role;
import com.athleteos.repository.RoleRepository;
import com.athleteos.repository.UserRepository;
import com.athleteos.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserService userService;
    private final UserRepository userRepository;

    public DataSeeder(RoleRepository roleRepository, UserService userService, UserRepository userRepository){
        this.roleRepository = roleRepository;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("--- Starte Data Seeder ---");

        createRoleIfNotFound("USER");
        createRoleIfNotFound("ADMIN");
        createRoleIfNotFound("TRAINER");

        String testEmail = "test@athleteos.com";
        if (!userRepository.existsByEmail(testEmail)){
            userService.registerUser("Miran", "Boyraz", testEmail, "geheim123");
            System.out.println("✅ Test-User wurde erfolgreich registriert!");
        } else {
            System.out.println(" Test-User existiert bereits. ");
        }

        System.out.println("--- Data Seeder beendet ---");
    }

    private void createRoleIfNotFound(String roleName) {
        if (roleRepository.findByName(roleName).isEmpty()) {
            Role role = new Role(roleName);
            roleRepository.save(role);
            System.out.println("✅ Rolle in DB gespeichert: " + roleName);
        }
    }
}
