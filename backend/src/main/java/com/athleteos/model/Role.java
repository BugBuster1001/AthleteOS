package com.athleteos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "role")
public class Role {

    // 1. Primary Key (INT laut Diagramm)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", updatable = false, nullable = false)
    private Integer roleId;

    // 2. Rollenname (z. B. "ADMIN", "TRAINER", "USER") - muss eindeutig sein
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    // Komfort-Konstruktor
    public Role(String name) {
        this.name = name;
    }

    // Getter & Setter
    public Integer getRoleId() { return roleId; }
    public void setRoleId(Integer roleId) { this.roleId = roleId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
