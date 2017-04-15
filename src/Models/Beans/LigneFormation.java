package Models.Beans;

public class LigneFormation {
	
	
	private Formation formation;
	private Etudiant etudiant;
	private String annee_de_diplome;
	
	
	public LigneFormation(Formation formation, Etudiant etudiant, String annee_de_diplome) {
		super();
		this.formation = formation;
		this.etudiant = etudiant;
		this.annee_de_diplome = annee_de_diplome;
	}


	public Formation getFormation() {
		return formation;
	}


	public void setFormation(Formation formation) {
		this.formation = formation;
	}


	public Etudiant getEtudiant() {
		return etudiant;
	}


	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}


	public String getAnnee_de_diplome() {
		return annee_de_diplome;
	}


	public void setAnnee_de_diplome(String annee_de_diplome) {
		this.annee_de_diplome = annee_de_diplome;
	}


	@Override
	public String toString() {
		return "LigneFormation [formation=" + formation + ", etudiant=" + etudiant + ", annee_de_diplome="
				+ annee_de_diplome + "]";
	}
	
	
	

}
