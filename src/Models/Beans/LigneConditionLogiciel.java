package Models.Beans;

public class LigneConditionLogiciel {
	
	private Criteres critere;
	private CritereLogiciel critere_logiciel;
	private CritereNivLogiciel critere_niv_logiciel;
	private int oblig_logiciel;
	
	
	
	
	public LigneConditionLogiciel() {
		super();
	}


	public LigneConditionLogiciel(Criteres critere, CritereLogiciel critere_logiciel,
			CritereNivLogiciel critere_niv_logiciel, int oblig_logiciel) {
		super();
		this.critere = critere;
		this.critere_logiciel = critere_logiciel;
		this.critere_niv_logiciel = critere_niv_logiciel;
		this.oblig_logiciel = oblig_logiciel;
	}


	public Criteres getCritere() {
		return critere;
	}


	public void setCritere(Criteres critere) {
		this.critere = critere;
	}


	public CritereLogiciel getCritere_logiciel() {
		return critere_logiciel;
	}


	public void setCritere_logiciel(CritereLogiciel critere_logiciel) {
		this.critere_logiciel = critere_logiciel;
	}


	public CritereNivLogiciel getCritere_niv_logiciel() {
		return critere_niv_logiciel;
	}


	public void setCritere_niv_logiciel(CritereNivLogiciel critere_niv_logiciel) {
		this.critere_niv_logiciel = critere_niv_logiciel;
	}


	public int getOblig_logiciel() {
		return oblig_logiciel;
	}


	public void setOblig_logiciel(int oblig_logiciel) {
		this.oblig_logiciel = oblig_logiciel;
	}


	@Override
	public String toString() {
		return "LigneConditionLogiciel [critere=" + critere + ", critere_logiciel=" + critere_logiciel
				+ ", critere_niv_logiciel=" + critere_niv_logiciel + ", oblig_logiciel=" + oblig_logiciel + "]";
	}
	
	
	

}
