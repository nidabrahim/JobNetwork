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
import Models.Beans.LignePostul;
import Models.DAO.ClassPrincipal.DaoFactory;
import Models.DAO.Interfaces.EntrepriseDao;
import Models.Exceptions.DAOException;

/**
 * Servlet implementation class CandidaturesRedirection
 */
@WebServlet("/Candidatures")
public class CandidaturesRedirection extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HttpSession session;
	private EntrepriseDao entrepriseDao;
	private Entreprise entreprise;
	private List<LignePostul> candidatures;
	
	
	public void init(ServletConfig config) throws ServletException {
		
		try {
			
            DaoFactory daoFactory = DaoFactory.getInstance();
            entrepriseDao =  daoFactory.getEntrepriseDao();
            
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }
		
	}
       
 
    public CandidaturesRedirection() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		session = request.getSession();
		//entreprise = (Entreprise) session.getAttribute("entreprise");
		entreprise = new Entreprise();entreprise.setNum_entreprise(1);
		
		try {
			candidatures = entrepriseDao.getCandidatures(entreprise);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("candidatures", candidatures);
		
		request.getRequestDispatcher("/WEB-INF/Vue/candidatures.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
