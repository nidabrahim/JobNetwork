package Models.Beans;

public class GestionMajEntreprise {

	private Administrateur admin;
	private Entreprise entreprise;
	
	
	public GestionMajEntreprise(Administrateur admin, Entreprise entreprise) {
		super();
		this.admin = admin;
		this.entreprise = entreprise;
	}


	public Administrateur getAdmin() {
		return admin;
	}


	public void setAdmin(Administrateur admin) {
		this.admin = admin;
	}


	public Entreprise getEntreprise() {
		return entreprise;
	}


	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}


	@Override
	public String toString() {
		return "GestionMajEntreprise [admin=" + admin + ", entreprise=" + entreprise + "]";
	}
	
	
	
}
