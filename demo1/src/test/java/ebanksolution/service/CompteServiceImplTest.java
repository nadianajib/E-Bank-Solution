package ebanksolution.service;


import ebanksolution.dao.CompteDao;
import ebanksolution.dao.UserDao;
import ebanksolution.model.Compte;
import ebanksolution.model.Utilisateur;
import ebanksolution.service.CompteServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class CompteServiceImplTest {

    @InjectMocks
    private CompteServiceImpl compteService;

    @Mock
    private CompteDao compteDao;

    @Mock
    private UserDao utilisateurDao;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreerCompte() {
        String typeCompte = "test";
        float soldeInitial = 199;
        String dateCreation = "2021-01-01";
        int idUser = 1;

        // Mock the User object
        Utilisateur mockUser = new Utilisateur();
        mockUser.setIdUser(idUser);

        // Mock the compte object to return the mockUser
        Compte mockCompte = new Compte();
        mockCompte.setTypeCompte(typeCompte);
        mockCompte.setSoldeInitial(soldeInitial);
        mockCompte.setDateCreation(dateCreation);
        mockCompte.setUtilisateur(mockUser);

        when(utilisateurDao.findByIdUser(idUser)).thenReturn(mockUser);
        when(compteDao.save(any(Compte.class))).thenReturn(mockCompte);

        Compte creerCompte = compteService.addCompte(mockCompte, idUser);

        assertEquals(typeCompte, creerCompte.getTypeCompte());
        assertEquals(soldeInitial, creerCompte.getSoldeInitial());
        assertEquals(dateCreation, creerCompte.getDateCreation());
        assertEquals(idUser, creerCompte.getUtilisateur().getIdUser());
    }
}
