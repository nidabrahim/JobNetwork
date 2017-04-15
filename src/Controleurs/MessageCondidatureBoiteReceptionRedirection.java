package Controleurs;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Beans.LignePostul;
import Models.DAO.ClassPrincipal.DaoFactory;
import Models.DAO.Interfaces.EntrepriseDao;
import Models.DAO.Interfaces.EtudiantDao;
import Models.Exceptions.DAOException;

/**
 * Servlet implementation class MessageCondidatureBoiteReceptionRedirection
 */
@WebServlet("/MessageCondidatureBoiteReception")
public class MessageCondidatureBoiteReceptionRedirection extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EntrepriseDao entrepriseDao;
	private EtudiantDao etudiantDao;
	private LignePostul postula;
	private int nbrpostul;
	private int nbrpostulAccept;
	private int nbrpostulRefus;
       
	public void init(ServletConfig config) throws ServletException {
		
		try {
			
            DaoFactory daoFactory = DaoFactory.getInstance();
            entrepriseDao = daoFactory.getEntrepriseDao();
            etudiantDao = daoFactory.getEtudiantDao();
            
           
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }
		
	}
    

    public MessageCondidatureBoiteReceptionRedirection() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int codeEtd = Integer.parseInt(request.getParameter("idEtd"));
		int codeStg = Integer.parseInt(request.getParameter("idStg"));
		
		try {
			postula = entrepriseDao.getPostulaByCandidatAndOffre(codeEtd , codeStg);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			nbrpostul = etudiantDao.count_postulation(codeEtd);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			nbrpostulAccept = etudiantDao.count_postulation_accept(codeEtd);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			nbrpostulRefus = etudiantDao.count_postulation_refus(codeEtd);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("postula", postula);
		request.setAttribute("nbrpostul", nbrpostul);
		request.setAttribute("nbrpostulAccept", nbrpostulAccept);
		request.setAttribute("nbrpostulRefus", nbrpostulRefus);
		
		request.getRequestDispatcher("/WEB-INF/Vue/boite-reception-message.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
