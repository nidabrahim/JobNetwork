package Models.Beans;

public class Logiciel {

    private int num_logiciel;
    private String libele_logiciel;

    public Logiciel() {
    }

    public Logiciel(int num_logiciel, String libele_logiciel) {
        super();
        this.num_logiciel = num_logiciel;
        this.libele_logiciel = libele_logiciel;
    }

    public int getNum_logiciel() {
        return num_logiciel;
    }

    public void setNum_logiciel(int num_logiciel) {
        this.num_logiciel = num_logiciel;
    }

    public String getLibele_logiciel() {
        return libele_logiciel;
    }

    public void setLibele_logiciel(String libele_logiciel) {
        this.libele_logiciel = libele_logiciel;
    }

    @Override
    public String toString() {
        return "Logiciel [num_logiciel=" + num_logiciel + ", libele_logiciel=" + libele_logiciel + "]";
    }

}
