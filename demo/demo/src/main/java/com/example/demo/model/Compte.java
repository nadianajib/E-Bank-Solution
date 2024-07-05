package com.example.demo.model;

import com.example.demo.model.User;
import jakarta.persistence.*;
import jakarta.transaction.Transaction;

import java.util.List;

@Entity
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_compte;
    private String type_compte;
    private float solde_initial;
    private String date_creation;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "compte")
    private List<Transaction> transactions;

    @OneToMany(mappedBy = "compte")
    private List<Carte> cartes;

    // Getters and setters
    // ...
}
