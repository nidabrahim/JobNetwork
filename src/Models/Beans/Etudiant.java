package Models.Beans;

import java.util.Date;

public class Etudiant {
	
	private int num_etudiant;
	private String nom_etudiant;
	private String prenom_etudiant;
	private Date date_naissance_etudiant;
	private String email_etudiant;
	private String tel_gsm_etudiant;
	private String tel_fixe_etudiant;
	private String ville_etudiant;
	private int code_postal;
	private String adresse_etudiant;
	private String mot_passe_etudiant;
	private String login_etudiant;
	private Etablissement etablissement;
	
	
	public Etudiant(int num_etudiant, String nom_etudiant, String prenom_etudiant, Date date_naissance_etudiant,
			String email_etudiant, String tel_gsm_etudiant, String tel_fixe_etudiant, String ville_etudiant,
			int code_postal, String adresse_etudiant, String mot_passe_etudiant, String login_etudiant,
			Etablissement etablissement) {
		super();
		this.num_etudiant = num_etudiant;
		this.nom_etudiant = nom_etudiant;
		this.prenom_etudiant = prenom_etudiant;
		this.date_naissance_etudiant = date_naissance_etudiant;
		this.email_etudiant = email_etudiant;
		this.tel_gsm_etudiant = tel_gsm_etudiant;
		this.tel_fixe_etudiant = tel_fixe_etudiant;
		this.ville_etudiant = ville_etudiant;
		this.code_postal = code_postal;
		this.adresse_etudiant = adresse_etudiant;
		this.mot_passe_etudiant = mot_passe_etudiant;
		this.login_etudiant = login_etudiant;
		this.etablissement = etablissement;
	}

    public Etudiant() {
    }


	public int getNum_etudiant() {
		return num_etudiant;
	}


	public void setNum_etudiant(int num_etudiant) {
		this.num_etudiant = num_etudiant;
	}


	public String getNom_etudiant() {
		return nom_etudiant;
	}


	public void setNom_etudiant(String nom_etudiant) {
		this.nom_etudiant = nom_etudiant;
	}


	public String getPrenom_etudiant() {
		return prenom_etudiant;
	}


	public void setPrenom_etudiant(String prenom_etudiant) {
		this.prenom_etudiant = prenom_etudiant;
	}


	public Date getDate_naissance_etudiant() {
		return date_naissance_etudiant;
	}


	public void setDate_naissance_etudiant(Date date_naissance_etudiant) {
		this.date_naissance_etudiant = date_naissance_etudiant;
	}


	public String getEmail_etudiant() {
		return email_etudiant;
	}


	public void setEmail_etudiant(String email_etudiant) {
		this.email_etudiant = email_etudiant;
	}


	public String getTel_gsm_etudiant() {
		return tel_gsm_etudiant;
	}


	public void setTel_gsm_etudiant(String tel_gsm_etudiant) {
		this.tel_gsm_etudiant = tel_gsm_etudiant;
	}


	public String getTel_fixe_etudiant() {
		return tel_fixe_etudiant;
	}


	public void setTel_fixe_etudiant(String tel_fixe_etudiant) {
		this.tel_fixe_etudiant = tel_fixe_etudiant;
	}


	public String getVille_etudiant() {
		return ville_etudiant;
	}


	public void setVille_etudiant(String ville_etudiant) {
		this.ville_etudiant = ville_etudiant;
	}


	public int getCode_postal() {
		return code_postal;
	}


	public void setCode_postal(int code_postal) {
		this.code_postal = code_postal;
	}


	public String getAdresse_etudiant() {
		return adresse_etudiant;
	}


	public void setAdresse_etudiant(String adresse_etudiant) {
		this.adresse_etudiant = adresse_etudiant;
	}


	public String getMot_passe_etudiant() {
		return mot_passe_etudiant;
	}


	public void setMot_passe_etudiant(String mot_passe_etudiant) {
		this.mot_passe_etudiant = mot_passe_etudiant;
	}


	public String getLogin_etudiant() {
		return login_etudiant;
	}


	public void setLogin_etudiant(String login_etudiant) {
		this.login_etudiant = login_etudiant;
	}


	public Etablissement getEtablissement() {
		return etablissement;
	}


	public void setEtablissement(Etablissement etablissement) {
		this.etablissement = etablissement;
	}


	@Override
	public String toString() {
		return "Etudiant [num_etudiant=" + num_etudiant + ", nom_etudiant=" + nom_etudiant + ", prenom_etudiant="
				+ prenom_etudiant + ", email_etudiant=" + email_etudiant + ", tel_gsm_etudiant=" + tel_gsm_etudiant
				+ ", tel_fixe_etudiant=" + tel_fixe_etudiant + ", ville_etudiant=" + ville_etudiant + ", code_postal="
				+ code_postal + ", adresse_etudiant=" + adresse_etudiant + ", mot_passe_etudiant=" + mot_passe_etudiant
				+ ", login_etudiant=" + login_etudiant + ", etablissement=" + etablissement + "]";
	}
	
	
	
	
	
	



}
