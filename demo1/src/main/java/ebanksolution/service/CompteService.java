package ebanksolution.service;

import ebanksolution.model.Compte;

import java.util.List;

public interface CompteService {
    List<Compte> getComptes();
    Compte getCompte(int id);
    Compte addCompte(Compte compte, int idUser);
    Compte updateCompte(Compte compte);
    void deleteCompte(int id);
    Float consulterSolde(int id);
    Compte fermerCompte(int id);
}


