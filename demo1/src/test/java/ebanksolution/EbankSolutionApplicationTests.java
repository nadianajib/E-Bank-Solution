package ebanksolution;

import ebanksolution.dao.CompteDao;
import ebanksolution.model.Compte;
import ebanksolution.model.Utilisateur;
import ebanksolution.service.CompteService;
import ebanksolution.service.CompteServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
@SpringBootTest
class EbankSolutionApplicationTests {

    @Autowired
    private CompteServiceImpl compteService;

    @Mock
    private CompteDao compteDao;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    //Tester AddCompte Function :
    @Test
    public void testCreerCompte() {
        String typeCompte = "mock";
        float SoldeInitial = 199;
        String DateCreation = "2021-01-01";
        int idUser = 1;

        // Mock the User object
        Utilisateur mockUser = new Utilisateur();
        mockUser.setIdUser(idUser);

        // Mock the compte object to return the mockUser
        Compte mockCompte = new Compte();
        mockCompte.setTypeCompte(typeCompte);
        mockCompte.setSoldeInitial(SoldeInitial);
        mockCompte.setDateCreation(DateCreation);
        mockCompte.setUtilisateur(mockUser);

        when(compteDao.save(any(Compte.class))).thenReturn(mockCompte);

        Compte creerCompte = compteService.addCompte(mockCompte, idUser);

        assertEquals(typeCompte, creerCompte.getTypeCompte());
        assertEquals(SoldeInitial, creerCompte.getSoldeInitial());
        assertEquals(DateCreation, creerCompte.getDateCreation());
        assertEquals(idUser, creerCompte.getUtilisateur().getIdUser());
    }
}

