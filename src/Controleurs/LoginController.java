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
import Models.Beans.Etablissement;
import Models.Beans.Etudiant;
import Models.DAO.ClassPrincipal.DaoFactory;
import Models.DAO.Interfaces.EcoleDao;
import Models.DAO.Interfaces.EntrepriseDao;
import Models.DAO.Interfaces.EtudiantDao;
import Models.Exceptions.DAOException;



@WebServlet("/Authentification")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EtudiantDao etudiantDao;
	private EntrepriseDao entrepriseDao;
	private EcoleDao ecoleDao;
    
    public LoginController() {
        super();
       
    }

    
	public void init(ServletConfig config) throws ServletException {
		
		try {
			
            DaoFactory daoFactory = DaoFactory.getInstance();
            etudiantDao = daoFactory.getEtudiantDao();
            entrepriseDao = daoFactory.getEntrepriseDao();
            ecoleDao = daoFactory.getEcoleDao();
            
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }
		
	}

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(); 
		String email = request.getParameter("login");
		String password = request.getParameter("passwd");
		
		
		try {
			
			Etudiant etudiant = etudiantDao.rechercherEtudiant(email, password);
			
			if( etudiant == null ){
				
				Entreprise entreprise = entrepriseDao.rechercherEntreprise(email, password);
				if( entreprise == null){
					
					Etablissement ecole = ecoleDao.rechercherEcole(email, password);
					
					if( ecole == null ){
					
						request.setAttribute("errorMsg", "Login ou password que vous avez saisi est incorrect.");
						request.getRequestDispatcher("/pages-login.jsp").forward(request, response);
					
					}else{
						
						session.setAttribute("ecoleSess", ecole );
						request.getRequestDispatcher("/WEB-INF/Vue/inscription-Etudiants.jsp").forward(request, response);
					}
				
				}else{
					
					session.setAttribute("entrepriseSess", entreprise );
					request.getRequestDispatcher("/WEB-INF/Vue/profile-entreprise.jsp").forward(request, response);
				}
				
				
				
			}else
			{
				  
				session.setAttribute("candidat", etudiant );
				
				
				if( etudiant.getTel_gsm_etudiant().equals("") ){
					
					request.getRequestDispatcher("/WEB-INF/Vue/etudiant_premier_infos.jsp").forward(request, response);
					
				}else{
					request.getRequestDispatcher("/ProfileCandidat").forward(request, response);
				}
			}
			
			
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
