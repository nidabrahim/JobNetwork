package Models.DAO.Implementation;

import Models.Beans.CritereLangue;
import Models.Beans.CritereLogiciel;
import Models.Beans.Criteres;
import Models.Beans.Entreprise;
import Models.Beans.Etablissement;
import Models.Beans.Etudiant;
import Models.Beans.ExperiencePro;
import Models.Beans.Formation;
import Models.Beans.Langue;
import Models.Beans.LigneConditionLangue;
import Models.Beans.LigneConditionLogiciel;
import Models.Beans.LigneFormation;
import Models.Beans.LignePostul;
import Models.Beans.Logiciel;
import Models.Beans.OffreDeStage;
import Models.DAO.ClassPrincipal.DaoFactory;
import Models.DAO.Interfaces.EntrepriseDao;
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



public class EntrepriseDaoImpl implements EntrepriseDao {

    private DaoFactory daoFactory;
    
    private static final String SQL_INSERT_ENTREPRISE= "INSERT INTO ENTREPRISE VALUES(?,?,?,?,?,?,?,?)";
    private static final String SQL_INSERT_CRITERE= "INSERT INTO CRITERES VALUES((select max(NUM_STAGE) from OFFRE_DE_STAGE),(select max(NUM_STAGE) from OFFRE_DE_STAGE))";
    private static final String SELECT_CRITERES= "SELECT * FROM CRITERES WHERE NUM_STAGE = ? ";
    private static final String SQL_INSERT_LIGNE_CONDITION_LANGUE= "INSERT INTO LIGNE_CONDITION_LANGUE VALUES((select max(NUM_CRITERE) from CRITERES),?,1,?)";
    private static final String SQL_INSERT_LIGNE_CONDITION_LOGICIEL= "INSERT INTO LIGNE_CONDITION_LOGICIEL(NUM_CRITERE,NUM_CRITERE_LOGICIEL,OBLIG_LOGICIEL,NUM_CRITERE_NIV_LOGICIEL) VALUES((select max(NUM_CRITERE) from CRITERES),?,?,1)";
    private static final String SQL_INSERT_LIGNE_CONDITION_FORMATION= "INSERT INTO LIGNE_CONDITION_FORMATION VALUES((select max(NUM_CRIT_FORMATION) from CRITERE_FORMATION),(select max(NUM_CRITERE) from CRITERES),?)";
    private static final String SELECT_RECHERCHER_ECOLE= "SELECT * FROM ETABLISSEMENT WHERE NUM_ETABLISSEMENT = ? ";
    private static final  String SELECT_RECHERCHER_ENTREPRISE= "SELECT * FROM ENTREPRISE WHERE NUM_ENTREPRISE = ? ";
    private static final String SELECT_RECHERCHE_EXP= "SELECT * FROM EXPERIENCE_PRO WHERE NUM_ETUDIANT = ? ";
    private static final String SQL_INSERT_OFFRE= "INSERT INTO OFFRE_DE_STAGE VALUES(null,?,?,?) ";/*offre_seq.nextval*/
    private static final String SQL_INSERT_FORMATION= "INSERT INTO CRITERE_FORMATION VALUES(null,?,?,?) ";/*formation_seq.nextval*/
    private static final String SQL_SELECT_TOUS_OFFRES_ENTREPRISE= "SELECT * FROM OFFRE_DE_STAGE WHERE NUM_ENTREPRISE = ? ";
    private static final String SQL_SELECT__OFFRE_BY_ID= "SELECT * FROM OFFRE_DE_STAGE WHERE NUM_STAGE = ? ";
    private static final String SQL_SELECT_POSTULATIONBYOFFRE= "SELECT * FROM LIGNE_POSTUL WHERE NUM_STAGE = ? AND VALIDATION <> '-1' ";
    private static final String SELECT_RECHERCHE_ETUDIANT= "SELECT * FROM ETUDIANT WHERE NUM_ETUDIANT = ? ";
    private static final String SQL_UPDATE_POSTULATION_VALIDATION= "UPDATE LIGNE_POSTUL SET VALIDATION = ? WHERE NUM_ETUDIANT = ? AND NUM_STAGE = ? ";
    private static final String SQL_SELECT_POSTULATIONBYCANDIDATANDOFFRE= "SELECT * FROM LIGNE_POSTUL WHERE NUM_ETUDIANT = ? AND NUM_STAGE = ? ";
    private static final String SQL_UPDATE_POSTULATION_MESSAGE= "UPDATE LIGNE_POSTUL SET MESSAGE = ? WHERE NUM_ETUDIANT = ? AND NUM_STAGE = ? ";
    private static final String SQL_SELECT_ENTREPRISE_LOGIN= "SELECT * FROM ENTREPRISE WHERE EMAIL_ENTREPRISE = ? AND MOT_PASSE_ENTREPRISE = ? ";
    private static final String SQL_SELECT_ENTREPRISE = "SELECT * FROM ENTREPRISE";
    
