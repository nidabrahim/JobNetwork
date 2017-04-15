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
import Models.Beans.ExperiencePro;
import Models.Beans.Formation;
import Models.DAO.ClassPrincipal.DaoFactory;
import Models.DAO.Interfaces.EtudiantDao;
import Models.Exceptions.DAOException;

/**
 * Servlet implementation class AjoutFormationController
 */
@WebServlet("/AjoutFormation")
public class AjoutFormationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EtudiantDao etudiantDao;
	private Formation formation;
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
	
	
   
    public AjoutFormationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		session = request.getSession();
		etudiant = (Etudiant) session.getAttribute("candidat");
		
		formation = new Formation();
		
		formation.setLibele_formation(request.getParameter("formation"));
		formation.setDomaine_formation(request.getParameter("domaine"));
		formation.setType_formation(request.getParameter("type"));
		
		try {
			etudiantDao.ajouterFormation(formation, etudiant.getNum_etudiant());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Formation> ListeFormation = null;
		try {
			ListeFormation = etudiantDao.afficherListFormationsEtudiant(etudiant);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("ListeFormation", ListeFormation);
		
		request.getRequestDispatcher("/WEB-INF/Vue/etudiant_formation.jsp").forward(request, response);
		
		
		
	}

}
