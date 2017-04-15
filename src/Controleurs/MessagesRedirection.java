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
 * Servlet implementation class MessagesRedirection
 */
@WebServlet("/Messages")
public class MessagesRedirection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private EtudiantDao etudiantDao;
	private HttpSession session;
	private Etudiant etudiant;
	private List<Message> messages;
	private List<Message> lastMessages;
	
	
	
	public void init(ServletConfig config) throws ServletException {
		
		try {
			
            DaoFactory daoFactory = DaoFactory.getInstance();
            etudiantDao = daoFactory.getEtudiantDao();
           
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }
		
	}
	
	
    public MessagesRedirection() {
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
			lastMessages = etudiantDao.getLastMessages(etudiant.getNum_etudiant());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		try {
			messages = etudiantDao.getMessages(etudiant.getNum_etudiant(), lastMessages.get(lastMessages.size()-1).getEmetteur().getNum_etudiant());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.setAttribute("messages", messages);
		request.setAttribute("lastMessages", lastMessages);
		request.setAttribute("refLastRecepteur", lastMessages.get(lastMessages.size()-1).getEmetteur().getNum_etudiant());
		
		request.getRequestDispatcher("/WEB-INF/Vue/messages.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
