package Models.Beans;

public class CritereLangue {
	
	private int num_critere_langue;
	private String critere_libele_langue;
	
	
	
	
	
	public CritereLangue() {
		super();
	}


	public CritereLangue(int num_critere_langue, String critere_libele_langue) {
		super();
		this.num_critere_langue = num_critere_langue;
		this.critere_libele_langue = critere_libele_langue;
	}


	public int getNum_critere_langue() {
		return num_critere_langue;
	}


	public void setNum_critere_langue(int num_critere_langue) {
		this.num_critere_langue = num_critere_langue;
	}


	public String getCritere_libele_langue() {
		return critere_libele_langue;
	}


	public void setCritere_libele_langue(String critere_libele_langue) {
		this.critere_libele_langue = critere_libele_langue;
	}


	@Override
	public String toString() {
		return "CritereLangue [num_critere_langue=" + num_critere_langue + ", critere_libele_langue="
				+ critere_libele_langue + "]";
	}
	
	

}
