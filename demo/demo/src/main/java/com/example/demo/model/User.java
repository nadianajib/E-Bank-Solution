package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_user;
    private String name;
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Compte> comptes;

    // Getters and setters

}
