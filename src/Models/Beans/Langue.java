package Models.Beans;

public class Langue {

    private int num_langue;
    private String libele_langue;

    public Langue() {
    }

    public Langue(int num_langue, String libele_langue) {
        super();
        this.num_langue = num_langue;
        this.libele_langue = libele_langue;
    }

    public int getNum_langue() {
        return num_langue;
    }

    public void setNum_langue(int num_langue) {
        this.num_langue = num_langue;
    }

    public String getLibele_langue() {
        return libele_langue;
    }

    public void setLibele_langue(String libele_langue) {
        this.libele_langue = libele_langue;
    }

    @Override
    public String toString() {
        return "Langue [num_langue=" + num_langue + ", libele_langue=" + libele_langue + "]";
    }

}
