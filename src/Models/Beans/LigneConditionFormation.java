package Models.Beans;

public class LigneConditionFormation {
	
	private CritereFormation crit_formation;
	private Criteres critere;
	private int oblig_formation;
	
	
	public LigneConditionFormation(CritereFormation crit_formation, Criteres critere, int oblig_formation) {
		super();
		this.crit_formation = crit_formation;
		this.critere = critere;
		this.oblig_formation = oblig_formation;
	}


	public CritereFormation getCrit_formation() {
		return crit_formation;
	}


	public void setCrit_formation(CritereFormation crit_formation) {
		this.crit_formation = crit_formation;
	}


	public Criteres getCritere() {
		return critere;
	}


	public void setCritere(Criteres critere) {
		this.critere = critere;
	}


	public int getOblig_formation() {
		return oblig_formation;
	}


	public void setOblig_formation(int oblig_formation) {
		this.oblig_formation = oblig_formation;
	}


	@Override
	public String toString() {
		return "LigneConditionFormation [crit_formation=" + crit_formation + ", critere=" + critere
				+ ", oblig_formation=" + oblig_formation + "]";
	}
	
	
	
	
	

}
