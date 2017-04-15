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
 * Servlet implementation class MessagesContactController
 */
@WebServlet("/MessagesContact")
public class MessagesContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private EtudiantDao etudiantDao;
	private HttpSession session;
	private Etudiant etudiant;
	private int refContact;
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
    
    public MessagesContactController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		session = request.getSession();
		etudiant = (Etudiant) session.getAttribute("candidat");
		refContact = Integer.parseInt(request.getParameter("refContact"));
		
		try {
			lastMessages = etudiantDao.getLastMessages(etudiant.getNum_etudiant());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		try {
			messages = etudiantDao.getMessages(etudiant.getNum_etudiant(), refContact);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.setAttribute("messages", messages);
		request.setAttribute("lastMessages", lastMessages);
		request.setAttribute("refLastRecepteur", refContact );
		
		request.getRequestDispatcher("/WEB-INF/Vue/messages.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		session = (HttpSession) request.getSession();
		etudiant = (Etudiant) session.getAttribute("candidat");
		String msg = request.getParameter("message");
		String commentDate = request.getParameter("fullDate");
		int recepteur = Integer.parseInt(request.getParameter("recepteur"));
		

		Message message = new Message();
		message.setDate_msg(commentDate);
		message.setEmetteur(etudiant);
		try {
			message.setRecepteur(etudiantDao.getEtudiantById(recepteur));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		message.setTexte_msg(msg);
		
		try {
			etudiantDao.EnvoyerMsg(message);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
