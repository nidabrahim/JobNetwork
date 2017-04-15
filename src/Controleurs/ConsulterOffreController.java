package Controleurs;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Models.Beans.Commentaire;
import Models.Beans.Etudiant;
import Models.Beans.Formation;
import Models.Beans.Langue;
import Models.Beans.LigneConditionLangue;
import Models.Beans.LigneConditionLogiciel;
import Models.Beans.Logiciel;
import Models.Beans.OffreDeStage;
import Models.DAO.ClassPrincipal.DaoFactory;
import Models.DAO.Interfaces.EntrepriseDao;
import Models.DAO.Interfaces.EtudiantDao;
import Models.Exceptions.DAOException;


@WebServlet("/ConsulterOffre")
public class ConsulterOffreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private EntrepriseDao entrepriseDao;
	private EtudiantDao etudiantDao;
	private OffreDeStage uneOffre;
	private HttpSession session;
	private List<Formation> listeFormation;
	private List<Logiciel> listeLogiciels;
	private List<Langue> listeLangue;
	private Etudiant etudiant;
	private int dejaPostuler;
    private List<Commentaire> offreComments;
	
	public void init(ServletConfig config) throws ServletException {
		
		try {
			
            DaoFactory daoFactory = DaoFactory.getInstance();
            entrepriseDao = daoFactory.getEntrepriseDao();
            etudiantDao = daoFactory.getEtudiantDao();
            
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }
		
	}
	
	
	
    public ConsulterOffreController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		session = request.getSession();
		etudiant = (Etudiant) session.getAttribute("candidat");
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		try {
			uneOffre = entrepriseDao.getOffreById(id);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			listeFormation = etudiantDao.afficherFormationOffres(uneOffre);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			listeLogiciels = etudiantDao.afficherLogicielsOffres(uneOffre);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			listeLangue = etudiantDao.afficherLanguesOffres(uneOffre);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if( etudiant != null ){
		
			try {
				dejaPostuler = etudiantDao.isDejaPostuler(etudiant, id);
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			offreComments = etudiantDao.getCommentairesByOffre(id);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("dejaPostuler", dejaPostuler);
		request.setAttribute("id", id);
		request.setAttribute("uneOffre", uneOffre);
		request.setAttribute("listeFormation", listeFormation);
		request.setAttribute("listeLogiciels", listeLogiciels);
		request.setAttribute("listeLangue", listeLangue);
		request.setAttribute("offreComments", offreComments);
		
		request.getRequestDispatcher("/WEB-INF/Vue/detail-offre.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
