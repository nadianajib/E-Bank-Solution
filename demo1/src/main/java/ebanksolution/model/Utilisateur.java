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

public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idUser;
    private String name;
    private String email;
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "utilisateur")
    private Set<Compte> comptes;
}