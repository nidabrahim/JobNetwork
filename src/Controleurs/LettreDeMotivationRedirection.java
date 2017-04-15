package Controleurs;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Beans.Etudiant;
import Models.Beans.ExperiencePro;
import Models.Beans.Formation;
import Models.Beans.LigneLangue;
import Models.Beans.LigneLogiciel;
import Models.Beans.LignePostul;
import Models.Beans.OffreDeStage;
import Models.DAO.ClassPrincipal.DaoFactory;
import Models.DAO.Interfaces.EntrepriseDao;
import Models.DAO.Interfaces.EtudiantDao;
import Models.Exceptions.DAOException;


@WebServlet("/LettreDeMotivation")
public class LettreDeMotivationRedirection extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EntrepriseDao entrepriseDao;
	private EtudiantDao etudiantDao;
	private Etudiant etudiant;
	//private OffreDeStage offre;
	private LignePostul postula;
	
	
	public void init(ServletConfig config) throws ServletException {
		
		try {
			
            DaoFactory daoFactory = DaoFactory.getInstance();
            entrepriseDao = daoFactory.getEntrepriseDao();
            etudiantDao = daoFactory.getEtudiantDao();
           
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }
		
	}
       
    
    public LettreDeMotivationRedirection() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int codeEtd = Integer.parseInt(request.getParameter("idEtd"));
		int codeStg = Integer.parseInt(request.getParameter("idStg"));
		
		/*try {
			offre = entrepriseDao.getOffreById(codeStg);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		try {
			etudiant = etudiantDao.getEtudiantById(codeEtd);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			postula = entrepriseDao.getPostulaByCandidatAndOffre(codeEtd,codeStg);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*request.setAttribute("offreLTM", offre);
		request.setAttribute("etudiantLTM", etudiant);*/
		request.setAttribute("postulaLTM", postula);
		
		
		//Les logiciels
				List<LigneLogiciel> ListeCompetence = null;
				try {
					ListeCompetence = etudiantDao.afficherListLogicielsEtudiant(etudiant);
				} catch (DAOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		//Les experiences pro
				List<ExperiencePro> ListeExperiencePros = null;
				try {
					ListeExperiencePros = etudiantDao.afficherListExperienceProEtudiant(etudiant);
				} catch (DAOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		//Les formations
				List<Formation> ListeFormation = null;
				try {
					ListeFormation = etudiantDao.afficherListFormationsEtudiant(etudiant);
				} catch (DAOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		//Les langues
				List<LigneLangue> ListeLangue = null;
				
				try {
					ListeLangue = etudiantDao.afficherListLanguesEtudiant(etudiant);
				} catch (DAOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		
		request.setAttribute("ListeLangue",ListeLangue );
		request.setAttribute("ListeFormation", ListeFormation);
		request.setAttribute("ListeCompetence", ListeCompetence);
		request.setAttribute("ListeExperiencePros", ListeExperiencePros);
		
		request.getRequestDispatcher("/WEB-INF/Vue/lettre-motivation.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
