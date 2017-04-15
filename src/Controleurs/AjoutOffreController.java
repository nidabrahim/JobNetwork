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

import Models.Beans.Entreprise;
import Models.Beans.Etudiant;
import Models.Beans.Formation;
import Models.Beans.LigneConditionLangue;
import Models.Beans.LigneConditionLogiciel;
import Models.Beans.LigneFormation;
import Models.DAO.ClassPrincipal.DaoFactory;
import Models.DAO.Interfaces.EntrepriseDao;
import Models.DAO.Interfaces.EtudiantDao;
import Models.Exceptions.DAOException;


@WebServlet("/AjoutOffre")
public class AjoutOffreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private EntrepriseDao entrepriseDao;
	private Entreprise entreprise;
	private HttpSession session;
	private List<LigneConditionLogiciel> listeCritereLog;
	private List<Formation> listeCritereForm;
	private List<LigneConditionLangue> listeCritereLang;
	
	
	
	public void init(ServletConfig config) throws ServletException {
		
		try {
			
            DaoFactory daoFactory = DaoFactory.getInstance();
            entrepriseDao =  daoFactory.getEntrepriseDao();
            
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }
		
	}
	
	
	
    public AjoutOffreController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		getElementsFromSession(request);
	
		String intitule = request.getParameter("intitule");
		String description = request.getParameter("description");
		
		
		
		try {
			entrepriseDao.publierOffre( intitule, description, 1, listeCritereLog, listeCritereForm, listeCritereLang);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.getRequestDispatcher("/Ajout_offre").forward(request, response);
		
		
	}
	
	private void getElementsFromSession(HttpServletRequest request){
		
		session = request.getSession();
		//entreprise = (Entreprise) session.getAttribute("entreprise");
		
		listeCritereLog = (List<LigneConditionLogiciel>) session.getAttribute("listeCritereLog");
		listeCritereForm = (List<Formation>) session.getAttribute("listeCritereForm");
		listeCritereLang = (List<LigneConditionLangue>) session.getAttribute("listeCritereLang");
		
	}

}
