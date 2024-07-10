package ebanksolution.controller;

import ebanksolution.model.Carte;
import ebanksolution.service.CarteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cartes")
public class CarteController {
    @Autowired
    private CarteService carteService;

    @GetMapping
    public List<Carte> getAllCartes() {
        return carteService.getAllCartes();
    }

    @GetMapping("/{id}")
    public Optional<Carte> getCarteById(@PathVariable int id) {
        return carteService.getCarteById(id);
    }

    @PostMapping("/create/{idCompte}")
    public Carte createCarte(@RequestBody Carte carte, @PathVariable int idCompte) {
        return carteService.createCarte(carte, idCompte);
    }

    @PutMapping("/{id}")
    public Carte updateCarte(@PathVariable int id, @RequestBody Carte carteDetails) {
        return carteService.updateCarte(id, carteDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteCarte(@PathVariable int id) {
        carteService.deleteCarte(id);
    }

    @PostMapping("/{id}/activer")
    public String activerCarte(@PathVariable int id) {
        carteService.activerCarte(id);
        return "Activer";
    }

    @PostMapping("/{id}/desactiver")
    public String desactiverCarte(@PathVariable int id) {
        carteService.desactiverCarte(id);
        return "Desactiver" ;
    }
}
