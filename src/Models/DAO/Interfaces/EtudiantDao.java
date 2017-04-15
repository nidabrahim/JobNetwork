package Models.DAO.Interfaces;

import java.sql.Date;
import java.util.List;

import Models.Beans.Commentaire;
import Models.Beans.Etudiant;
import Models.Beans.ExperiencePro;
import Models.Beans.Formation;
import Models.Beans.Langue;
import Models.Beans.LigneLangue;
import Models.Beans.LigneLogiciel;
import Models.Beans.Logiciel;
import Models.Beans.Message;
import Models.Beans.OffreDeStage;
import Models.Exceptions.DAOException;
import Models.Beans.LignePostul;


public interface EtudiantDao {
	
	public Etudiant getEtudiantById(int id) throws DAOException;
	
	public Etudiant rechercherEtudiant(String email, String password) throws DAOException;
	
	public void ModifierEtudiant(Etudiant candidat) throws DAOException;
	
	public void ajouterExperiencePro(ExperiencePro experiencePro,int candidat) throws DAOException;
	
	 public void ajouterLogiciel(int Logiciel,int id_candidat  , int num_niv_logiciel) throws DAOException;
	 
	 public void ajouterLangue(Etudiant candidat ,int num_langue , int num_niv_langue) throws DAOException;
	 
	 public void ajouterFormation(Formation formation,int id_candidat) throws DAOException;
	 
	 public List<Formation> afficherListFormationsEtudiant(Etudiant etudiant) throws DAOException;
	 
	 public List<Formation> afficherFormationOffres(OffreDeStage offreDeStage) throws DAOException;
	 
	 public List<Formation> afficherFormationObligatoireOffres(OffreDeStage offreDeStage) throws DAOException;
	 
	 public List<LigneLangue> afficherListLanguesEtudiant(Etudiant etudiant) throws DAOException;
	 
	 public List<Langue> afficherLanguesOffres(OffreDeStage offreDeStage) throws DAOException;
	 
	 public List<Langue> afficherLanguesObligatoireOffres(OffreDeStage offreDeStage) throws DAOException;
	 
	 public List<LigneLogiciel> afficherListLogicielsEtudiant(Etudiant etudiant) throws DAOException;
	 
	 public List<Logiciel> afficherLogicielsOffres(OffreDeStage offreDeStage) throws DAOException;
	 
	 public List<Logiciel> afficherLogicielsObligatoireOffres(OffreDeStage offreDeStage) throws DAOException;
	 
	 public List<ExperiencePro> afficherListExperienceProEtudiant(Etudiant etudiant) throws DAOException;
	 
	 public List<OffreDeStage> afficherOffres(Etudiant etudiant) throws DAOException;
	 
	 public int testOffre(List<Formation> ListeFormations, List<Langue> ListeLangues, List<Logiciel> ListeLogiciels, OffreDeStage offreDeStage) throws DAOException;
	 
	 public void ajouterPostulation(Etudiant etudiant, int idOffre, String lettre , Date dateDispo) throws DAOException;
	 
	 public int isDejaPostuler(Etudiant etudiant,int idOffre) throws DAOException;
	 
	 public List<LignePostul> getPostulaByCandidat(Etudiant etudiant) throws DAOException;
	 
	 public List<Etudiant> getEtudiants() throws DAOException;
	 
	 public void PosterCommentaire(Commentaire comment ) throws DAOException;
	 
	 public List<Commentaire> getCommentairesByOffre(int idOffre) throws DAOException;
	 
	 public void EnvoyerMsg(Message msg) throws DAOException;
    
	 public List<Message> getMessages(int emetteur, int recepteur) throws DAOException;
	 
	 public List<Message> getLastMessages(int recepteur) throws DAOException;
	  
	 public int count_postulation(int candidat)throws DAOException;
	 
	 public int count_postulation_accept(int candidat)throws DAOException;
	 
	 public int count_postulation_refus(int candidat)throws DAOException;
}
