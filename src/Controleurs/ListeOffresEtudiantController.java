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
import Models.Beans.OffreDeStage;
import Models.DAO.ClassPrincipal.DaoFactory;
import Models.DAO.Interfaces.EntrepriseDao;
import Models.DAO.Interfaces.EtudiantDao;
import Models.Exceptions.DAOException;


@WebServlet("/ListeOffresEtudiant")
public class ListeOffresEtudiantController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private EntrepriseDao entrepriseDao;
	private EtudiantDao etudiantDao;
	private List<OffreDeStage> listeOffres;
	private HttpSession session;
	private Etudiant etudiant;
    
	
	public void init(ServletConfig config) throws ServletException {
		
		try {
			
            DaoFactory daoFactory = DaoFactory.getInstance();
            entrepriseDao = daoFactory.getEntrepriseDao();
            etudiantDao = daoFactory.getEtudiantDao();
            
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }
		
	}
	
    public ListeOffresEtudiantController() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		session = request.getSession();
		etudiant = (Etudiant) session.getAttribute("candidat");
		
		try {
			listeOffres = etudiantDao.afficherOffres(etudiant);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(request.getAttribute("listeOffres") != null) request.removeAttribute("listeOffres");
		
		request.setAttribute("listeOffres", listeOffres);
		
		request.getRequestDispatcher("/WEB-INF/Vue/offres.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
