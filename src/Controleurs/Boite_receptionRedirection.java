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
import javax.websocket.Session;

import Models.Beans.Etudiant;
import Models.Beans.LignePostul;
import Models.DAO.ClassPrincipal.DaoFactory;
import Models.DAO.Interfaces.EtudiantDao;
import Models.Exceptions.DAOException;

/**
 * Servlet implementation class Boite_receptionRedirection
 */
@WebServlet("/Boite_reception")
public class Boite_receptionRedirection extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EtudiantDao etudiantDao;
	private HttpSession session;
	private Etudiant etudiant;
	private List<LignePostul> candidatures;
	private int nbrpostul;
	private int nbrpostulAccept;
	private int nbrpostulRefus;
    
       
	public void init(ServletConfig config) throws ServletException {
		
		try {
			
            DaoFactory daoFactory = DaoFactory.getInstance();
         
            etudiantDao = daoFactory.getEtudiantDao();
            
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }
		
	}
	
	
	
    public Boite_receptionRedirection() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		session = request.getSession();
		etudiant = (Etudiant) session.getAttribute("candidat");
		
		try {
			candidatures = etudiantDao.getPostulaByCandidat(etudiant);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			nbrpostul = etudiantDao.count_postulation(etudiant.getNum_etudiant());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			nbrpostulAccept = etudiantDao.count_postulation_accept(etudiant.getNum_etudiant());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			nbrpostulRefus = etudiantDao.count_postulation_refus(etudiant.getNum_etudiant());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("mesCandidatures", candidatures);
		request.setAttribute("nbrpostul", nbrpostul);
		request.setAttribute("nbrpostulAccept", nbrpostulAccept);
		request.setAttribute("nbrpostulRefus", nbrpostulRefus);
		
		request.getRequestDispatcher("/WEB-INF/Vue/boite-reception.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
