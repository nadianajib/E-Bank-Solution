package ebanksolution.service;

import ebanksolution.model.Carte;
import java.util.List;
import java.util.Optional;

public interface CarteService {
    List<Carte> getAllCartes();
    Optional<Carte> getCarteById(int id);
    Carte createCarte(Carte idcarte, int idCompte);
    Carte updateCarte(int id, Carte carteDetails);
    void deleteCarte(int id);
    Carte activerCarte(int id);  // Nouvelle méthode
    Carte desactiverCarte(int id);

}
