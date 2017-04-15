package Controleurs;

import java.io.IOException;
import java.sql.Date;
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
import Models.DAO.ClassPrincipal.DaoFactory;
import Models.DAO.Interfaces.EtudiantDao;
import Models.Exceptions.DAOException;

/**
 * Servlet implementation class AjoutExproController
 */
@WebServlet("/AjoutExpro")
public class AjoutExproController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private EtudiantDao etudiantDao;
	private ExperiencePro expro;
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
	
	
    public AjoutExproController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		session = request.getSession();
		etudiant = (Etudiant) session.getAttribute("candidat");
		
		expro = new ExperiencePro();
		
		expro.setEmployeur_experience_pro(request.getParameter("entreprise"));
		expro.setFonction(request.getParameter("fonction"));
		expro.setDate_debut(Date.valueOf( request.getParameter("datedebut")));
		expro.setDate_fin(Date.valueOf( request.getParameter("datefin")));
		expro.setEtudiant(etudiant);
		
		try {
			etudiantDao.ajouterExperiencePro(expro,etudiant.getNum_etudiant());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		List<ExperiencePro> ListeExperiencePros = null;
		try {
			ListeExperiencePros = etudiantDao.afficherListExperienceProEtudiant(etudiant);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("ListeExperiencePros", ListeExperiencePros);
		
		request.getRequestDispatcher("/WEB-INF/Vue/etudiant_experiencePros.jsp").forward(request, response);
		
	}

}
