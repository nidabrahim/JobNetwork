package Models.Beans;

public class LigneConditionLangue {
	
	private Criteres critere;
	private CritereLangue critere_langue;
	private CritereNivLangue citere_niv_langue;
	private int oblig_langue;
	
	
	
	
	public LigneConditionLangue() {
		super();
	}


	public LigneConditionLangue(Criteres critere, CritereLangue critere_langue, CritereNivLangue citere_niv_langue,
			int oblig_langue) {
		super();
		this.critere = critere;
		this.critere_langue = critere_langue;
		this.citere_niv_langue = citere_niv_langue;
		this.oblig_langue = oblig_langue;
	}


	public Criteres getCritere() {
		return critere;
	}


	public void setCritere(Criteres critere) {
		this.critere = critere;
	}


	public CritereLangue getCritere_langue() {
		return critere_langue;
	}


	public void setCritere_langue(CritereLangue critere_langue) {
		this.critere_langue = critere_langue;
	}


	public CritereNivLangue getCitere_niv_langue() {
		return citere_niv_langue;
	}


	public void setCitere_niv_langue(CritereNivLangue citere_niv_langue) {
		this.citere_niv_langue = citere_niv_langue;
	}


	public int getOblig_langue() {
		return oblig_langue;
	}


	public void setOblig_langue(int oblig_langue) {
		this.oblig_langue = oblig_langue;
	}


	@Override
	public String toString() {
		return "LigneConditionLangue [critere=" + critere + ", critere_langue=" + critere_langue
				+ ", citere_niv_langue=" + citere_niv_langue + ", oblig_langue=" + oblig_langue + "]";
	}
	
	
	
	

}
