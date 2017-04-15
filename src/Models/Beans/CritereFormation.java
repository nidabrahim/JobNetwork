package Models.Beans;

public class CritereFormation {
	
	private int num_crit_formation;
	private String crit_type_formation;
	private String crit_libele_formation;
	private String crit_domaine_formation;
	
	
	public CritereFormation(int num_crit_formation, String crit_type_formation, String crit_libele_formation,
			String crit_domaine_formation) {
		super();
		this.num_crit_formation = num_crit_formation;
		this.crit_type_formation = crit_type_formation;
		this.crit_libele_formation = crit_libele_formation;
		this.crit_domaine_formation = crit_domaine_formation;
	}


	public int getNum_crit_formation() {
		return num_crit_formation;
	}


	public void setNum_crit_formation(int num_crit_formation) {
		this.num_crit_formation = num_crit_formation;
	}


	public String getCrit_type_formation() {
		return crit_type_formation;
	}


	public void setCrit_type_formation(String crit_type_formation) {
		this.crit_type_formation = crit_type_formation;
	}


	public String getCrit_libele_formation() {
		return crit_libele_formation;
	}


	public void setCrit_libele_formation(String crit_libele_formation) {
		this.crit_libele_formation = crit_libele_formation;
	}


	public String getCrit_domaine_formation() {
		return crit_domaine_formation;
	}


	public void setCrit_domaine_formation(String crit_domaine_formation) {
		this.crit_domaine_formation = crit_domaine_formation;
	}


	@Override
	public String toString() {
		return "CritereFormation [num_crit_formation=" + num_crit_formation + ", crit_type_formation="
				+ crit_type_formation + ", crit_libele_formation=" + crit_libele_formation + ", crit_domaine_formation="
				+ crit_domaine_formation + "]";
	}
	
	
	

}