    public EntrepriseDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
    
    
    public List<Entreprise> getEntreprises() throws DAOException{
    	
    	Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Entreprise> entreprises = new ArrayList<Entreprise>();

        try {
            connection = daoFactory.getConnexion();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_ENTREPRISE, false);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            	
            	entreprises.add(mapEntreprise(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connection);
        }
        return entreprises;
    	
    }
    
    
    public Entreprise rechercherEntreprise(String email, String password) throws DAOException {
    	
    	Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Entreprise entreprise = null;
        
        try {
            connection = daoFactory.getConnexion();
            preparedStatement = initialisationRequetePreparee(connection,SQL_SELECT_ENTREPRISE_LOGIN, false, email, password );
            //preparedStatement = connection.prepareStatement(SQL_SELECT_ETUDIANT_LOGIN);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
            	
            	entreprise = mapEntreprise(resultSet);
            	
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connection);
        }
        
        
        return entreprise;
    	
    }
    
    public void sendMsgCandidature(int codeEtd, int codeStg, String msg) throws DAOException{
    	
    	Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;
        try {
            connexion = daoFactory.getConnexion();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_UPDATE_POSTULATION_MESSAGE, true, msg ,codeEtd ,codeStg );
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
    
    public LignePostul getPostulaByCandidatAndOffre(int codeEtd , int codeStg) throws DAOException{
    	
    	Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        LignePostul postula = new LignePostul();

        try {
            connection = daoFactory.getConnexion();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_POSTULATIONBYCANDIDATANDOFFRE, false, codeEtd, codeStg);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            	
            	postula = mapPostule(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connection);
        }
        return postula;
    	
    }
    
    public void repondreCandidature(int codeEtd , int codeStg , int decision) throws DAOException{
    	
    	Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;
        try {
            connexion = daoFactory.getConnexion();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_UPDATE_POSTULATION_VALIDATION, true, decision ,codeEtd ,codeStg );
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
    
    public void creerEntreprise(Entreprise entreprise) throws DAOException {

        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;
        try {
            connexion = daoFactory.getConnexion();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_INSERT_ENTREPRISE, true, "1", entreprise.getNom_entreprise(), entreprise.getTel_fixe_entreprise(), entreprise.getEmail_entreprise(), entreprise.getAdresse_entreprise(), entreprise.getMot_passe_entreprise(), entreprise.getLogin_entreprise(), entreprise.getStatut() );
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
    
    
    public void ajoutOffre(String intitule,String description,int idEntreprise) throws DAOException{
    	
    	Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;
        try {
            connexion = daoFactory.getConnexion();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_INSERT_OFFRE, true, idEntreprise, intitule, description);
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
    
    public void ajouterLogiciel(CritereLogiciel Logiciel, int oblig_logiciel) throws DAOException {

        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;
 
        try {
            connexion = daoFactory.getConnexion();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_INSERT_LIGNE_CONDITION_LOGICIEL, true, Logiciel.getNum_critere_logiciel() , oblig_logiciel );
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
    
    public void ajouterCritere() throws DAOException {

        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;
        try {
            connexion = daoFactory.getConnexion();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_INSERT_CRITERE, true);
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

    public void ajouterLangue(CritereLangue langue, int oblig_langue) throws DAOException {

        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;
   
        try {
            connexion = daoFactory.getConnexion();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_INSERT_LIGNE_CONDITION_LANGUE, true, langue.getNum_critere_langue(), oblig_langue);
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

    public void ajouterFormation(Formation formation) throws DAOException {

        Connection connexion = null;
        PreparedStatement preparedStatement1 = null;
        PreparedStatement preparedStatement2 = null;
        ResultSet valeursAutoGenerees = null;
        
        try {
            connexion = daoFactory.getConnexion();
            preparedStatement1 = initialisationRequetePreparee(connexion, SQL_INSERT_FORMATION, true, formation.getType_formation(), formation.getLibele_formation(), formation.getDomaine_formation() );
            preparedStatement2 = initialisationRequetePreparee(connexion, SQL_INSERT_LIGNE_CONDITION_FORMATION, true,0);
            int statut = preparedStatement1.executeUpdate();
            if (statut == 0) {
                throw new DAOException("Échec de la création de etudiant, aucune ligne ajoutée dans la table.");
            }
            //connexion.commit();
            statut = preparedStatement2.executeUpdate();
            if (statut == 0) {
                throw new DAOException("Échec de la création de etudiant, aucune ligne ajoutée dans la table.");
            }
             //connexion.commit();
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
    
    public List<LignePostul> getCandidatures(Entreprise entreprise) throws DAOException{
    	
    	Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<LignePostul> postulas = new ArrayList<LignePostul>();
        List<OffreDeStage> offres = getOffresByEntreprise(entreprise.getNum_entreprise());

       for( OffreDeStage x : offres ){
    	   
    	   List<LignePostul> postula = getPostulation(x);
    	   if( postula.size() != 0 ){
    		   
    		   for( LignePostul y : postula ){
    			   
    			   postulas.add(y);
    		   }
    	   }
    	   
       }
        
        
        return postulas;
    	
    	
    }
    
    public List<LignePostul> getPostulation(OffreDeStage offre) throws DAOException{
    	
    	Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<LignePostul> postula = new ArrayList<LignePostul>();

        try {
            connection = daoFactory.getConnexion();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_POSTULATIONBYOFFRE, false, offre.getNum_stage());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            	
            	postula.add(mapPostule(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connection);
        }
        return postula;
    	
    	
    }

    
    public void publierOffre(String intitule,String description,int idEntreprise,List<LigneConditionLogiciel> listeCritereLog,List<Formation> listeCritereForm,List<LigneConditionLangue> listeCritereLang) throws DAOException{
    	
    	ajoutOffre( intitule, description, idEntreprise);
    	ajouterCritere();
    	
    	//La liste des criteres logiciels
    	for( LigneConditionLogiciel x : listeCritereLog ){
    		ajouterLogiciel(x.getCritere_logiciel(), x.getOblig_logiciel());
    	}
    	
    	//La liste des criteres formations
    	for( Formation x : listeCritereForm ){
    		ajouterFormation(x);
    	}
    	
    	//La liste des criteres langues
    	for( LigneConditionLangue x : listeCritereLang ){
    		ajouterLangue(x.getCritere_langue(), x.getOblig_langue());
    	}
    	
    	
    }
    
    public List<OffreDeStage> getOffresByEntreprise(int id) throws DAOException{
    	
    	Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<OffreDeStage> offres = new ArrayList<OffreDeStage>();

        try {
            connection = daoFactory.getConnexion();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_TOUS_OFFRES_ENTREPRISE, false, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            	
            	offres.add(mapOffreStage(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connection);
        }
        return offres;
    	
    }
    
    
    public OffreDeStage getOffreById(int id) throws DAOException{
    	
    	Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        OffreDeStage offre = new OffreDeStage();

        try {
            connection = daoFactory.getConnexion();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT__OFFRE_BY_ID, false, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
            	
            	offre = mapOffreStage(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connection);
        }
        return offre;
    	
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

    private  Entreprise trouveEntreprise(String sql, Object... objets) throws DAOException {
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
    
    private LignePostul mapPostule(ResultSet resultSet) throws SQLException, DAOException {
        LignePostul postula = new LignePostul();

        postula.setStage(trouveOffreDeStage(SQL_SELECT__OFFRE_BY_ID, resultSet.getInt("NUM_STAGE")));
        postula.setEtudiant(trouveEtudiant(SELECT_RECHERCHE_ETUDIANT, resultSet.getInt("NUM_ETUDIANT")));
        postula.setLettre_motivation(resultSet.getString("LETTRE_MOTIVATION"));
        postula.setValidation(resultSet.getInt("VALIDATION"));
        postula.setDate_disponibilite( resultSet.getDate("DATE_DIPONIBILITE") );
        postula.setMessage( resultSet.getString("MESSAGE") );

        return postula;
    }

    private static Formation mapFormation(ResultSet resultSet) throws SQLException {
        Formation formation = new Formation();

        formation.setNum_formation(resultSet.getInt("NUM_FORMATION"));
        formation.setLibele_formation(resultSet.getString("TYPE_FORMATION"));
        formation.setType_formation(resultSet.getString("LIBELE_FORMATION"));
        formation.setDomaine_formation(resultSet.getString("DOMAINE_FORMATION"));

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

    private ExperiencePro mapExperiencePro(ResultSet resultSet) throws SQLException, DAOException {
        ExperiencePro experiencePro = new ExperiencePro();

        experiencePro.setNum_experience_pro(resultSet.getInt("NUM_EXPERIENCE_PROE"));
        experiencePro.setFonction(resultSet.getString("EMPLOYEUR_EXPERIENCE_PRO"));
        experiencePro.setEmployeur_experience_pro(resultSet.getString("EMPLOYEUR_EXPERIENCE_PRO"));
        experiencePro.setDate_fin(resultSet.getDate("DATE_FIN"));
        experiencePro.setDate_debut(resultSet.getDate("DATE_DEBUT"));
        experiencePro.setEtudiant(trouveEtudiant(SELECT_RECHERCHE_EXP, resultSet.getInt("NUM_ETUDIANT")));

        return experiencePro;
    }

    private Criteres mapCriteres(ResultSet resultSet) throws SQLException, DAOException {
        Criteres criteres = new Criteres();

        criteres.setNum_critere(resultSet.getInt("NUM_CRITERE"));
        criteres.setStage(trouveOffreDeStage(SELECT_CRITERES, resultSet.getInt("NUM_STAGE")));

        return criteres;
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
        etudiant.setLogin_etudiant(resultSet.getString("LOGIN_ETUDIANT"));
        etudiant.setMot_passe_etudiant(resultSet.getString("MOT_PASSE_ETUDIANT"));

        return etudiant;
    }

}
