package Models.Beans;

public class RaisonDepart {
	
	private int num_raisonDepart;
	private ExperiencePro experiencePro;
	private String libele_raison_depart;
	
	
	public RaisonDepart(int num_raisonDepart, ExperiencePro experiencePro, String libele_raison_depart) {
		super();
		this.num_raisonDepart = num_raisonDepart;
		this.experiencePro = experiencePro;
		this.libele_raison_depart = libele_raison_depart;
	}


	public int getNum_raisonDepart() {
		return num_raisonDepart;
	}


	public void setNum_raisonDepart(int num_raisonDepart) {
		this.num_raisonDepart = num_raisonDepart;
	}


	public ExperiencePro getExperiencePro() {
		return experiencePro;
	}


	public void setExperiencePro(ExperiencePro experiencePro) {
		this.experiencePro = experiencePro;
	}


	public String getLibele_raison_depart() {
		return libele_raison_depart;
	}


	public void setLibele_raison_depart(String libele_raison_depart) {
		this.libele_raison_depart = libele_raison_depart;
	}


	@Override
	public String toString() {
		return "RaisonDepart [num_raisonDepart=" + num_raisonDepart + ", experiencePro=" + experiencePro
				+ ", libele_raison_depart=" + libele_raison_depart + "]";
	}
	
	

}
