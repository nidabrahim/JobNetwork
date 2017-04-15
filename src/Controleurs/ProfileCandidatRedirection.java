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
import Models.Beans.Formation;
import Models.Beans.LigneLangue;
import Models.Beans.LigneLogiciel;
import Models.DAO.ClassPrincipal.DaoFactory;
import Models.DAO.Interfaces.EtudiantDao;
import Models.Exceptions.DAOException;

/**
 * Servlet implementation class ProfileCandidatRedirection
 */
@WebServlet("/ProfileCandidat")
public class ProfileCandidatRedirection extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private EtudiantDao etudiantDao;
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
	
	
    public ProfileCandidatRedirection() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Etudiant etudiant = (Etudiant) session.getAttribute("candidat");
		
		//Les logiciels
		List<LigneLogiciel> ListeCompetence = null;
		try {
			ListeCompetence = etudiantDao.afficherListLogicielsEtudiant(etudiant);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("ListeCompetence", ListeCompetence);
		
		//Les experiences pro
		List<ExperiencePro> ListeExperiencePros = null;
		try {
			ListeExperiencePros = etudiantDao.afficherListExperienceProEtudiant(etudiant);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("ListeExperiencePros", ListeExperiencePros);
		
		//Les formations
		List<Formation> ListeFormation = null;
		try {
			ListeFormation = etudiantDao.afficherListFormationsEtudiant(etudiant);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("ListeFormation", ListeFormation);
		
		
		//Les langues
		List<LigneLangue> ListeLangue = null;
		
		try {
			ListeLangue = etudiantDao.afficherListLanguesEtudiant(etudiant);
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
		
		request.setAttribute("ListeLangue",ListeLangue );
		request.setAttribute("nbrpostul", nbrpostul);
		request.setAttribute("nbrpostulAccept", nbrpostulAccept);
		request.setAttribute("nbrpostulRefus", nbrpostulRefus);
		
		
		request.getRequestDispatcher("/WEB-INF/Vue/etudiantProfile.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
