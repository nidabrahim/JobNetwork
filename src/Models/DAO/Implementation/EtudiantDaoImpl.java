package Models.DAO.Implementation;

import Models.Beans.Commentaire;
import Models.Beans.CritereLogiciel;
import Models.Beans.Criteres;
import Models.Beans.Entreprise;
import Models.Beans.Etablissement;
import Models.Beans.Etudiant;
import Models.Beans.ExperiencePro;
import Models.Beans.Formation;
import Models.Beans.Langue;
import Models.Beans.LigneLangue;
import Models.Beans.LigneLogiciel;
import Models.Beans.Logiciel;
import Models.Beans.Message;
import Models.Beans.NiveauLogiciel;
import Models.Beans.Niveaulangue;
import Models.Beans.OffreDeStage;
import Models.DAO.ClassPrincipal.DaoFactory;
import Models.DAO.Interfaces.EtudiantDao;
import Models.Exceptions.DAOException;
import static Models.Utilitaire.DAOUtilitaires.fermeturesSilencieuses;
import static Models.Utilitaire.DAOUtilitaires.initialisationRequetePreparee;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Models.Beans.LignePostul;




public class EtudiantDaoImpl implements EtudiantDao {

    private DaoFactory daoFactory;
    private static final String SQL_UPDATE_ETUDIANT= "UPDATE ETUDIANT SET RUE_ETUDIANT = ?, DATE_NAISS_ETUDIANT = ?, EMAIL_ETUDIANT = ?, TEL_GSM_ETUDIANT = ?, TEL_FIXE_ETUDIANT = ?, VILLE_ETUDIANT = ?, CODE_POSTAL_= ?, MOT_PASSE_ETUDIANT = ? WHERE NUM_ETUDIANT = ? ";
    private static final String SQL_INSERT_EXPERIENCE_PRO= "INSERT INTO EXPERIENCE_PRO VALUES(null,?,?,?,?,?) ";/*expro_seq.nextval*/
    private static final String SQL_INSERT_LIGNE_LOGICIEL= "INSERT INTO LIGNE_LOGICIEL VALUES(?,?,?) ";
    private static final String SQL_INSERT_LIGNE_LANGUE= "INSERT INTO LIGNE_LANGUE(NUM_ETUDIANT,NUM_LANGUE,NUM_NIVEAU_LANGUE) VALUES((select NUM_ETUDIANT from etudiant WHERE NUM_ETUDIANT = ? ),(select NUM_LANGUE from langue WHERE NUM_LANGUE = ?),(select NUM_NIVEAU_LANGUE from niveau_langue WHERE NUM_NIVEAU_LANGUE = ? )) ";
    private static final String SQL_INSERT_FORMATION= "INSERT INTO FORMATION VALUES(null,?,?,?) ";/*formation_seq.nextval*/
    private static final String SQL_INSERT_LIGNE_FORMATION= "INSERT INTO LIGNE_FORMATION(NUM_FORMATION,NUM_ETUDIANT) VALUES((select max(NUM_FORMATION) from formation),?) ";
    private static final String SQL_SELECT_TOUS_FORMATION_ETUDIANT= "SELECT NUM_FORMATION FROM LIGNE_FORMATION WHERE NUM_ETUDIANT = ? ";
    private static final String SELECT_TOUS_CRITERES= "SELECT * FROM CRITERES WHERE NUM_STAGE = ? ";
    private static final String SQL_SELECT_FORMATION= "SELECT NUM_CRIT_FORMATION FROM LIGNE_CONDITION_FORMATION WHERE NUM_CRITERE = ? ";
    private static final String SQL_SELECT_FORMATION_OBLIGA= "SELECT NUM_CRIT_FORMATION FROM LIGNE_CONDITION_FORMATION WHERE NUM_CRITERE = ? AND OBLIG_FORME = 1 ";
    private static final String SQL_SELECT_LANGUE_ETUDIANT= "SELECT NUM_LANGUE,NUM_NIVEAU_LANGUE FROM LIGNE_LANGUE WHERE NUM_ETUDIANT = ? ";
    private static final String SQL_SELECT_LANGUE_OFFRES= "SELECT NUM_CRITERE_LANGUE FROM LIGNE_CONDITION_LANGUE WHERE NUM_CRITERE = ? ";
    private static final String SQL_SELECT_LANGUE_OBLIGA= "SELECT NUM_CRITERE_LANGUE FROM LIGNE_CONDITION_LANGUE WHERE NUM_CRITERE = ? AND OBLIG_LANGUE = 1";
    private static final String SQL_SELECT_LOGICIEL_ETUDIANT= "SELECT * FROM LIGNE_LOGICIEL WHERE NUM_ETUDIANT = ? ";
    private static final String SQL_SELECT_LOGICIEL_OFFRE= "SELECT NUM_CRITERE_LOGICIEL FROM LIGNE_CONDITION_LOGICIEL WHERE NUM_CRITERE = ? ";
    private static final String SQL_SELECT_LOGICIEL_OBLIGA= "SELECT NUM_CRITERE_LOGICIEL FROM LIGNE_CONDITION_LOGICIEL WHERE NUM_CRITERE = ? AND OBLIG_LOGICIEL = 1";
    private static final String SQL_SELECT_EXPERIENCE_PRO= "SELECT * FROM EXPERIENCE_PRO WHERE NUM_ETUDIANT = ? ";
    private static final String SQL_SELECT_RECHERCHE_FORMATION= "SELECT * FROM FORMATION WHERE NUM_FORMATION = ? ";
    private static final String SQL_SELECT_RECHERCHE_LANGUE= "SELECT * FROM LANGUE WHERE NUM_LANGUE = ? ";
    private static final String SQL_SELECT_RECHERCHE_LOGICIEL= "SELECT * FROM LOGICIEL WHERE NUM_LOGICIEL = ? ";
    private static final String SELECT_RECHERCHER_ECOLE= "SELECT * FROM ETABLISSEMENT WHERE NUM_ETABLISSEMENT = ? ";
    private static final String SELECT_RECHERCHER_ENTREPRISE= "SELECT * FROM ENTREPRISE WHERE NUM_ENTREPRISE = ? ";
    private static final String SELECT_RECHERCHE_ETUDIANT= "SELECT * FROM ETUDIANT WHERE NUM_ETUDIANT = ? ";
    private static final String SELECT_RECHERCHE_CRITERE= "SELECT * FROM CRITERES WHERE NUM_STAGE = ? ";
    private static final String SQL_SELECT_ETUDIANT_LOGIN= "SELECT * FROM ETUDIANT WHERE EMAIL_ETUDIANT = ? AND MOT_PASSE_ETUDIANT = ? ";
    private static final String SQL_SELECT_RECHERCHE_NIV_LOGICIEL= "SELECT * FROM NIVEAU_LOGICIEL WHERE NUM_NIVEAU_LOGICIEL = ? ";
    private static final String SQL_SELECT_RECHERCHE_NIV_LANGUE= "SELECT * FROM NIVEAU_LANGUE WHERE NUM_NIVEAU_LANGUE = ? ";
    private static final String SQL_SELECT_RECHERCHE_CRITERES_FORMATION= "SELECT * FROM CRITERE_FORMATION WHERE NUM_CRIT_FORMATION = ? ";
    private static final String SQL_SELECT_OFFRE = "SELECT * FROM OFFRE_DE_STAGE";
    private static final String SQL_INSERT_POSTULE= "INSERT INTO LIGNE_POSTUL(NUM_ETUDIANT,NUM_STAGE,DATE_DIPONIBILITE,LETTRE_MOTIVATION,VALIDATION) VALUES(?,?,?,?,0)";
    private static final String SQL_SELECT_POSTULATION= "SELECT * FROM LIGNE_POSTUL WHERE NUM_ETUDIANT = ? AND NUM_STAGE = ? ";
    private static final String SQL_SELECT__OFFRE_BY_ID= "SELECT * FROM OFFRE_DE_STAGE WHERE NUM_STAGE = ? ";
    private static final String SQL_SELECT_CANDIDATURES_ETUDIANT= "SELECT * FROM LIGNE_POSTUL WHERE NUM_ETUDIANT = ? ";
    private static final String SQL_SELECT_ETUDIANTS = "SELECT * FROM ETUDIANT";
    private static final String SQL_INSERT_COMMENTAIRE = "INSERT INTO COMMENTAIRE VALUES(null,?,?,?,?)";
    private static final String SQL_SELECT_COMMENTAIRES = "SELECT * FROM COMMENTAIRE WHERE NUM_STAGE = ? ORDER BY NUM_COM";
    private static final String SQL_INSERT_MESSAGE = "INSERT INTO MESSAGE VALUES(?,?,null,?,?)";
    private static final String SQL_SELECT_MESSAGES = "SELECT * FROM MESSAGE WHERE (NUM_RECEPTEUR = ? AND NUM_EMETTEUR = ?) OR (NUM_RECEPTEUR = ? AND NUM_EMETTEUR = ?) ORDER BY N__MSG";
    private static final String  SQL_SELECT_LAST_MESSAGES = "SELECT MAX(N__MSG) AS 'IDMSG' FROM MESSAGE WHERE NUM_RECEPTEUR = ? GROUP BY NUM_EMETTEUR";
    private static final String SELECT_RECHERCHER_MESSAGE= "SELECT * FROM MESSAGE WHERE N__MSG = ? ";
    private static final String COUNT_POSTULATIONS = "SELECT COUNT(NUM_STAGE) AS 'NBRPOSTUL' FROM LIGNE_POSTUL WHERE NUM_ETUDIANT = ?";
    private static final String COUNT_POSTULATIONS_ACCEPT = "SELECT COUNT(NUM_STAGE) AS 'NBRPOSTUL' FROM LIGNE_POSTUL WHERE NUM_ETUDIANT = ? AND VALIDATION = 1 ";
    private static final String COUNT_POSTULATIONS_REFUS = "SELECT COUNT(NUM_STAGE) AS 'NBRPOSTUL' FROM LIGNE_POSTUL WHERE NUM_ETUDIANT = ? AND VALIDATION = -1 ";
    
