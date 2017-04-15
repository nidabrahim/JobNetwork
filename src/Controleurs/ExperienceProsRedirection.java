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
import Models.DAO.ClassPrincipal.DaoFactory;
import Models.DAO.Interfaces.EtudiantDao;
import Models.Exceptions.DAOException;

/**
 * Servlet implementation class ExperienceProsRedirection
 */
@WebServlet("/etudiant_experiencePros")
public class ExperienceProsRedirection extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EtudiantDao etudiantDao;
    
	public void init(ServletConfig config) throws ServletException {
		
		try {
			
            DaoFactory daoFactory = DaoFactory.getInstance();
            etudiantDao = daoFactory.getEtudiantDao();
            
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }
		
	}
	
	
    public ExperienceProsRedirection() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();   
		Etudiant candidat = (Etudiant) session.getAttribute("candidat");
		
		
		List<ExperiencePro> ListeExperiencePros = null;
		try {
			ListeExperiencePros = etudiantDao.afficherListExperienceProEtudiant(candidat);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("ListeExperiencePros", ListeExperiencePros);
		
		request.getRequestDispatcher("/WEB-INF/Vue/etudiant_experiencePros.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
