package com.example.demo.service;

import com.example.demo.dao.CompteDao;
import com.example.demo.model.Compte;

import java.util.List;

public class CompteServiceImpl implements CompteService {

    @Override
    public List<Compte> getAllComptes() {
        return CompteDao.findAll();




        
    }
}
