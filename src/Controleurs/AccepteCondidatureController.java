package Controleurs;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.DAO.ClassPrincipal.DaoFactory;
import Models.DAO.Interfaces.EntrepriseDao;
import Models.Exceptions.DAOException;


@WebServlet("/AccepteCondidature")
public class AccepteCondidatureController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private EntrepriseDao entrepriseDao;
	
	public void init(ServletConfig config) throws ServletException {
		
		try {
			
            DaoFactory daoFactory = DaoFactory.getInstance();
            entrepriseDao =  daoFactory.getEntrepriseDao();
            
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }
		
	}
    
    public AccepteCondidatureController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int codeEtd = Integer.parseInt(request.getParameter("idEtd"));
		int codeStg = Integer.parseInt(request.getParameter("idOffre"));
		String msg = request.getParameter("msgAccept");
		
		try {
			entrepriseDao.sendMsgCandidature(codeEtd, codeStg, msg);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.getRequestDispatcher("/Candidatures").forward(request, response);
	}

}
