package com.example.demo.controller;

import com.example.demo.model.Compte;
import com.example.demo.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("")
public class CompteController {
    @Autowired
    private CompteService compteService;
    @GetMapping
    public List<Compte> getComptes(){
        return CompteService
    }

}
