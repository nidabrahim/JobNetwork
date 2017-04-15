package Controleurs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Beans.Etablissement;
import Models.DAO.ClassPrincipal.DaoFactory;
import Models.DAO.Interfaces.EcoleDao;
import Models.Exceptions.DAOException;

/**
 * Servlet implementation class test
 */
@WebServlet("/test")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EcoleDao ecoleDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
        super.init(); 
             /* Récupération d'une instance de notre DAO  */
        try {
            DaoFactory daoFactory = DaoFactory.getInstance();
            ecoleDao = daoFactory.getEcoleDao();
            System.out.println("merci");
        } catch (Exception e) {
            System.out.println("merci c nn");
            System.out.println(e.getMessage());
        }
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Etablissement etab = new Etablissement();
		etab.setNum_etablissement(1);
			
		try {
			System.out.println(ecoleDao.afficherTousLesEtudiants(etab).size());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
