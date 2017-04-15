package Models.DAO.Implementation;

import Models.Beans.Entreprise;
import Models.Beans.Etablissement;
import Models.Beans.Etudiant;
import Models.DAO.ClassPrincipal.DaoFactory;
import Models.DAO.Interfaces.EcoleDao;
import Models.Exceptions.DAOException;
import static Models.Utilitaire.DAOUtilitaires.fermeturesSilencieuses;
import static Models.Utilitaire.DAOUtilitaires.initialisationRequetePreparee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EcoleDaoImpl implements EcoleDao {

    private DaoFactory daoFactory;
    private static final String SQL_INSERT_ECOLE= "INSERT INTO ETABLISSEMENT VALUES(?,?,?,?,?,?,?)";
    private static final String SQL_INSERT_ETUDIANT= "INSERT INTO ETUDIANT(NUM_ETUDIANT,NUM_ETABLISSEMENT,NOM_ETUDIANT,PRENOM_ETUDIANT,EMAIL_ETUDIANT,MOT_PASSE_ETUDIANT) VALUES(null,?,?,?,?,?)";
    private static final String SQL_DELETE_ETUDIANT= "DELETE FROM ETUDIANT WHERE NUM_ETUDIANT = ? ";
    private static final String SQL_SELECT_TOUS_ETUDIANTS= "SELECT * FROM ETUDIANT "; 
    private static final String SELECT_RECHERCHER_ECOLE= "SELECT * FROM ETABLISSEMENT WHERE NUM_ETABLISSEMENT = ? ";
    private static final String SQL_SELECT_ECOLE_LOGIN= "SELECT * FROM ETABLISSEMENT WHERE LOGIN_ETABLISS = ? AND MOT_PASSE_ETABLISS = ? ";
    
    public EcoleDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;//connection
    }
    
    public Etablissement rechercherEcole(String email , String password) throws DAOException{
    	
    	
    	Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Etablissement etablissement = null;
        
        try {
            connection = daoFactory.getConnexion();
            preparedStatement = initialisationRequetePreparee(connection,SQL_SELECT_ECOLE_LOGIN, false, email, password );
            //preparedStatement = connection.prepareStatement(SQL_SELECT_ETUDIANT_LOGIN);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
            	
            	etablissement = mapEcole(resultSet);
            	
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connection);
        }
        
        
        return etablissement;
    }

    @Override
    public void ajouterEcole(Etablissement ecole) throws DAOException {

        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;
        try {
            connexion = daoFactory.getConnexion();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_INSERT_ECOLE, true, "1",ecole.getNom_etablissement(),ecole.getAdresse_etablissement(),ecole.getTel_gsm_etablissement(),ecole.getTel_fixe_etablissement(),ecole.getMot_passe_etablissement(),ecole.getLogin_etablissement());
            int statut = preparedStatement.executeUpdate();
            if (statut == 0) {
                throw new DAOException("Échec de la création de ecole, aucune ligne ajoutée dans la table.");
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

    @Override
    public void ajouterEtudiant(Etudiant candidat) throws DAOException {

    	Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;
        try {
            connexion = daoFactory.getConnexion();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_INSERT_ETUDIANT, true, candidat.getEtablissement().getNum_etablissement(), candidat.getNom_etudiant(), candidat.getPrenom_etudiant(), candidat.getEmail_etudiant() , candidat.getMot_passe_etudiant());
            int statut = preparedStatement.executeUpdate();
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
            fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);
        }
    }

    @Override
    public void SupprimerEtudiant(Etudiant candidat) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;
        try {
            connexion = daoFactory.getConnexion();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_DELETE_ETUDIANT, true, candidat.getNum_etudiant());
            int statut = preparedStatement.executeUpdate();
            if (statut == 0) {
                throw new DAOException("Échec de la Suppression de ecole, aucune ligne trouver dans la table.");
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

    @Override
    public List<Etudiant> afficherTousLesEtudiants(Etablissement ecole) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Etudiant> ListeEtudiants = new ArrayList<Etudiant>();

        try {
            connection = daoFactory.getConnexion();
            preparedStatement = connection.prepareStatement(SQL_SELECT_TOUS_ETUDIANTS);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ListeEtudiants.add(mapEtudiant(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connection);
        }
        return ListeEtudiants;
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

    /*
     * Simple méthode utilitaire permettant de faire la correspondance (le
     * mapping) entre une ligne issue de la table des Ecole (un ResultSet) et
     * un bean Ecole.
     */
    private static Etablissement mapEcole(ResultSet resultSet) throws SQLException {
        Etablissement ecole = new Etablissement();

        ecole.setNum_etablissement(resultSet.getInt("NUM_ETABLISSEMENT"));
        ecole.setNom_etablissement(resultSet.getString("NOM_ETABLISSEMENT"));
        ecole.setAdresse_etablissement(resultSet.getString("ADRESSE_ETABLISSEMENT"));
        ecole.setTel_fixe_etablissement(resultSet.getString("TEL_FIXE_ETABLISS"));
        ecole.setTel_gsm_etablissement(resultSet.getString("TEL_GSM_ETABLISS"));
        ecole.setLogin_etablissement(resultSet.getString("LOGIN_ETABLISS"));
        ecole.setMot_passe_etablissement(resultSet.getString("MOT_PASSE_ETABLISS"));
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
        etudiant.setLogin_etudiant(resultSet.getString("LOGIN_ETUDIANT"));
        etudiant.setMot_passe_etudiant(resultSet.getString("MOT_PASSE_ETUDIANT"));

        return etudiant;
    }
}
