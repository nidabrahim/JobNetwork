package Models.Beans;

public class GestionMajEtudiant {
	
	private Administrateur admin;
	private Etudiant etudiant;
	
	public GestionMajEtudiant(Administrateur admin, Etudiant etudiant) {
		super();
		this.admin = admin;
		this.etudiant = etudiant;
	}

	public Administrateur getAdmin() {
		return admin;
	}

	public void setAdmin(Administrateur admin) {
		this.admin = admin;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	@Override
	public String toString() {
		return "GestionMajEtudiant [admin=" + admin + ", etudiant=" + etudiant + "]";
	}
	
	
	

}
