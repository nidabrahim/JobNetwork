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
import Models.Beans.Message;
import Models.DAO.ClassPrincipal.DaoFactory;
import Models.DAO.Interfaces.EtudiantDao;
import Models.Exceptions.DAOException;

/**
 * Servlet implementation class refraichMsgController
 */
@WebServlet("/refraichMsgController")
public class refraichMsgController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	private EtudiantDao etudiantDao;
	private HttpSession session;
	private Etudiant etudiant;
	private int refContact;
	private List<Message> messages;

	
	
	
	public void init(ServletConfig config) throws ServletException {
		
		try {
			
            DaoFactory daoFactory = DaoFactory.getInstance();
            etudiantDao = daoFactory.getEtudiantDao();
           
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }
		
	}
	
    public refraichMsgController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		session = request.getSession();
		etudiant = (Etudiant) session.getAttribute("candidat");
		refContact = Integer.parseInt(request.getParameter("recepteur"));
		
		try {
			messages = etudiantDao.getMessages(etudiant.getNum_etudiant(), refContact);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		session.setAttribute("messages", messages);
		session.setAttribute("candidat", etudiant);
		
	}

}
