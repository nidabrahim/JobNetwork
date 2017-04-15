package Controleurs;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
 * Servlet implementation class FirstUpdateProfileController
 */
@WebServlet("/updateInfos")
public class FirstUpdateProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private EtudiantDao etudiantDao;
   
    public FirstUpdateProfileController() {
        super();
        
    }

	
	public void init(ServletConfig config) throws ServletException {
		

		try {
			
            DaoFactory daoFactory = DaoFactory.getInstance();
            etudiantDao = daoFactory.getEtudiantDao();
            
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		Etudiant etudiant = (Etudiant) session.getAttribute("candidat");
		
		/*
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		try {
			date = formatter.parse( request.getParameter("dateNaissance") );
			//System.out.println(formatter.format(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
   
		etudiant.setLogin_etudiant( request.getParameter("email") );
		etudiant.setMot_passe_etudiant(request.getParameter("password"));
		etudiant.setDate_naissance_etudiant(Date.valueOf( request.getParameter("dateNaissance") ));
		etudiant.setTel_fixe_etudiant(request.getParameter("telFixe"));
		etudiant.setTel_gsm_etudiant(request.getParameter("telGsm"));
		etudiant.setCode_postal( Integer.parseInt(request.getParameter("cp")) );
		etudiant.setVille_etudiant(request.getParameter("ville"));
		etudiant.setAdresse_etudiant(request.getParameter("adresse"));
		
		session.setAttribute("candidat", etudiant );
		try {
			etudiantDao.ModifierEtudiant(etudiant);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.getRequestDispatcher("/WEB-INF/Vue/profile-candidat.jsp").forward(request, response);
		
	}

}
