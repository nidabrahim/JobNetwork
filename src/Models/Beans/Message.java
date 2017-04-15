package Models.Beans;

public class Message {
	
	private int n_msg;
	private Etudiant recepteur;
	private Etudiant emetteur;
	private String date_msg;
	private String texte_msg;
	
	public Message(){}

	public Message(int n_msg, Etudiant recepteur, Etudiant emetteur, String date_msg, String texte_msg) {
		super();
		this.n_msg = n_msg;
		this.recepteur = recepteur;
		this.emetteur = emetteur;
		this.date_msg = date_msg;
		this.texte_msg = texte_msg;
	}

	public int getN_msg() {
		return n_msg;
	}

	public void setN_msg(int n_msg) {
		this.n_msg = n_msg;
	}

	public Etudiant getRecepteur() {
		return recepteur;
	}

	public void setRecepteur(Etudiant recepteur) {
		this.recepteur = recepteur;
	}

	public Etudiant getEmetteur() {
		return emetteur;
	}

	public void setEmetteur(Etudiant emetteur) {
		this.emetteur = emetteur;
	}

	public String getDate_msg() {
		return date_msg;
	}

	public void setDate_msg(String date_msg) {
		this.date_msg = date_msg;
	}

	public String getTexte_msg() {
		return texte_msg;
	}

	public void setTexte_msg(String texte_msg) {
		this.texte_msg = texte_msg;
	}
	
	
	

}
