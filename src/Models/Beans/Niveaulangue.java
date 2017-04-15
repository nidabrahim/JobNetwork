package Models.Beans;

public class Niveaulangue {
	
	private int num_niv_langue;
	private String libele_niv_langue;
	
	
	public Niveaulangue() {
		super();
		this.num_niv_langue = num_niv_langue;
		this.libele_niv_langue = libele_niv_langue;
	}


	public int getNum_niv_langue() {
		return num_niv_langue;
	}


	public void setNum_niv_langue(int num_niv_langue) {
		this.num_niv_langue = num_niv_langue;
	}


	public String getLibele_niv_langue() {
		return libele_niv_langue;
	}


	public void setLibele_niv_langue(String libele_niv_langue) {
		this.libele_niv_langue = libele_niv_langue;
	}


	@Override
	public String toString() {
		return "Niveaulangue [num_niv_langue=" + num_niv_langue + ", libele_niv_langue=" + libele_niv_langue + "]";
	}
	
	
	
	

}
