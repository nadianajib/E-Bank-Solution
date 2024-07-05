package com.example.demo.dao;

import com.example.demo.model.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteDao extends JpaRepository<Compte, Long> {
}
