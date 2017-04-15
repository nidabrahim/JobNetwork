package Models.Beans;

import java.util.Date;

public class LignePostul {
	
	private Etudiant etudiant;
	private OffreDeStage stage;
	private Date date_disponibilite;
	private String lettre_motivation;
	private int validation;
	private String message;
	
	
	public LignePostul(Etudiant etudiant, OffreDeStage stage, Date date_disponibilite, String lettre_motivation,
			int validation , String message) {
		super();
		this.etudiant = etudiant;
		this.stage = stage;
		this.date_disponibilite = date_disponibilite;
		this.lettre_motivation = lettre_motivation;
		this.validation = validation;
		this.message = message;
	}



	public LignePostul() {
		// TODO Auto-generated constructor stub
	}

	
	

	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public Etudiant getEtudiant() {
		return etudiant;
	}


	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}


	public OffreDeStage getStage() {
		return stage;
	}


	public void setStage(OffreDeStage stage) {
		this.stage = stage;
	}


	public Date getDate_disponibilite() {
		return date_disponibilite;
	}


	public void setDate_disponibilite(Date date_disponibilite) {
		this.date_disponibilite = date_disponibilite;
	}


	public String getLettre_motivation() {
		return lettre_motivation;
	}


	public void setLettre_motivation(String lettre_motivation) {
		this.lettre_motivation = lettre_motivation;
	}


	public int getValidation() {
		return validation;
	}


	public void setValidation(int validation) {
		this.validation = validation;
	}


	@Override
	public String toString() {
		return "LignePostul [etudiant=" + etudiant + ", stage=" + stage + ", date_disponibilite=" + date_disponibilite
				+ ", lettre_motivation=" + lettre_motivation + ", validation=" + validation + "]";
	}
	
	
	
}
