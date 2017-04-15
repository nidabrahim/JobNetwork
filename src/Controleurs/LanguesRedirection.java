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
import Models.Beans.LigneLangue;
import Models.DAO.ClassPrincipal.DaoFactory;
import Models.DAO.Interfaces.EtudiantDao;
import Models.Exceptions.DAOException;

/**
 * Servlet implementation class LanguesRedirection
 */
@WebServlet("/etudiant_langues")
public class LanguesRedirection extends HttpServlet {
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
    
    public LanguesRedirection() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		Etudiant etudiant = (Etudiant) session.getAttribute("candidat");
		
		List<LigneLangue> ListeLangue = null;
		
		try {
			ListeLangue = etudiantDao.afficherListLanguesEtudiant(etudiant);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("ListeLangue",ListeLangue );
		
		
		request.getRequestDispatcher("/WEB-INF/Vue/etudiant_langues.jsp").forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