    public EtudiantDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;//connection
    }
    
    public int count_postulation_accept(int candidat)throws DAOException{
    	
    	Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int nbr = 0;

        try {
            connection = daoFactory.getConnexion();
            preparedStatement = initialisationRequetePreparee(connection, COUNT_POSTULATIONS_ACCEPT, false, candidat);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
            	
            	nbr = resultSet.getInt("NBRPOSTUL");
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connection);
        }
        return nbr;
    	
    	
    }
	 
	 public int count_postulation_refus(int candidat)throws DAOException{
		 
		 
		 Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;
	        int nbr = 0;

	        try {
	            connection = daoFactory.getConnexion();
	            preparedStatement = initialisationRequetePreparee(connection, COUNT_POSTULATIONS_REFUS, false, candidat);
	            resultSet = preparedStatement.executeQuery();
	            if (resultSet.next()) {
	            	
	            	nbr = resultSet.getInt("NBRPOSTUL");
	            }
	        } catch (SQLException e) {
	            throw new DAOException(e.getMessage());
	        } finally {
	            fermeturesSilencieuses(resultSet, preparedStatement, connection);
	        }
	        return nbr;
		 
	 }
    
    public int count_postulation(int candidat)throws DAOException{
    	
    	Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int nbr = 0;

        try {
            connection = daoFactory.getConnexion();
            preparedStatement = initialisationRequetePreparee(connection, COUNT_POSTULATIONS, false, candidat);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
            	
            	nbr = resultSet.getInt("NBRPOSTUL");
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connection);
        }
        return nbr;
    	
    }
    
    public List<Message> getLastMessages(int recepteur) throws DAOException{
    	
    	
    	Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Message> messages = new ArrayList<Message>();

        try {
            connection = daoFactory.getConnexion();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_LAST_MESSAGES, false, recepteur);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            	
            	messages.add(trouveMessage(SELECT_RECHERCHER_MESSAGE, resultSet.getInt("IDMSG")));
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connection);
        }
        return messages;
    	
    }
    
    public List<Message> getMessages(int emetteur, int recepteur) throws DAOException{
    	
    	
    	Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Message> messages = new ArrayList<Message>();

        try {
            connection = daoFactory.getConnexion();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_MESSAGES, false, recepteur, emetteur,emetteur, recepteur );
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            	
            	messages.add(mapMessage(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connection);
        }
        return messages;
    	
    }
    
    public void EnvoyerMsg(Message msg) throws DAOException{
    	
    	Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;
        try {
            connexion = daoFactory.getConnexion();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_INSERT_MESSAGE, true, msg.getRecepteur().getNum_etudiant() ,msg.getEmetteur().getNum_etudiant() ,msg.getDate_msg() ,msg.getTexte_msg() );
            int statut = preparedStatement.executeUpdate();
            if (statut == 0) {
                throw new DAOException("Échec de la création de etudiant, aucune ligne ajoutée dans la table.");
            }
            // connexion.commit();
        } catch (SQLException e) {
            if (connexion != null) {
                try {
                    connexion.rollback();
                } catch (SQLException ex) {
                }
            }
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);
        }
    	
    	
    }
    
    public List<Commentaire> getCommentairesByOffre(int idOffre) throws DAOException{
    	
    	
    	Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Commentaire> commentaires = new ArrayList<Commentaire>();

        try {
            connection = daoFactory.getConnexion();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_COMMENTAIRES, false, idOffre);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            	
            	commentaires.add(mapCommentaire(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connection);
        }
        return commentaires;
    	
    }

    
    public void PosterCommentaire(Commentaire comment ) throws DAOException{
    	
    	Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;
        try {
            connexion = daoFactory.getConnexion();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_INSERT_COMMENTAIRE, true, comment.getOffre() ,comment.getCandidat().getNum_etudiant() ,comment.getDate_com() ,comment.getText_com() );
            int statut = preparedStatement.executeUpdate();
            if (statut == 0) {
                throw new DAOException("Échec de la création de etudiant, aucune ligne ajoutée dans la table.");
            }
            // connexion.commit();
        } catch (SQLException e) {
            if (connexion != null) {
                try {
                    connexion.rollback();
                } catch (SQLException ex) {
                }
            }
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);
        }
    	
    	
    }
    
    public List<Etudiant> getEtudiants() throws DAOException{
    	
    	Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Etudiant> etudiants = new ArrayList<Etudiant>();

        try {
            connection = daoFactory.getConnexion();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_ETUDIANTS, false);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            	
            	etudiants.add(mapEtudiant(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connection);
        }
        return etudiants;
    	
    }
    
    
    public List<LignePostul> getPostulaByCandidat(Etudiant etudiant) throws DAOException{
    	
    	Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<LignePostul> ListeLignePostul = new ArrayList<LignePostul>();

        try {
            connection = daoFactory.getConnexion();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_CANDIDATURES_ETUDIANT, false, etudiant.getNum_etudiant());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            	
            	ListeLignePostul.add(mapPostule(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connection);
        }
        return ListeLignePostul;
    	
    }
    
    public Etudiant getEtudiantById(int id) throws DAOException{
    	
    	return trouveEtudiant(SELECT_RECHERCHE_ETUDIANT, id);
    	
    	
    }
    
    @Override
    public void ModifierEtudiant(Etudiant candidat) throws DAOException {

        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;
        try {
            connexion = daoFactory.getConnexion();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_UPDATE_ETUDIANT, true, candidat.getAdresse_etudiant() , candidat.getDate_naissance_etudiant() , candidat.getEmail_etudiant() ,candidat.getTel_gsm_etudiant() ,candidat.getTel_fixe_etudiant() ,candidat.getVille_etudiant() ,candidat.getCode_postal() ,candidat.getMot_passe_etudiant() ,candidat.getNum_etudiant());
            int statut = preparedStatement.executeUpdate();
            if (statut == 0) {
                throw new DAOException("Échec de la création de etudiant, aucune ligne ajoutée dans la table.");
            }
            // connexion.commit();
        } catch (SQLException e) {
            if (connexion != null) {
                try {
                    connexion.rollback();
                } catch (SQLException ex) {
                }
            }
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);
        }
    }
    
    
    public Etudiant rechercherEtudiant(String email, String password) throws DAOException {
    	
    	Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Etudiant etudiant = null;
        
        try {
            connection = daoFactory.getConnexion();
            preparedStatement = initialisationRequetePreparee(connection,SQL_SELECT_ETUDIANT_LOGIN, false, email, password );
            //preparedStatement = connection.prepareStatement(SQL_SELECT_ETUDIANT_LOGIN);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
            	
            	//etudiant= mapEtudiant(resultSet);
            	etudiant = new Etudiant();
            	etudiant.setNum_etudiant(resultSet.getInt("NUM_ETUDIANT"));
                etudiant.setNom_etudiant(resultSet.getString("NOM_ETUDIANT"));
                etudiant.setPrenom_etudiant(resultSet.getString("PRENOM_ETUDIANT"));
                etudiant.setEtablissement(trouveEcole(SELECT_RECHERCHER_ECOLE, resultSet.getInt("NUM_ETABLISSEMENT")));
                etudiant.setEmail_etudiant(resultSet.getString("EMAIL_ETUDIANT"));
                etudiant.setDate_naissance_etudiant(null);
                etudiant.setMot_passe_etudiant(resultSet.getString("MOT_PASSE_ETUDIANT"));
            
                if(resultSet.getDate("DATE_NAISS_ETUDIANT")==null){
	                etudiant.setDate_naissance_etudiant(null);
	            }else etudiant.setDate_naissance_etudiant(resultSet.getDate("DATE_NAISS_ETUDIANT"));
                
                if(resultSet.getString("TEL_FIXE_ETUDIANT")==null){
	                etudiant.setTel_fixe_etudiant("");
	            }else etudiant.setTel_fixe_etudiant(resultSet.getString("TEL_FIXE_ETUDIANT"));
                
                if(resultSet.getString("TEL_GSM_ETUDIANT")==null){
	                etudiant.setTel_gsm_etudiant("");
	            }else etudiant.setTel_gsm_etudiant(resultSet.getString("TEL_GSM_ETUDIANT"));
                
                if(resultSet.getString("VILLE_ETUDIANT")==null){
	                etudiant.setVille_etudiant("");
	            }else etudiant.setVille_etudiant(resultSet.getString("VILLE_ETUDIANT"));
                
                if(resultSet.getString("LOGIN_ETUDIANT")==null){
                	etudiant.setLogin_etudiant("");
	            }else etudiant.setLogin_etudiant(resultSet.getString("LOGIN_ETUDIANT"));
                
                if(resultSet.getString("RUE_ETUDIANT")==null){
                	etudiant.setAdresse_etudiant("");
	            }else etudiant.setAdresse_etudiant(resultSet.getString("RUE_ETUDIANT"));
                
                if(resultSet.getInt("CODE_POSTAL_")==0){
                	etudiant.setCode_postal(0);
	            }else etudiant.setCode_postal(resultSet.getInt("CODE_POSTAL_"));
                
                
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connection);
        }
        
        
        return etudiant;
    	
    }

    public void ajouterExperiencePro(ExperiencePro experiencePro,int candidat) throws DAOException {

        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;
        try {
            connexion = daoFactory.getConnexion();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_INSERT_EXPERIENCE_PRO, true, candidat ,experiencePro.getEmployeur_experience_pro() ,experiencePro.getFonction() ,experiencePro.getDate_debut() , experiencePro.getDate_fin());
            int statut = preparedStatement.executeUpdate();
            if (statut == 0) {
                throw new DAOException("Échec de la création de etudiant, aucune ligne ajoutée dans la table.");
            }
            // connexion.commit();
        } catch (SQLException e) {
            if (connexion != null) {
                try {
                    connexion.rollback();
                } catch (SQLException ex) {
                }
            }
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);
        }
    }

    public void ajouterLogiciel(int logiciel,int id_candidat , int num_niv_logiciel) throws DAOException {

        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;
        try {
            connexion = daoFactory.getConnexion();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_INSERT_LIGNE_LOGICIEL, true, id_candidat, logiciel , num_niv_logiciel);
            int statut = preparedStatement.executeUpdate();
            if (statut == 0) {
                throw new DAOException("Échec de la création de etudiant, aucune ligne ajoutée dans la table.");
            }
            // connexion.commit();
        } catch (SQLException e) {
            if (connexion != null) {
                try {
                    connexion.rollback();
                } catch (SQLException ex) {
                }
            }
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);
        }
    }

    public void ajouterLangue(Etudiant candidat ,int num_langue , int num_niv_langue) throws DAOException {

        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;
        try {
        	connexion = daoFactory.getConnexion();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_INSERT_LIGNE_LANGUE, true, candidat.getNum_etudiant(), num_langue, num_niv_langue);
            int statut = preparedStatement.executeUpdate();
            if (statut == 0) {
                throw new DAOException("Échec de la création de etudiant, aucune ligne ajoutée dans la table.");
            }
            // connexion.commit();
        } catch (SQLException e) {
            if (connexion != null) {
                try {
                    connexion.rollback();
                } catch (SQLException ex) {
                }
            }
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);
        }
    }

    public void ajouterFormation(Formation formation,int id_candidat) throws DAOException {

        Connection connexion = null;
        PreparedStatement preparedStatement1 = null;
        PreparedStatement preparedStatement2 = null;
        ResultSet valeursAutoGenerees = null;
        try {
            connexion = daoFactory.getConnexion();
            preparedStatement1 = initialisationRequetePreparee(connexion, SQL_INSERT_FORMATION, true, formation.getType_formation(), formation.getLibele_formation(), formation.getDomaine_formation() );
            preparedStatement2 = initialisationRequetePreparee(connexion, SQL_INSERT_LIGNE_FORMATION, true, id_candidat);
            int statut = preparedStatement1.executeUpdate();
            if (statut == 0) {
                throw new DAOException("Échec de la création de etudiant, aucune ligne ajoutée dans la table.");
            }
            
            statut = preparedStatement2.executeUpdate();
            if (statut == 0) {
                throw new DAOException("Échec de la création de etudiant, aucune ligne ajoutée dans la table.");
            }
            
            // connexion.commit();
        } catch (SQLException e) {
            if (connexion != null) {
                try {
                    connexion.rollback();
                } catch (SQLException ex) {
                }
            }
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(valeursAutoGenerees, preparedStatement1, connexion);
            fermeturesSilencieuses(valeursAutoGenerees, preparedStatement2, connexion);
        }
    }
    
    public void ajouterPostulation(Etudiant etudiant, int idOffre, String lettre , Date dateDispo) throws DAOException {

        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;
 
        try {
            connexion = daoFactory.getConnexion();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_INSERT_POSTULE, true, etudiant.getNum_etudiant() , idOffre, dateDispo , lettre);
            int statut = preparedStatement.executeUpdate();
            if (statut == 0) {
                throw new DAOException("Échec de la création de etudiant, aucune ligne ajoutée dans la table.");
            }
            // connexion.commit();
        } catch (SQLException e) {
            if (connexion != null) {
                try {
                    connexion.rollback();
                } catch (SQLException ex) {
                }
            }
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);
        }
    }
    
    public int isDejaPostuler(Etudiant etudiant,int idOffre) throws DAOException{
    	
    	Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int result = 0;
       
        try {
            connection = daoFactory.getConnexion();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_POSTULATION, false, etudiant.getNum_etudiant() , idOffre);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            	
            	result = 1;
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connection);
        }
        return result;
    	
    }

    @Override
    public List<Formation> afficherListFormationsEtudiant(Etudiant etudiant) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Formation> ListeFormations = new ArrayList<Formation>();

        try {
            connection = daoFactory.getConnexion();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_TOUS_FORMATION_ETUDIANT, false, etudiant.getNum_etudiant());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            	
                ListeFormations.add(trouveFormation(SQL_SELECT_RECHERCHE_FORMATION,resultSet.getInt("NUM_FORMATION")));
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connection);
        }
        return ListeFormations;
    }

    @Override
    public List<Formation> afficherFormationOffres(OffreDeStage offreDeStage) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Formation> ListeFormations = new ArrayList<Formation>();
        /*Criteres criteres = new Criteres();
        criteres = trouveCritere(SELECT_TOUS_CRITERES, offreDeStage.getNum_stage());*/
        try {
            connection = daoFactory.getConnexion();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_FORMATION, false, offreDeStage.getNum_stage());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ListeFormations.add(trouveCritereFormation(SQL_SELECT_RECHERCHE_CRITERES_FORMATION,resultSet.getInt("NUM_CRIT_FORMATION")));
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connection);
        }
        return ListeFormations;
    }

    @Override
    public List<Formation> afficherFormationObligatoireOffres(OffreDeStage offreDeStage) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Formation> ListeFormations = new ArrayList<Formation>();
       /* Criteres criteres = new Criteres();
        criteres = trouveCritere(SELECT_TOUS_CRITERES, offreDeStage.getNum_stage());*/
        try {
            connection = daoFactory.getConnexion();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_FORMATION_OBLIGA, false, offreDeStage.getNum_stage());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            	
                ListeFormations.add(trouveCritereFormation(SQL_SELECT_RECHERCHE_CRITERES_FORMATION,resultSet.getInt("NUM_CRIT_FORMATION")));
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connection);
        }
        return ListeFormations;
    }

    @Override
    public List<LigneLangue> afficherListLanguesEtudiant(Etudiant etudiant) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<LigneLangue> ListeLangues = new ArrayList<LigneLangue>();

        try {
            connection = daoFactory.getConnexion();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_LANGUE_ETUDIANT, false, etudiant.getNum_etudiant());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            	
            	
            	LigneLangue ligne = new LigneLangue();
            	ligne.setEtudiant(etudiant);
            	ligne.setLangue(trouveLangue(SQL_SELECT_RECHERCHE_LANGUE,resultSet.getInt("NUM_LANGUE")));
            	ligne.setNiv_langue(trouveNivLangue(SQL_SELECT_RECHERCHE_NIV_LANGUE,resultSet.getInt("NUM_NIVEAU_LANGUE")));
            	
            	ListeLangues.add( ligne );
            	
            	
                //ListeLangues.add(trouveLangue(SQL_SELECT_RECHERCHE_LANGUE,resultSet.getInt("NUM_LANGUE")));
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connection);
        }
        return ListeLangues;
    }

    @Override
    public List<Langue> afficherLanguesOffres(OffreDeStage offreDeStage) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Langue> ListeLangues = new ArrayList<Langue>();
        /*Criteres criteres = new Criteres();
        criteres = trouveCritere(SELECT_TOUS_CRITERES, offreDeStage.getNum_stage());*/
        try {
            connection = daoFactory.getConnexion();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_LANGUE_OFFRES, false, offreDeStage.getNum_stage());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            	
                ListeLangues.add(trouveLangue(SQL_SELECT_RECHERCHE_LANGUE,resultSet.getInt("NUM_CRITERE_LANGUE")));
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connection);
        }
        return ListeLangues;
    }

    @Override
    public List<Langue> afficherLanguesObligatoireOffres(OffreDeStage offreDeStage) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Langue> ListeLangues = new ArrayList<Langue>();
        /*Criteres criteres = new Criteres();
        criteres = trouveCritere(SELECT_TOUS_CRITERES, offreDeStage.getNum_stage());*/
        try {
            connection = daoFactory.getConnexion();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_LANGUE_OBLIGA, false, offreDeStage.getNum_stage());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            	
                ListeLangues.add(trouveLangue(SQL_SELECT_RECHERCHE_LANGUE,resultSet.getInt("NUM_CRITERE_LANGUE")));
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connection);
        }
        return ListeLangues;
    }

    @Override
    public List<LigneLogiciel> afficherListLogicielsEtudiant(Etudiant etudiant) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<LigneLogiciel> ListeLogiciels = new ArrayList<LigneLogiciel>();

        try {
            connection = daoFactory.getConnexion();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_LOGICIEL_ETUDIANT, false, etudiant.getNum_etudiant());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            	
            	ListeLogiciels.add( new LigneLogiciel(etudiant, trouveLogiciel(SQL_SELECT_RECHERCHE_LOGICIEL,resultSet.getInt("NUM_LOGICIEL")), trouveNiveauLogiciel(SQL_SELECT_RECHERCHE_NIV_LOGICIEL,resultSet.getInt("NUM_NIVEAU_LOGICIEL"))) );
            	
                //ListeLogiciels.add(trouveLogiciel(SQL_SELECT_RECHERCHE_LOGICIEL,resultSet.getInt("NUM_LOGICIEL")));
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connection);
        }
        return ListeLogiciels;
    }

    @Override
    public List<Logiciel> afficherLogicielsOffres(OffreDeStage offreDeStage) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Logiciel> ListeLogiciels = new ArrayList<Logiciel>();
        /*Criteres criteres = new Criteres();
        criteres = trouveCritere(SELECT_TOUS_CRITERES, offreDeStage.getNum_stage());*/
        try {
            connection = daoFactory.getConnexion();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_LOGICIEL_OFFRE, false, offreDeStage.getNum_stage());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ListeLogiciels.add(trouveLogiciel(SQL_SELECT_RECHERCHE_LOGICIEL,resultSet.getInt("NUM_CRITERE_LOGICIEL")));
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connection);
        }
        return ListeLogiciels;
    }

    @Override
    public List<Logiciel> afficherLogicielsObligatoireOffres(OffreDeStage offreDeStage) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Logiciel> ListeLogiciels = new ArrayList<Logiciel>();
        /*Criteres criteres = new Criteres();
        criteres = trouveCritere(SELECT_TOUS_CRITERES, offreDeStage.getNum_stage());*/
        try {
            connection = daoFactory.getConnexion();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_LOGICIEL_OBLIGA, false, offreDeStage.getNum_stage());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ListeLogiciels.add(trouveLogiciel(SQL_SELECT_RECHERCHE_LOGICIEL,resultSet.getInt("NUM_CRITERE_LOGICIEL")));
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connection);
        }
        return ListeLogiciels;
    }

    @Override
    public List<ExperiencePro> afficherListExperienceProEtudiant(Etudiant etudiant) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<ExperiencePro> ListeExperiencePros = new ArrayList<ExperiencePro>();

        try {
            connection = daoFactory.getConnexion();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_EXPERIENCE_PRO, false, etudiant.getNum_etudiant());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ListeExperiencePros.add(mapExperiencePro(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connection);
        }
        return ListeExperiencePros;
    }

    
    public List<OffreDeStage> afficherOffres(Etudiant etudiant) throws DAOException {
    	
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<OffreDeStage> listeOffre = new ArrayList<OffreDeStage>();

        
        //Les competences de candidat
        List<Formation> ListeFormation = new ArrayList<Formation>();
        
        List<LigneLangue> ListeLigneLangue = new ArrayList<LigneLangue>();
        List<Langue> ListeLangue = new ArrayList<Langue>();
        
        List<LigneLogiciel> ListeLigneLogiciel = new ArrayList<LigneLogiciel>();
        List<Logiciel> ListeLogiciel = new ArrayList<Logiciel>();

        ListeFormation = afficherListFormationsEtudiant(etudiant);
        
        ListeLigneLangue = afficherListLanguesEtudiant(etudiant);
        for(LigneLangue x : ListeLigneLangue) ListeLangue.add(x.getLangue());
        
        ListeLigneLogiciel = afficherListLogicielsEtudiant(etudiant);
        for(LigneLogiciel x : ListeLigneLogiciel) ListeLogiciel.add(x.getLogiciel());

        
        try {
            connection = daoFactory.getConnexion();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_OFFRE, false);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            	
                if (testOffre(ListeFormation, ListeLangue, ListeLogiciel, mapOffreStage(resultSet)) == 1) {
                    listeOffre.add(mapOffreStage(resultSet));
                }
                
            }

        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connection);
        }
        return listeOffre;
    }
    
    
    public int testOffre(List<Formation> ListeFormations, List<Langue> ListeLangues, List<Logiciel> ListeLogiciels, OffreDeStage offreDeStage) throws DAOException {
        
    	//Les criteres
    	List<Formation> ListeFormationOffr = new ArrayList<Formation>();
        List<Langue> ListeLangueOffr = new ArrayList<Langue>();
        List<Logiciel> ListeLogicielOffr = new ArrayList<Logiciel>();

        ListeFormationOffr = afficherFormationOffres(offreDeStage);
        ListeLangueOffr = afficherLanguesObligatoireOffres(offreDeStage);
        ListeLogicielOffr = afficherLogicielsObligatoireOffres(offreDeStage);
        
        
        int iformation = 0;
        
        for (int i = 0; i < ListeFormations.size(); i++) {
            int j = 0;
            while (j < ListeFormationOffr.size() ) {
                
            	if( ListeFormationOffr.get(j).getType_formation().equals(ListeFormations.get(i).getType_formation()) && ListeFormationOffr.get(j).getDomaine_formation().equals(ListeFormations.get(i).getDomaine_formation()) ) 
            	break;
            
            	
            	j++;
            }
            if (j < ListeFormationOffr.size()) {
            	
                iformation = 1;
                ListeFormationOffr.remove(j);
            }
        }

        for (int i = 0; i < ListeLangues.size(); i++) {
            int j = 0;
            while ( j < ListeLangueOffr.size() && !(ListeLangues.get(i).getLibele_langue().equals(ListeLangueOffr.get(j).getLibele_langue())) ) {
                j++;
            }
            if (j < ListeLangueOffr.size()) {
            	
                ListeLangueOffr.remove(j);
            }
        }

        for (int i = 0; i < ListeLogiciels.size(); i++) {
            int j = 0;
            while ( j < ListeLogicielOffr.size() && !(ListeLogiciels.get(i).getLibele_logiciel().equals(ListeLogicielOffr.get(j).getLibele_logiciel())) ) {
                j++;
            }
            if (j < ListeLogicielOffr.size()) {
                ListeLogicielOffr.remove(j);
            }
        }

        
       
        if (iformation == 1 && ListeLogicielOffr.size() == 0 && ListeLangueOffr.size() == 0) {
        	
            return 1;
        } else {
            return 0;
        }
    }
    
    
    /*
     * Méthode générique utilisée pour retourner un client depuis la base de
     * données, correspondant à la requête SQL donnée prenant en paramètres les
     * objets passés en argument.
     */
    private Etablissement trouveEcole(String sql, Object... objets) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Etablissement ecole = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnexion();
            /*
             * Préparation de la requête avec les objets passés en arguments
             * (ici, uniquement un id) et exécution.
             */
            preparedStatement = initialisationRequetePreparee(connexion, sql, false, objets);
            resultSet = preparedStatement.executeQuery();

            /* Parcours de la ligne de données retournée dans le ResultSet */
            if (resultSet.next()) {
                ecole = mapEcole(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connexion);
        }

        return ecole;
    }

    private Etudiant trouveEtudiant(String sql, Object... objets) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Etudiant etudiant = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnexion();
            /*
             * Préparation de la requête avec les objets passés en arguments
             * (ici, uniquement un id) et exécution.
             */
            preparedStatement = initialisationRequetePreparee(connexion, sql, false, objets);
            resultSet = preparedStatement.executeQuery();

            /* Parcours de la ligne de données retournée dans le ResultSet */
            if (resultSet.next()) {
                etudiant = mapEtudiant(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connexion);
        }

        return etudiant;
    }

    private OffreDeStage trouveOffreDeStage(String sql, Object... objets) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        OffreDeStage offreDeStage = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnexion();
            /*
             * Préparation de la requête avec les objets passés en arguments
             * (ici, uniquement un id) et exécution.
             */
            preparedStatement = initialisationRequetePreparee(connexion, sql, false, objets);
            resultSet = preparedStatement.executeQuery();

            /* Parcours de la ligne de données retournée dans le ResultSet */
            if (resultSet.next()) {
                offreDeStage = mapOffreStage(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connexion);
        }

        return offreDeStage;
    }

    private Entreprise trouveEntreprise(String sql, Object... objets) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Entreprise entreprise = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnexion();
            /*
             * Préparation de la requête avec les objets passés en arguments
             * (ici, uniquement un id) et exécution.
             */
            preparedStatement = initialisationRequetePreparee(connexion, sql, false, objets);
            resultSet = preparedStatement.executeQuery();

            /* Parcours de la ligne de données retournée dans le ResultSet */
            if (resultSet.next()) {
                entreprise = mapEntreprise(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connexion);
        }

        return entreprise;
    }

    private Formation trouveFormation(String sql, Object... objets) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Formation formation = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnexion();
            /*
             * Préparation de la requête avec les objets passés en arguments
             * (ici, uniquement un id) et exécution.
             */
            preparedStatement = initialisationRequetePreparee(connexion, sql, false, objets);
            resultSet = preparedStatement.executeQuery();

            /* Parcours de la ligne de données retournée dans le ResultSet */
            if (resultSet.next()) {
                formation = mapFormation(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connexion);
        }

        return formation;
    }
    
    private Formation trouveCritereFormation(String sql, Object... objets) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Formation formation = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnexion();
            /*
             * Préparation de la requête avec les objets passés en arguments
             * (ici, uniquement un id) et exécution.
             */
            preparedStatement = initialisationRequetePreparee(connexion, sql, false, objets);
            resultSet = preparedStatement.executeQuery();

            /* Parcours de la ligne de données retournée dans le ResultSet */
            if (resultSet.next()) {
                formation = mapCritereFormation(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connexion);
        }

        return formation;
    }

    private Langue trouveLangue(String sql, Object... objets) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Langue langue = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnexion();
            /*
             * Préparation de la requête avec les objets passés en arguments
             * (ici, uniquement un id) et exécution.
             */
            preparedStatement = initialisationRequetePreparee(connexion, sql, false, objets);
            resultSet = preparedStatement.executeQuery();

            /* Parcours de la ligne de données retournée dans le ResultSet */
            if (resultSet.next()) {
                langue = mapLangue(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connexion);
        }

        return langue;
    }

    private Logiciel trouveLogiciel(String sql, Object... objets) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Logiciel logiciel = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnexion();
            /*
             * Préparation de la requête avec les objets passés en arguments
             * (ici, uniquement un id) et exécution.
             */
            preparedStatement = initialisationRequetePreparee(connexion, sql, false, objets);
            resultSet = preparedStatement.executeQuery();

            /* Parcours de la ligne de données retournée dans le ResultSet */
            if (resultSet.next()) {
                logiciel = mapLogiciel(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connexion);
        }

        return logiciel;
    }
    
    
    private NiveauLogiciel trouveNiveauLogiciel(String sql, Object... objets) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        NiveauLogiciel nivLogiciel = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnexion();
            /*
             * Préparation de la requête avec les objets passés en arguments
             * (ici, uniquement un id) et exécution.
             */
            preparedStatement = initialisationRequetePreparee(connexion, sql, false, objets);
            resultSet = preparedStatement.executeQuery();

            /* Parcours de la ligne de données retournée dans le ResultSet */
            if (resultSet.next()) {
            	nivLogiciel = mapNivLogiciel(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connexion);
        }

        return nivLogiciel;
    }
    

    private Niveaulangue trouveNivLangue(String sql, Object... objets) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Niveaulangue nivLangue = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnexion();
            /*
             * Préparation de la requête avec les objets passés en arguments
             * (ici, uniquement un id) et exécution.
             */
            preparedStatement = initialisationRequetePreparee(connexion, sql, false, objets);
            resultSet = preparedStatement.executeQuery();

            /* Parcours de la ligne de données retournée dans le ResultSet */
            if (resultSet.next()) {
            	nivLangue = mapNivLangue(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connexion);
        }

        return nivLangue;
    }
    
    private ExperiencePro trouveExperiencePro(String sql, Object... objets) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ExperiencePro experiencePro = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnexion();
            /*
             * Préparation de la requête avec les objets passés en arguments
             * (ici, uniquement un id) et exécution.
             */
            preparedStatement = initialisationRequetePreparee(connexion, sql, false, objets);
            resultSet = preparedStatement.executeQuery();

            /* Parcours de la ligne de données retournée dans le ResultSet */
            if (resultSet.next()) {
                experiencePro = mapExperiencePro(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connexion);
        }

        return experiencePro;
    }

    private Criteres trouveCritere(String sql, Object... objets) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Criteres criteres = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnexion();
            /*
             * Préparation de la requête avec les objets passés en arguments
             * (ici, uniquement un id) et exécution.
             */
            preparedStatement = initialisationRequetePreparee(connexion, sql, false, objets);
            resultSet = preparedStatement.executeQuery();

            /* Parcours de la ligne de données retournée dans le ResultSet */
            if (resultSet.next()) {
                criteres = mapCriteres(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connexion);
        }

        return criteres;
    }
    
    private Message trouveMessage(String sql, Object... objets) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Message message = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnexion();
            /*
             * Préparation de la requête avec les objets passés en arguments
             * (ici, uniquement un id) et exécution.
             */
            preparedStatement = initialisationRequetePreparee(connexion, sql, false, objets);
            resultSet = preparedStatement.executeQuery();

            /* Parcours de la ligne de données retournée dans le ResultSet */
            if (resultSet.next()) {
            	message = mapMessage(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connexion);
        }

        return message;
    }
    
    /*
     * Simple méthode utilitaire permettant de faire la correspondance (le
     * mapping) entre une ligne issue de la table des Ecole (un ResultSet) et
     * un bean Ecole.
     */
    private static Etablissement mapEcole(ResultSet resultSet) throws SQLException {
        Etablissement ecole = new Etablissement();

        ecole.setNum_etablissement(resultSet.getInt("NUM_ETABLISSEMENT"));
        ecole.setNom_etablissement(resultSet.getString("NUM_ETABLISSEMENT"));
        ecole.setAdresse_etablissement(resultSet.getString("NUM_ETABLISSEMENT"));
        ecole.setTel_fixe_etablissement(resultSet.getString("NUM_ETABLISSEMENT"));
        ecole.setTel_gsm_etablissement(resultSet.getString("NUM_ETABLISSEMENT"));
        ecole.setTel_gsm_etablissement(resultSet.getString("NUM_ETABLISSEMENT"));
        ecole.setLogin_etablissement(resultSet.getString("NUM_ETABLISSEMENT"));
        ecole.setMot_passe_etablissement(resultSet.getString("NUM_ETABLISSEMENT"));
        return ecole;
    }

    private Etudiant mapEtudiant(ResultSet resultSet) throws SQLException, DAOException {
        Etudiant etudiant = new Etudiant();

        etudiant.setNum_etudiant(resultSet.getInt("NUM_ETUDIANT"));
        etudiant.setNom_etudiant(resultSet.getString("NOM_ETUDIANT"));
        etudiant.setPrenom_etudiant(resultSet.getString("PRENOM_ETUDIANT"));
        etudiant.setEtablissement(trouveEcole(SELECT_RECHERCHER_ECOLE, resultSet.getInt("NUM_ETABLISSEMENT")));
        etudiant.setAdresse_etudiant(resultSet.getString("RUE_ETUDIANT"));
        etudiant.setEmail_etudiant(resultSet.getString("EMAIL_ETUDIANT"));
        etudiant.setTel_fixe_etudiant(resultSet.getString("TEL_FIXE_ETUDIANT"));
        etudiant.setTel_gsm_etudiant(resultSet.getString("TEL_GSM_ETUDIANT"));
        etudiant.setVille_etudiant(resultSet.getString("VILLE_ETUDIANT"));
        etudiant.setDate_naissance_etudiant(resultSet.getDate("DATE_NAISS_ETUDIANT"));
        etudiant.setCode_postal(resultSet.getInt("CODE_POSTAL_"));
        if(resultSet.getString("LOGIN_ETUDIANT")==null)
        	 etudiant.setLogin_etudiant("");
        else etudiant.setLogin_etudiant(resultSet.getString("LOGIN_ETUDIANT"));
        
        etudiant.setMot_passe_etudiant(resultSet.getString("MOT_PASSE_ETUDIANT"));

        return etudiant;
    }

    private static Entreprise mapEntreprise(ResultSet resultSet) throws SQLException {
        Entreprise entreprise = new Entreprise();

        entreprise.setNum_entreprise(resultSet.getInt("NUM_ENTREPRISE"));
        entreprise.setNom_entreprise(resultSet.getString("NOM_ENTREPRISE"));
        entreprise.setAdresse_entreprise(resultSet.getString("ADRESSE_ENTREPRISE"));
        entreprise.setTel_fixe_entreprise(resultSet.getString("TEL_FIXE_ENTREPRISE"));
        entreprise.setEmail_entreprise(resultSet.getString("EMAIL_ENTREPRISE"));
        entreprise.setLogin_entreprise(resultSet.getString("LOGIN_ENTREPRISE"));
        entreprise.setMot_passe_entreprise(resultSet.getString("MOT_PASSE_ENTREPRISE"));
        entreprise.setStatut(resultSet.getInt("STATUT"));

        return entreprise;
    }

    private OffreDeStage mapOffreStage(ResultSet resultSet) throws SQLException, DAOException {
        OffreDeStage offre = new OffreDeStage();

        offre.setNum_stage(resultSet.getInt("NUM_STAGE"));
        offre.setIntitule_du_stage(resultSet.getString("INTITULE_DU_STAGE"));
        offre.setEntreprise(trouveEntreprise(SELECT_RECHERCHER_ENTREPRISE, resultSet.getInt("NUM_ENTREPRISE")));
        offre.setDescription(resultSet.getString("DESCRIPTION"));

        return offre;
    }

    private static Formation mapFormation(ResultSet resultSet) throws SQLException {
        Formation formation = new Formation();

        formation.setNum_formation(resultSet.getInt("NUM_FORMATION"));
        formation.setLibele_formation(resultSet.getString("LIBELE_FORMATION"));
        formation.setType_formation(resultSet.getString("TYPE_FORMATION"));
        formation.setDomaine_formation(resultSet.getString("DOMAINE_FORMATION"));

        return formation;
    }
    
    private static Formation mapCritereFormation(ResultSet resultSet) throws SQLException {
        Formation formation = new Formation();

        formation.setNum_formation(resultSet.getInt("NUM_CRIT_FORMATION"));
        formation.setLibele_formation(resultSet.getString("CRIT_LIBELE_FORMATION"));
        formation.setType_formation(resultSet.getString("CRIT_TYPE_FORMATION"));
        formation.setDomaine_formation(resultSet.getString("CRIT_DOMAINE_FORMATION"));

        return formation;
    }

    private static Langue mapLangue(ResultSet resultSet) throws SQLException {
        Langue langue = new Langue();

        langue.setNum_langue(resultSet.getInt("NUM_LANGUE"));
        langue.setLibele_langue(resultSet.getString("LEBELE_LANGUE"));

        return langue;
    }

    private static Logiciel mapLogiciel(ResultSet resultSet) throws SQLException {
        Logiciel logiciel = new Logiciel();

        logiciel.setNum_logiciel(resultSet.getInt("NUM_LOGICIEL"));
        logiciel.setLibele_logiciel(resultSet.getString("LIBELE_LOGICIEL"));

        return logiciel;
    }
    
    private static NiveauLogiciel mapNivLogiciel(ResultSet resultSet) throws SQLException {
        NiveauLogiciel nivLogiciel = new NiveauLogiciel();

        nivLogiciel.setNum_niv_logiciel(resultSet.getInt("NUM_NIVEAU_LOGICIEL"));
        nivLogiciel.setLibele_logiciel(resultSet.getString("LIBELE_NIVEAU_LOGICIEL"));

        return nivLogiciel;
    }
    
    private static Niveaulangue mapNivLangue(ResultSet resultSet) throws SQLException {
    	Niveaulangue nivLangue = new Niveaulangue();

    	nivLangue.setNum_niv_langue(resultSet.getInt("NUM_NIVEAU_LANGUE"));
    	nivLangue.setLibele_niv_langue(resultSet.getString("LIEBELE_NIVEAU_LANGUE"));

        return nivLangue;
    }

    private ExperiencePro mapExperiencePro(ResultSet resultSet) throws SQLException, DAOException {
        ExperiencePro experiencePro = new ExperiencePro();

        experiencePro.setNum_experience_pro(resultSet.getInt("NUM_EXPERIENCE_PROE"));
        experiencePro.setFonction(resultSet.getString("FONCTION"));
        experiencePro.setEmployeur_experience_pro(resultSet.getString("EMPLOYEUR_EXPERIENCE_PRO"));
        experiencePro.setDate_fin(resultSet.getDate("DATE_FIN"));
        experiencePro.setDate_debut(resultSet.getDate("DATE_DEBUT"));
        experiencePro.setEtudiant(trouveEtudiant(SELECT_RECHERCHE_ETUDIANT, resultSet.getInt("NUM_ETUDIANT")));

        return experiencePro;
    }

    
    
    private Criteres mapCriteres(ResultSet resultSet) throws SQLException, DAOException {
        Criteres criteres = new Criteres();

        criteres.setNum_critere(resultSet.getInt("NUM_CRITERE"));
        criteres.setStage(trouveOffreDeStage(SELECT_RECHERCHE_CRITERE, resultSet.getInt("NUM_STAGE")));

        return criteres;
    }
    
    private LignePostul mapPostule(ResultSet resultSet) throws SQLException, DAOException {
        LignePostul postula = new LignePostul();

        postula.setStage(trouveOffreDeStage(SQL_SELECT__OFFRE_BY_ID, resultSet.getInt("NUM_STAGE")));
        postula.setEtudiant(trouveEtudiant(SELECT_RECHERCHE_ETUDIANT, resultSet.getInt("NUM_ETUDIANT")));
        postula.setLettre_motivation(resultSet.getString("LETTRE_MOTIVATION"));
        postula.setValidation(resultSet.getInt("VALIDATION"));
        postula.setDate_disponibilite( resultSet.getDate("DATE_DIPONIBILITE") );

        return postula;
    }
    
    private Commentaire mapCommentaire(ResultSet resultSet) throws SQLException, DAOException {
    	Commentaire comment = new Commentaire();

    	comment.setNum_com(resultSet.getInt("NUM_COM"));
    	comment.setOffre(resultSet.getInt("NUM_STAGE"));
    	comment.setCandidat(trouveEtudiant(SELECT_RECHERCHE_ETUDIANT, resultSet.getInt("NUM_ETUDIANT")));
    	comment.setDate_com(resultSet.getString("DATE_COM"));
    	comment.setText_com(resultSet.getString("TEXTE_COM"));

        return comment;
    }
    
    private Message mapMessage(ResultSet resultSet) throws SQLException, DAOException {
    	Message message = new Message();

    	message.setN_msg(resultSet.getInt("N__MSG"));
    	message.setDate_msg(resultSet.getString("DATE_MSG"));
        message.setTexte_msg(resultSet.getString("TEXTE_MSG"));
        message.setEmetteur(trouveEtudiant(SELECT_RECHERCHE_ETUDIANT,resultSet.getString("NUM_EMETTEUR")));
        message.setRecepteur(trouveEtudiant(SELECT_RECHERCHE_ETUDIANT,resultSet.getString("NUM_RECEPTEUR")));

        return message;
    }
    
}
