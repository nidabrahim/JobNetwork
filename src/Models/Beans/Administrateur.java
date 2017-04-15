
package Models.Beans;

public class Administrateur {
	
	private int num_admin;
	private String nom_admin;
	private String prenom_admin;
	private String role;
	private String mot_passe_admin;
	private String login_admin;
	
	
	public Administrateur(int num_admin, String nom_admin, String prenom_admin, String role, String mot_passe_admin,
			String login_admin) {
		super();
		this.num_admin = num_admin;
		this.nom_admin = nom_admin;
		this.prenom_admin = prenom_admin;
		this.role = role;
		this.mot_passe_admin = mot_passe_admin;
		this.login_admin = login_admin;
	}


	public int getNum_admin() {
		return num_admin;
	}


	public void setNum_admin(int num_admin) {
		this.num_admin = num_admin;
	}


	public String getNom_admin() {
		return nom_admin;
	}


	public void setNom_admin(String nom_admin) {
		this.nom_admin = nom_admin;
	}


	public String getPrenom_admin() {
		return prenom_admin;
	}


	public void setPrenom_admin(String prenom_admin) {
		this.prenom_admin = prenom_admin;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getMot_passe_admin() {
		return mot_passe_admin;
	}


	public void setMot_passe_admin(String mot_passe_admin) {
		this.mot_passe_admin = mot_passe_admin;
	}


	public String getLogin_admin() {
		return login_admin;
	}


	public void setLogin_admin(String login_admin) {
		this.login_admin = login_admin;
	}


	@Override
	public String toString() {
		return "Administrateur [num_admin=" + num_admin + ", nom_admin=" + nom_admin + ", prenom_admin=" + prenom_admin
				+ ", role=" + role + ", mot_passe_admin=" + mot_passe_admin + ", login_admin=" + login_admin + "]";
	}
	
	
	
	
	

}
