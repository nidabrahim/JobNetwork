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

import Models.Beans.Etudiant;
import Models.Beans.Formation;
import Models.Beans.LigneLogiciel;
import Models.Beans.Logiciel;
import Models.DAO.ClassPrincipal.DaoFactory;
import Models.DAO.Interfaces.EtudiantDao;
import Models.Exceptions.DAOException;

/**
 * Servlet implementation class AjoutCompetenceController
 */
@WebServlet("/AjoutCompetence")
public class AjoutCompetenceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EtudiantDao etudiantDao;
	private Etudiant etudiant;
	private HttpSession session;
	
	
	public void init(ServletConfig config) throws ServletException {
		
		try {
			
            DaoFactory daoFactory = DaoFactory.getInstance();
            etudiantDao = daoFactory.getEtudiantDao();
            
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }
		
	}
	
    
    public AjoutCompetenceController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		session = request.getSession();
		etudiant = (Etudiant) session.getAttribute("candidat");
		
	
		int technologie = Integer.parseInt(request.getParameter("technologie"));
		
		int niveau = Integer.parseInt(request.getParameter("niveau"));
		
		
		try {
			etudiantDao.ajouterLogiciel(technologie, etudiant.getNum_etudiant(), niveau);
			
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<LigneLogiciel> ListeCompetence = null;
		try {
			ListeCompetence = etudiantDao.afficherListLogicielsEtudiant(etudiant);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("ListeCompetence", ListeCompetence);
		
		request.getRequestDispatcher("/WEB-INF/Vue/etudiant_competence.jsp").forward(request, response);
		
	}

}
