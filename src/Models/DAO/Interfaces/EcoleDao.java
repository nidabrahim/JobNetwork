package Models.DAO.Interfaces;

import Models.Beans.Etablissement;
import Models.Beans.Etudiant;
import Models.Exceptions.DAOException;
import java.util.List;

/**
 *
 * @author Dominique
 */
public interface EcoleDao {

    public void ajouterEcole(Etablissement ecole) throws DAOException;

    public void SupprimerEtudiant(Etudiant candidat) throws DAOException;

    public List<Etudiant> afficherTousLesEtudiants(Etablissement ecole) throws DAOException;

    public void ajouterEtudiant(Etudiant candidat) throws DAOException;
    
    public Etablissement rechercherEcole(String email , String password) throws DAOException;
    
    
    
}
