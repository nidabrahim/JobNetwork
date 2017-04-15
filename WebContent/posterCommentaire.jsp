
<%
/*
	HttpSession s = (HttpSession) request.getSession();
	Etudiant candidat = (Etudiant) s.getAttribute("candidat");
	String comment = request.getParameter("comment");
	String commentDate = request.getParameter("fullDate");
	int refOffre = Integer.parseInt(request.getParameter("refOffre"));
	
	DaoFactory daoFactory = DaoFactory.getInstance();
	EtudiantDao etudiantDao = daoFactory.getEtudiantDao();
	
	Commentaire commentaire = new Commentaire();
	commentaire.setText_com(comment);
	commentaire.setCandidat(candidat);
	commentaire.setDate_com(commentDate);
	commentaire.setOffre(refOffre);
	
	etudiantDao.PosterCommentaire(commentaire);
	
*/
%>



<li class="media">
      <a class="pull-left" href="#">
      	<img class="media-object img-text" src="assets/images/users/no-image.jpg" alt="Samuel Leroy Jackson" width="64">
      </a>
      <div class="media-body">
         <h4 class="media-heading">${ candidat.nom_etudiant } ${ candidat.prenom_etudiant }</h4>
         <p>${comment}</p>
         <p class="text-muted">${commentDate}</p>
                                                                                                                                          
      </div>
</li>