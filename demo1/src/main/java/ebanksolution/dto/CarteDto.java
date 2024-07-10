package ebanksolution.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CarteDto {

    private Long idCarte;
    private String numeroCarte;
    private String dateExpiration;
    private String typeCarte;
}
