<%@page import="java.util.ArrayList"%>
<%@page import="Models.Beans.Formation"%>
<%@page import="Models.Beans.CritereLogiciel"%>

<%
		String formation = request.getParameter("formation");
		String type = request.getParameter("type");
		String domaine = request.getParameter("domaine");
		
		HttpSession s = request.getSession();
		ArrayList<Formation> formations = (ArrayList<Formation>) s.getAttribute("listeCritereForm");
		
		Formation c_formation = new Formation();
			c_formation.setDomaine_formation(domaine);
			c_formation.setLibele_formation(formation);
			c_formation.setType_formation(type);
		
		
		ArrayList<Formation> listeFormation = new ArrayList<Formation>();
	     
        if( formations.size() != 0 ) { 
    
            for(Formation x : formations){ listeFormation.add(x); }
        }
		
        listeFormation.add( c_formation );
		
        
		s.setAttribute("listeCritereForm",listeFormation);

%>
									
