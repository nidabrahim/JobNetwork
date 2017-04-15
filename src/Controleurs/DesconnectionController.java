package Controleurs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/Desconnection")
public class DesconnectionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private HttpSession session;
   
    public DesconnectionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		session = request.getSession(); 
		
		if( session.getAttribute("ecoleSess") != null )
			session.removeAttribute("ecoleSess");
			
		if( session.getAttribute("entrepriseSess") != null )
			session.removeAttribute("entrepriseSess");
			
		if( session.getAttribute("candidat") != null )
			session.removeAttribute("candidat");
		
		session.invalidate();
		
		request.getRequestDispatcher("pages-login.jsp").forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
