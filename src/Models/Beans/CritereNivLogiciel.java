package Models.Beans;

public class CritereNivLogiciel {
	
	private int num_critere_niv_logiciel;
	private String critere_libele_niv_logiciel;
	
	
	public CritereNivLogiciel(int num_critere_niv_logiciel, String critere_libele_niv_logiciel) {
		super();
		this.num_critere_niv_logiciel = num_critere_niv_logiciel;
		this.critere_libele_niv_logiciel = critere_libele_niv_logiciel;
	}


	public int getNum_critere_niv_logiciel() {
		return num_critere_niv_logiciel;
	}


	public void setNum_critere_niv_logiciel(int num_critere_niv_logiciel) {
		this.num_critere_niv_logiciel = num_critere_niv_logiciel;
	}


	public String getCritere_libele_niv_logiciel() {
		return critere_libele_niv_logiciel;
	}


	public void setCritere_libele_niv_logiciel(String critere_libele_niv_logiciel) {
		this.critere_libele_niv_logiciel = critere_libele_niv_logiciel;
	}


	@Override
	public String toString() {
		return "CritereNivLogiciel [num_critere_niv_logiciel=" + num_critere_niv_logiciel
				+ ", critere_libele_niv_logiciel=" + critere_libele_niv_logiciel + "]";
	}
	
	
	

}
