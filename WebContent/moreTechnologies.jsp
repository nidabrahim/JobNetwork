<%@page import="java.util.ArrayList"%>
<%@page import="Models.Beans.LigneConditionLogiciel"%>
<%@page import="Models.Beans.CritereLogiciel"%>

<%
		int numLogiciel = Integer.parseInt(request.getParameter("numlog"));
		int oblig = Integer.parseInt(request.getParameter("oblig"));
		
		HttpSession s = request.getSession();
		ArrayList<LigneConditionLogiciel> listeCritereLog = (ArrayList<LigneConditionLogiciel>) s.getAttribute("listeCritereLog");
		
		CritereLogiciel c_log = new CritereLogiciel();
		c_log.setNum_critere_logiciel(numLogiciel);
		
		LigneConditionLogiciel ligne_c_log = new LigneConditionLogiciel();
		ligne_c_log.setCritere_logiciel(c_log);
		ligne_c_log.setOblig_logiciel(oblig);
		
		
		ArrayList<LigneConditionLogiciel> listeLog = new ArrayList<LigneConditionLogiciel>();
	     
        if( listeCritereLog.size() != 0 ) { 
    
            for(LigneConditionLogiciel x : listeCritereLog){ listeLog.add(x); }
        }
		
        listeLog.add( ligne_c_log );
		
        
		s.setAttribute("listeCritereLog",listeLog);

%>
									
