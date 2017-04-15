package Models.Beans;

public class GestionMajEtablissement {
	
	private Etablissement etablissement;
	private Administrateur admin;
	
	
	public GestionMajEtablissement(Etablissement etablissement, Administrateur admin) {
		super();
		this.etablissement = etablissement;
		this.admin = admin;
	}


	public Etablissement getEtablissement() {
		return etablissement;
	}


	public void setEtablissement(Etablissement etablissement) {
		this.etablissement = etablissement;
	}


	public Administrateur getAdmin() {
		return admin;
	}


	public void setAdmin(Administrateur admin) {
		this.admin = admin;
	}


	@Override
	public String toString() {
		return "GestionMajEtablissement [etablissement=" + etablissement + ", admin=" + admin + "]";
	}
	
	
	

}
