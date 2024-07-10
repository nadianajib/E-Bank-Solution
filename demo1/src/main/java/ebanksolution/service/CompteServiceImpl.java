package ebanksolution.service;

import ebanksolution.dao.CompteDao;
import ebanksolution.dao.UserDao;
import ebanksolution.model.Compte;
import ebanksolution.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompteServiceImpl implements CompteService {
    @Autowired
    private CompteDao compteDao;

    @Autowired
    private UserDao userDao;

    @Override
    public List<Compte> getComptes() {
        return compteDao.findAll();
    }

    @Override
    public Compte getCompte(int id) {
        Optional<Compte> optionalCompte = compteDao.findById(id);
        return optionalCompte.orElse(null);
    }

    @Override
    public Compte addCompte(Compte compte, int idUser) {
        Utilisateur utilisateur = userDao.findByIdUser(idUser);
        if (utilisateur != null) {
            compte.setUtilisateur(utilisateur);
            return compteDao.save(compte);
        } else {
            throw new RuntimeException("Utilisateur introuvable");
        }
    }

    @Override
    public Compte updateCompte(Compte compte) {
        return compteDao.save(compte);
    }

    @Override
    public void deleteCompte(int id) {
        compteDao.deleteById(id);
    }
    @Override
    public Float consulterSolde(int id) {
        Compte compte = getCompte(id);
        if (compte != null) {
            return compte.getSoldeInitial();
        } else {
            throw new RuntimeException("Compte introuvable");
        }
    }

    @Override
    public Compte fermerCompte(int id) {
        return null;
    }


}
