<%@page import="Models.Beans.Etudiant"%>
<%@page import="Models.Beans.Message"%>
<%@page import="Models.DAO.Interfaces.EtudiantDao"%>
<%@page import="Models.DAO.ClassPrincipal.DaoFactory"%>

<%

		HttpSession s = (HttpSession) request.getSession();
		Etudiant candidat = (Etudiant) s.getAttribute("candidat");
		String msg = request.getParameter("message");
		String commentDate = request.getParameter("fullDate");
		int recepteur = Integer.parseInt(request.getParameter("recepteur"));
		
		DaoFactory daoFactory = DaoFactory.getInstance();
		EtudiantDao etudiantDao = daoFactory.getEtudiantDao();
		
		Message message = new Message();
		message.setDate_msg(commentDate);
		message.setEmetteur(candidat);
		message.setRecepteur(etudiantDao.getEtudiantById(recepteur));
		message.setTexte_msg(msg);
		
		etudiantDao.EnvoyerMsg(message);
		
		
		

%>

<div class="item in item-visible">
  <div class="image">
    <img src="assets/images/users/no-image.jpg" alt="John Doe">
  </div>
  <div class="text">
    <div class="heading">
       <a href="#">${candidat.nom_etudiant } ${candidat.prenom_etudiant }</a>
       <span class="date"><%= commentDate %></span>
    </div>
          <%= msg %>
    </div>
</div>