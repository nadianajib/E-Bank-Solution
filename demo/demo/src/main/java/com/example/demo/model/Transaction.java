package com.example.demo.model;


import jakarta.persistence.*;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_transaction;
    private String date_heure;
    private float montant;
    private String type_transaction;
    private String description;

    @ManyToOne
    @JoinColumn(name = "compte_id")
    private Compte compte;

    // Getters and setters
    // ...
}
