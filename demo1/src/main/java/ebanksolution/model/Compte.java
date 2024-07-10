package ebanksolution.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCompte;
    private String typeCompte;
    private Float SoldeInitial;
    private String DateCreation;
    private boolean fermeture ;

    @ManyToOne
    @JoinColumn(name="idUser", nullable=false)
    private Utilisateur utilisateur;

    @JsonIgnore
    @OneToMany(mappedBy = "compte")
    private Set<Carte> cartes;
}