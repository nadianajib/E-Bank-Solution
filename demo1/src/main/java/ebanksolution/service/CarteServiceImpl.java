package ebanksolution.service;

import ebanksolution.dao.CarteDao;
import ebanksolution.dao.CompteDao;
import ebanksolution.model.Carte;
import ebanksolution.model.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarteServiceImpl implements CarteService {
    @Autowired
    private CarteDao carteDao;

    @Autowired
    private CompteDao compteDao;

    @Override
    public List<Carte> getAllCartes() {
        return carteDao.findAll();
    }

    @Override
    public Optional<Carte> getCarteById(int id) {
        return carteDao.findById(id);
    }

    @Override
    public Carte createCarte(Carte carte, int idCompte) {
        Compte compte = compteDao.findById(idCompte)
                .orElseThrow(() -> new RuntimeException("Compte introuvable avec l'ID " + idCompte));
        carte.setCompte(compte);
        return carteDao.save(carte);
    }

    @Override
    public Carte updateCarte(int id, Carte carteDetails) {
        Carte carte = carteDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Carte introuvable avec l'ID " + id));
        carte.setNumeroCarte(carteDetails.getNumeroCarte());
        carte.setDateExpiration(carteDetails.getDateExpiration());
        carte.setTypeCarte(carteDetails.getTypeCarte());
        return carteDao.save(carte);
    }

    @Override
    public void deleteCarte(int id) {
        Carte carte = carteDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Carte introuvable avec l'ID " + id));
        carteDao.delete(carte);
    }

    @Override
    public Carte activerCarte(int id) {
        Carte carte = carteDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Carte introuvable avec l'ID " + id));
        carte.setActive(true);
        return carteDao.save(carte);
    }

    @Override
    public Carte desactiverCarte(int id) {
        Carte carte = carteDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Carte introuvable avec l'ID " + id));
        carte.setActive(false);
        return carteDao.save(carte);
    }
}
