package Controleurs;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Models.Beans.Etablissement;
import Models.Beans.Etudiant;
import Models.DAO.ClassPrincipal.DaoFactory;
import Models.DAO.Interfaces.EcoleDao;
import Models.Utilitaire.EtudiantsParser;
import envoiemail.EnvoiEmail;



@WebServlet("/InscrireetudiantByEcole")
public class InscrireetudiantByEcoleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public static final String CHEMIN = "chemin";
    public static final String CONF_DAO_FACTORY = "DaoFactory";
    public static final String SESSION_ECOLE = "ecoleSess";
    public static final String ATT_FORM = "form";
    public static final String VUE_SUCCES = "/jobNetwork/InscriptionEtudiant";
    public static final String VUE_REFUS = "/jobNetwork/InscriptionEtudiant";
    private EcoleDao ecoleDao;
    

    @Override
    public void init() throws ServletException {
        super.init();
        /* Récupération d'une instance de notre DAO  */
        try {
            DaoFactory daoFactory = DaoFactory.getInstance();
            ecoleDao = daoFactory.getEcoleDao();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
	
	
    public InscrireetudiantByEcoleController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		/*
         * Lecture du paramètre 'chemin' passé à la servlet via la déclaration
         * dans le web.xml
         */
        EtudiantsParser etudiantsParser = new EtudiantsParser();

        //String chemin = request.getParameter(CHEMIN);
     
        /* Création de la session Etudiant */
        HttpSession session = request.getSession();
        /* chargement de la session Etudiant */
        Etablissement ecolesession = null;
        ecolesession = (Etablissement) session.getAttribute(SESSION_ECOLE);
        if (ecolesession != null) {
            try {
                /* Traitement de la requête et récupération du bean en résultant */
                ArrayList<Etudiant> etudiants = etudiantsParser.getAllEtudiants("src/etudiants.xml");
               
                /* Ajout du bean et de l'objet métier à l'objet requête */
                
                for (int i = 0; i < etudiants.size(); i++) {
                    etudiants.get(i).setEtablissement(ecolesession);
                    etudiants.get(i).setMot_passe_etudiant(etudiants.get(i).getNom_etudiant()+""+etudiants.get(i).getPrenom_etudiant());
                    ecoleDao.ajouterEtudiant(etudiants.get(i));
                    EnvoiEmail envoi = new EnvoiEmail("jobnetworknd@gmail.com","123456789JN",etudiants.get(i).getEmail_etudiant(),"INSCRIPTION SUR PLATFORME JOB NETWORK","<h4>Bonjour "+etudiants.get(i).getNom_etudiant()+" "+etudiants.get(i).getPrenom_etudiant()+",</h4><p>Vous �tes inscrit dans notre platforme <strong>Job Network</strong>, voici votre mot de passe "+etudiants.get(i).getMot_passe_etudiant()+"</p><br><p>Cordialement</p><p>Equipe : NIDABRAHIM Youssef  et KANGA Dominique Bernard</p>");
                    
                }
                /* Sinon, ré-affichage du formulaire de création avec les erreurs */
               response.sendRedirect(VUE_SUCCES);
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                response.sendRedirect(VUE_SUCCES);
            }
        } else {
            /* À la réception d'une requête GET, simple affichage du formulaire */
            response.sendRedirect(VUE_REFUS);
        }
		
		
	}

}
