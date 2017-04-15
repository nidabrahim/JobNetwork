package Models.Beans;

public class LigneLogiciel {
	
	private Etudiant etudiant;
	private Logiciel logiciel;
	private NiveauLogiciel niv_logiciel;
	
	
	public LigneLogiciel(Etudiant etudiant, Logiciel logiciel, NiveauLogiciel niv_logiciel) {
		super();
		this.etudiant = etudiant;
		this.logiciel = logiciel;
		this.niv_logiciel = niv_logiciel;
	}


	public Etudiant getEtudiant() {
		return etudiant;
	}


	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}


	public Logiciel getLogiciel() {
		return logiciel;
	}


	public void setLogiciel(Logiciel logiciel) {
		this.logiciel = logiciel;
	}


	public NiveauLogiciel getNiv_logiciel() {
		return niv_logiciel;
	}


	public void setNiv_logiciel(NiveauLogiciel niv_logiciel) {
		this.niv_logiciel = niv_logiciel;
	}


	@Override
	public String toString() {
		return "LigneLogiciel [etudiant=" + etudiant + ", logiciel=" + logiciel + ", niv_logiciel=" + niv_logiciel
				+ "]";
	}
	
	

}
