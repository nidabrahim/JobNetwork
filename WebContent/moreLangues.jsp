<%@page import="java.util.ArrayList"%>
<%@page import="Models.Beans.LigneConditionLangue"%>
<%@page import="Models.Beans.CritereLangue"%>

<%
		int numLang = Integer.parseInt(request.getParameter("numlang"));
		int oblig = Integer.parseInt(request.getParameter("oblig"));
		
		HttpSession s = request.getSession();
		ArrayList<LigneConditionLangue> listeCritereLang = (ArrayList<LigneConditionLangue>) s.getAttribute("listeCritereLang");
		
		CritereLangue c_lang = new CritereLangue();
		c_lang.setNum_critere_langue(numLang);
		
		LigneConditionLangue ligne_c_lang = new LigneConditionLangue();
		ligne_c_lang.setCritere_langue(c_lang);
		ligne_c_lang.setOblig_langue(oblig);
		
		
		ArrayList<LigneConditionLangue> listeLang = new ArrayList<LigneConditionLangue>();
	     
        if( listeCritereLang.size() != 0 ) { 
    
            for(LigneConditionLangue x : listeCritereLang){ listeLang.add(x); }
        }
		
        listeLang.add( ligne_c_lang );
		
        
		s.setAttribute("listeCritereLang",listeLang);

%>
									
