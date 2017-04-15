package Models.Beans;

public class CritereLogiciel {
	
	private int num_critere_logiciel;
	private String critere_libele_logiciel;
	
	
	
	
	public CritereLogiciel() {
		super();
	}


	public CritereLogiciel(int num_critere_logiciel, String critere_libele_logiciel) {
		super();
		this.num_critere_logiciel = num_critere_logiciel;
		this.critere_libele_logiciel = critere_libele_logiciel;
	}


	public int getNum_critere_logiciel() {
		return num_critere_logiciel;
	}


	public void setNum_critere_logiciel(int num_critere_logiciel) {
		this.num_critere_logiciel = num_critere_logiciel;
	}


	public String getCritere_libele_logiciel() {
		return critere_libele_logiciel;
	}


	public void setCritere_libele_logiciel(String critere_libele_logiciel) {
		this.critere_libele_logiciel = critere_libele_logiciel;
	}


	@Override
	public String toString() {
		return "CritereLogiciel [num_critere_logiciel=" + num_critere_logiciel + ", critere_libele_logiciel="
				+ critere_libele_logiciel + "]";
	}
	
	
	
	
}
