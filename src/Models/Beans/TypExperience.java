package Models.Beans;

public class TypExperience {
	
	private int num_type_experience;
	private ExperiencePro experiencePro;
	private String libeleTypeExperience;
	
	
	public TypExperience(int num_type_experience, ExperiencePro experiencePro, String libeleTypeExperience) {
		super();
		this.num_type_experience = num_type_experience;
		this.experiencePro = experiencePro;
		this.libeleTypeExperience = libeleTypeExperience;
	}


	public int getNum_type_experience() {
		return num_type_experience;
	}


	public void setNum_type_experience(int num_type_experience) {
		this.num_type_experience = num_type_experience;
	}


	public ExperiencePro getExperiencePro() {
		return experiencePro;
	}


	public void setExperiencePro(ExperiencePro experiencePro) {
		this.experiencePro = experiencePro;
	}


	public String getLibeleTypeExperience() {
		return libeleTypeExperience;
	}


	public void setLibeleTypeExperience(String libeleTypeExperience) {
		this.libeleTypeExperience = libeleTypeExperience;
	}


	@Override
	public String toString() {
		return "TypExperience [num_type_experience=" + num_type_experience + ", experiencePro=" + experiencePro
				+ ", libeleTypeExperience=" + libeleTypeExperience + "]";
	}
	
	
	

}
