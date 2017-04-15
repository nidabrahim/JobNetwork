package Controleurs;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Beans.Entreprise;
import Models.DAO.ClassPrincipal.DaoFactory;
import Models.DAO.Interfaces.EntrepriseDao;
import Models.Exceptions.DAOException;

/**
 * Servlet implementation class EntreprisesRedirection
 */
@WebServlet("/Entreprises")
public class EntreprisesRedirection extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EntrepriseDao entrepriseDao;
	private List<Entreprise> entreprises;
	
       
	public void init(ServletConfig config) throws ServletException {
		
		try {
			
            DaoFactory daoFactory = DaoFactory.getInstance();
            entrepriseDao =  daoFactory.getEntrepriseDao();
            
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }
		
	}
	
	
    public EntreprisesRedirection() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			entreprises = entrepriseDao.getEntreprises();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("allEntreprises", entreprises);
		
		request.getRequestDispatcher("/WEB-INF/Vue/entreprises.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
