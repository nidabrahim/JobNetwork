package Controleurs;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Models.Beans.Etudiant;
import Models.DAO.ClassPrincipal.DaoFactory;
import Models.DAO.Interfaces.EtudiantDao;
import Models.Exceptions.DAOException;

/**
 * Servlet implementation class EnvoieCandidatureController
 */
@WebServlet("/EnvoieCandidatureStage")
public class EnvoieCandidatureController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private EtudiantDao etudiantDao;
	private Etudiant etudiant;
	private HttpSession session;
	private String lettre;
	private int offre;
	private Date dateDispo;
	
	
	public void init(ServletConfig config) throws ServletException {
		
		try {
			
            DaoFactory daoFactory = DaoFactory.getInstance();
            etudiantDao = daoFactory.getEtudiantDao();
            
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }
		
	}
	
   
    public EnvoieCandidatureController() {
        super();
    }

    
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		session = request.getSession();
		etudiant = (Etudiant) session.getAttribute("candidat");
		
		dateDispo = Date.valueOf(request.getParameter("dateDispo"));
		lettre = request.getParameter("lettre");
		offre = Integer.parseInt(request.getParameter("idOffre"));
		
		try {
			etudiantDao.ajouterPostulation(etudiant, offre, lettre, dateDispo);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.getRequestDispatcher("/ConsulterOffre?id="+offre).forward(request, response);
		
	}

}
