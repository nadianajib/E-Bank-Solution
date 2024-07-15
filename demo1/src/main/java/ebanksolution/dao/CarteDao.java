package ebanksolution.dao;

import ebanksolution.model.Carte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarteDao extends JpaRepository<Carte, Integer> {
}
