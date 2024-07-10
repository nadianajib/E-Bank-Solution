package ebanksolution.controller;

import ebanksolution.model.Compte;
import ebanksolution.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comptes")
public class CompteController {
    @Autowired
    private CompteService compteService;

    @GetMapping
    public List<Compte> getAllComptes() {
        return compteService.getComptes();
    }

    @GetMapping("/{id}")
    public Compte getCompteById(@PathVariable int id) {
        return compteService.getCompte(id);
    }

    @PostMapping("/create/{idUser}")
    public Compte createCompte(@RequestBody Compte compte, @PathVariable int idUser) {
        return compteService.addCompte(compte, idUser);
    }

    @PutMapping("/{id}")
    public Compte updateCompte(@PathVariable int id, @RequestBody Compte compte) {
        compte.setIdCompte(id);
        return compteService.updateCompte(compte);
    }

    @DeleteMapping("/{id}")
    public void deleteCompte(@PathVariable int id) {
        compteService.deleteCompte(id);
    }
    // Fonction pour consulter le solde d'un compte
    @GetMapping("/{id}/solde")
    public Float consulterSolde(@PathVariable int id) {
        return compteService.consulterSolde(id);
    }
}
