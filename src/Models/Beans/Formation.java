package Models.Beans;

public class Formation {

    private int num_formation;
    private String type_formation;
    private String libele_formation;
    private String domaine_formation;

    public Formation() {
    }

    public Formation(int num_formation, String type_formation, String libele_formation, String domaine_formation) {
        super();
        this.num_formation = num_formation;
        this.type_formation = type_formation;
        this.libele_formation = libele_formation;
        this.domaine_formation = domaine_formation;
    }

    public int getNum_formation() {
        return num_formation;
    }

    public void setNum_formation(int num_formation) {
        this.num_formation = num_formation;
    }

    public String getType_formation() {
        return type_formation;
    }

    public void setType_formation(String type_formation) {
        this.type_formation = type_formation;
    }

    public String getLibele_formation() {
        return libele_formation;
    }

    public void setLibele_formation(String libele_formation) {
        this.libele_formation = libele_formation;
    }

    public String getDomaine_formation() {
        return domaine_formation;
    }

    public void setDomaine_formation(String domaine_formation) {
        this.domaine_formation = domaine_formation;
    }

    @Override
    public String toString() {
        return "Formation [num_formation=" + num_formation + ", type_formation=" + type_formation
                + ", libele_formation=" + libele_formation + ", domaine_formation=" + domaine_formation + "]";
    }

}
