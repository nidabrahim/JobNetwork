package Controleurs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Models.Beans.Formation;
import Models.Beans.LigneConditionLangue;
import Models.Beans.LigneConditionLogiciel;
import Models.Beans.LigneFormation;


@WebServlet("/Ajout_offre")
public class Ajout_offreRedirection extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HttpSession session;
	private List<LigneConditionLogiciel> listeCritereLog;
	private List<LigneFormation> listeCritereForm;
	private List<LigneConditionLangue> listeCritereLang;
       
   
    public Ajout_offreRedirection() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Instanciation des listes de criteres
		getModeles();
		
		//L'envoie par sessions
		session = request.getSession();
		sendModeles();
		
		request.getRequestDispatcher("/WEB-INF/Vue/entreprise_ajout_offre.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	private void getModeles(){
		
		listeCritereLog = new ArrayList<LigneConditionLogiciel>();
		listeCritereForm = new ArrayList<LigneFormation>();
		listeCritereLang = new ArrayList<LigneConditionLangue>();
		
	}
	
	
	private void sendModeles(){
		
		
		if( session.getAttribute("listeCritereLog") != null ){
			session.removeAttribute("listeCritereLog");
		}
		if( session.getAttribute("listeCritereForm") != null ){
			session.removeAttribute("listeCritereForm");
		}
		if( session.getAttribute("listeCritereLang") != null ){
			session.removeAttribute("listeCritereLang");
		}
		session.setAttribute("listeCritereLog", listeCritereLog );
		session.setAttribute("listeCritereForm", listeCritereForm );
		session.setAttribute("listeCritereLang", listeCritereLang );
		
		
	}

}
