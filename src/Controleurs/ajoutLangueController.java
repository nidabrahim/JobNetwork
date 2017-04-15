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
import Models.Beans.LigneLangue;
import Models.DAO.ClassPrincipal.DaoFactory;
import Models.DAO.Interfaces.EtudiantDao;
import Models.Exceptions.DAOException;


@WebServlet("/ajoutLangue")
public class ajoutLangueController extends HttpServlet {
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
	
	
    public ajoutLangueController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		session = request.getSession();
		etudiant = (Etudiant) session.getAttribute("candidat");
		
		int langue = Integer.parseInt(request.getParameter("langue"));
		
		int niveau = Integer.parseInt(request.getParameter("niveau"));
		
		try {
			etudiantDao.ajouterLangue(etudiant, langue, niveau);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
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

}
