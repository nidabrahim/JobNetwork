package Models.Beans;

public class OffreDeStage {
	
	
	private int num_stage;
	private Entreprise entreprise;
	private String intitule_du_stage;
	private String description;
	
	
	public OffreDeStage(int num_stage, Entreprise entreprise, String intitule_du_stage, String description) {
		super();
		this.num_stage = num_stage;
		this.entreprise = entreprise;
		this.intitule_du_stage = intitule_du_stage;
		this.description = description;
	}

    public OffreDeStage() {
    }


	public int getNum_stage() {
		return num_stage;
	}


	public void setNum_stage(int num_stage) {
		this.num_stage = num_stage;
	}


	public Entreprise getEntreprise() {
		return entreprise;
	}


	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}


	public String getIntitule_du_stage() {
		return intitule_du_stage;
	}


	public void setIntitule_du_stage(String intitule_du_stage) {
		this.intitule_du_stage = intitule_du_stage;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "OffreDeStage [num_stage=" + num_stage + ", entreprise=" + entreprise + ", intitule_du_stage="
				+ intitule_du_stage + ", description=" + description + "]";
	}
	
	
	
	
}
