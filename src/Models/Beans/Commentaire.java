package Models.Beans;


public class Commentaire {
	
	private int num_com;
	private int offre;
	private Etudiant candidat;
	private String date_com;
	private String text_com;
	
	public Commentaire(){}
	
	public Commentaire(int num_com, int offre, Etudiant candidat, String date_com, String text_com) {
		super();
		this.num_com = num_com;
		this.offre = offre;
		this.candidat = candidat;
		this.date_com = date_com;
		this.text_com = text_com;
	}

	public int getNum_com() {
		return num_com;
	}

	public void setNum_com(int num_com) {
		this.num_com = num_com;
	}

	public int getOffre() {
		return offre;
	}

	public void setOffre(int offre) {
		this.offre = offre;
	}

	public Etudiant getCandidat() {
		return candidat;
	}

	public void setCandidat(Etudiant candidat) {
		this.candidat = candidat;
	}

	public String getDate_com() {
		return date_com;
	}

	public void setDate_com(String date_com) {
		this.date_com = date_com;
	}

	public String getText_com() {
		return text_com;
	}

	public void setText_com(String text_com) {
		this.text_com = text_com;
	}
	
	
	
	
	
	
	

}
