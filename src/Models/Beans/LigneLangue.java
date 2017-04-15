package Models.Beans;

public class LigneLangue {
	
	
	private Etudiant etudiant;
	private Langue langue;
	private Niveaulangue niv_langue;
	
	
	public LigneLangue(Etudiant etudiant, Langue langue, Niveaulangue niv_langue) {
		super();
		this.etudiant = etudiant;
		this.langue = langue;
		this.niv_langue = niv_langue;
	}


	public LigneLangue() {
		super();
	}


	public Etudiant getEtudiant() {
		return etudiant;
	}


	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}


	public Langue getLangue() {
		return langue;
	}


	public void setLangue(Langue langue) {
		this.langue = langue;
	}


	public Niveaulangue getNiv_langue() {
		return niv_langue;
	}


	public void setNiv_langue(Niveaulangue niv_langue) {
		this.niv_langue = niv_langue;
	}


	@Override
	public String toString() {
		return "LigneLangue [etudiant=" + etudiant + ", langue=" + langue + ", niv_langue=" + niv_langue + "]";
	}
	
	

}
