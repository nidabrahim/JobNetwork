package Models.DAO.ClassPrincipal;

import Models.Exceptions.DAOConfigurationException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Dominique
 */
public class ConnecteurBaseDonnees {
    private static final String FICHIER_PROPERTIES = "ProprietesBD/ProprieteBaseDeDonnees.properties";
    private static final String PROPERTY_URL = "url";
    private static final String PROPERTY_DRIVER = "driver";
    private static final String PROPERTY_NOM_UTILISATEUR = "nomutilisateur";
    private static final String PROPERTY_MOT_DE_PASSE = "motdepasse";
    private final String url;
    private final String username;
    private final String password;

    /* package */
    ConnecteurBaseDonnees(String url, String username, String password) {

        this.url = url;
        this.username = username;
        this.password = password;
    }

    /*
     * Méthode chargée de récupérer les informations de connexion à la base de
     * données, charger le driver JDBC et retourner une instance de la Factory
     */
    public static ConnecteurBaseDonnees getInstance() throws DAOConfigurationException {
       
         Properties properties = new Properties();
         String url;
         String driver;
         String nomUtilisateur;
         String motDePasse;

         
         InputStream fichierProperties = ConnecteurBaseDonnees.class.getClassLoader().getResourceAsStream(FICHIER_PROPERTIES);//POUR LIRE DANS LE FICHIER DE CONFIG

         if (fichierProperties == null) {
         throw new DAOConfigurationException("Le fichier properties " + FICHIER_PROPERTIES + " est introuvable.");
         }


         try {

         properties.load(fichierProperties);
         url = properties.getProperty(PROPERTY_URL);
         driver = properties.getProperty(PROPERTY_DRIVER);
         nomUtilisateur = properties.getProperty(PROPERTY_NOM_UTILISATEUR);
         motDePasse = properties.getProperty(PROPERTY_MOT_DE_PASSE);

         } catch (FileNotFoundException e) {
         throw new DAOConfigurationException("Le fichier properties " + FICHIER_PROPERTIES + " est introuvable.", e);
         } catch (IOException e) {
         throw new DAOConfigurationException("Impossible de charger le fichier properties " + FICHIER_PROPERTIES, e);
         }
         
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new DAOConfigurationException("Le driver est introuvable dans le classpath.", e);
        }

        ConnecteurBaseDonnees instance = new ConnecteurBaseDonnees(url,nomUtilisateur,motDePasse);
        return instance;
    }

    /* Méthode chargée de fournir une connexion à la base de données */
    public Connection getConnexion() throws SQLException {
        Connection Connexion=DriverManager.getConnection(url, username, password);
        Connexion.getAutoCommit();
        return Connexion;
    }
}
