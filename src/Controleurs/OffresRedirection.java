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
import Models.Beans.Entreprise;
import Models.Beans.Etudiant;
import Models.Beans.Formation;
import Models.Beans.LigneConditionLangue;
import Models.Beans.LigneConditionLogiciel;
import Models.Beans.OffreDeStage;
import Models.DAO.ClassPrincipal.DaoFactory;
import Models.DAO.Interfaces.EntrepriseDao;
import Models.DAO.Interfaces.EtudiantDao;
import Models.Exceptions.DAOException;




@WebServlet("/ListeOffres")
public class OffresRedirection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private EntrepriseDao entrepriseDao;
	private EtudiantDao etudiantDao;
	private List<OffreDeStage> listeOffres;
	private HttpSession session;
	private List<Formation> listeFormation;
	private List<LigneConditionLogiciel> listeLogiciels;
	private List<LigneConditionLangue> listeLangue;
	
	
	public void init(ServletConfig config) throws ServletException {
		
		try {
			
            DaoFactory daoFactory = DaoFactory.getInstance();
            entrepriseDao = daoFactory.getEntrepriseDao();
            etudiantDao = daoFactory.getEtudiantDao();
            
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }
		
	}
	
   
    public OffresRedirection() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//session = request.getSession();
		//Entreprise entreprise = (Entreprise) session.getAttribute("entreprise");
		
		try {
			listeOffres = entrepriseDao.getOffresByEntreprise(1);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(request.getAttribute("listeOffres") != null) request.removeAttribute("listeOffres");
		
		request.setAttribute("listeOffres", listeOffres);
		
		request.getRequestDispatcher("/WEB-INF/Vue/offres.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = (HttpSession) request.getSession();
		Etudiant candidat = (Etudiant) session.getAttribute("candidat");
		String comment = request.getParameter("comment");
		String commentDate = request.getParameter("fullDate");
		int refOffre = Integer.parseInt(request.getParameter("refOffre"));
		
	
		
		Commentaire commentaire = new Commentaire();
		commentaire.setText_com(comment);
		commentaire.setCandidat(candidat);
		commentaire.setDate_com(commentDate);
		commentaire.setOffre(refOffre);
		
		try {
			etudiantDao.PosterCommentaire(commentaire);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("comment", comment);
		session.setAttribute("commentDate", commentDate);
	}

}
