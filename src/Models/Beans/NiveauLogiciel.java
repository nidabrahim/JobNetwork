package Models.Beans;

public class NiveauLogiciel {
	
	private int num_niv_logiciel;
	private String libele_logiciel;
	
	
	public NiveauLogiciel(int num_niv_logiciel, String libele_logiciel) {
		super();
		this.num_niv_logiciel = num_niv_logiciel;
		this.libele_logiciel = libele_logiciel;
	}


	public NiveauLogiciel() {
		// TODO Auto-generated constructor stub
	}


	public int getNum_niv_logiciel() {
		return num_niv_logiciel;
	}


	public void setNum_niv_logiciel(int num_niv_logiciel) {
		this.num_niv_logiciel = num_niv_logiciel;
	}


	public String getLibele_logiciel() {
		return libele_logiciel;
	}


	public void setLibele_logiciel(String libele_logiciel) {
		this.libele_logiciel = libele_logiciel;
	}


	@Override
	public String toString() {
		return "NiveauLogiciel [num_niv_logiciel=" + num_niv_logiciel + ", libele_logiciel=" + libele_logiciel + "]";
	}
	
	

}
