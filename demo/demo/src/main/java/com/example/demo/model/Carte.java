package com.example.demo.model;

import com.example.demo.model.Compte;
import jakarta.persistence.*;

@Entity
public class Carte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_carte;
    private String numero_carte;
    private String date_expiration;
    private String type_carte;

    @ManyToOne
    @JoinColumn(name = "compte_id")
    private Compte compte;

    // Getters and setters
    // ...
}
