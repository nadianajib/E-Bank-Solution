package ebanksolution.dao;

import ebanksolution.model.Utilisateur;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Utilisateur, Integer> {
    Optional<Utilisateur> findByEmail(String email);
    Utilisateur findByIdUser(int idUser);
}
