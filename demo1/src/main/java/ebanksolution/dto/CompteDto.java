package ebanksolution.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class CompteDto {

    private int idCompte;
    private String typeCompte;
    private Float SoldeInitial;
    private String DateCreation;
}
