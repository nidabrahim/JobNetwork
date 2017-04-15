package Models.Beans;

public class CritereNivLangue {
	
	private int num_critere_niv_langue;
	private String critere_libele_niv_langue;
	
	
	public CritereNivLangue(int num_critere_niv_langue, String critere_libele_niv_langue) {
		super();
		this.num_critere_niv_langue = num_critere_niv_langue;
		this.critere_libele_niv_langue = critere_libele_niv_langue;
	}


	public int getNum_critere_niv_langue() {
		return num_critere_niv_langue;
	}


	public void setNum_critere_niv_langue(int num_critere_niv_langue) {
		this.num_critere_niv_langue = num_critere_niv_langue;
	}


	public String getCritere_libele_niv_langue() {
		return critere_libele_niv_langue;
	}


	public void setCritere_libele_niv_langue(String critere_libele_niv_langue) {
		this.critere_libele_niv_langue = critere_libele_niv_langue;
	}


	@Override
	public String toString() {
		return "CritereNivLangue [num_critere_niv_langue=" + num_critere_niv_langue + ", critere_libele_niv_langue="
				+ critere_libele_niv_langue + "]";
	}
	
	

}
