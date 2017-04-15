package Controleurs;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Models.Beans.Entreprise;
import Models.Beans.Etudiant;
import Models.Beans.OffreDeStage;
import Models.DAO.ClassPrincipal.DaoFactory;
import Models.DAO.Interfaces.EntrepriseDao;
import Models.DAO.Interfaces.EtudiantDao;
import Models.Exceptions.DAOException;

/**
 * Servlet implementation class AcceptationCandidatureRedirection
 */
@WebServlet("/AcceptationCandidature")
public class AcceptationCandidatureRedirection extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EntrepriseDao entrepriseDao;
	private EtudiantDao etudiantDao;
	private Entreprise entreprise;
	private Etudiant etudiant;
	private OffreDeStage offre;
	private HttpSession session;
	private final int ACCEPT= 1;
       
	
    public void init(ServletConfig config) throws ServletException {
		
		try {
			
            DaoFactory daoFactory = DaoFactory.getInstance();
            entrepriseDao = daoFactory.getEntrepriseDao();
            etudiantDao = daoFactory.getEtudiantDao();
           
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }
		
	}
    
    public AcceptationCandidatureRedirection() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int codeEtd = Integer.parseInt(request.getParameter("codeEtd"));
		int codeStg = Integer.parseInt(request.getParameter("codeStg"));
		
		try {
			entrepriseDao.repondreCandidature(codeEtd,codeStg,ACCEPT);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			offre = entrepriseDao.getOffreById(codeStg);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		try {
			etudiant = etudiantDao.getEtudiantById(codeEtd);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("offreLTM", offre);
		request.setAttribute("etudiantLTM", etudiant);
		
		request.getRequestDispatcher("/WEB-INF/Vue/candidatures-validation.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
