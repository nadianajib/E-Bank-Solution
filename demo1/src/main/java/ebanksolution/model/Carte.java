package ebanksolution.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Carte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCarte;
    private String numeroCarte;
    private String dateExpiration;
    private String typeCarte;
    private boolean active;

    @ManyToOne
    @JoinColumn(name="idCompte", nullable=false)
    private Compte compte;
}
