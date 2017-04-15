package Models.Beans;

public class Etablissement {

    private int num_etablissement;
    private String nom_etablissement;
    private String adresse_etablissement;
    private String tel_gsm_etablissement;
    private String tel_fixe_etablissement;
    private String mot_passe_etablissement;
    private String login_etablissement;

    public Etablissement() {
    }

    public int getNum_etablissement() {
        return num_etablissement;
    }

    public void setNum_etablissement(int num_etablissement) {
        this.num_etablissement = num_etablissement;
    }

    public String getNom_etablissement() {
        return nom_etablissement;
    }

    public void setNom_etablissement(String nom_etablissement) {
        this.nom_etablissement = nom_etablissement;
    }

    public String getAdresse_etablissement() {
        return adresse_etablissement;
    }

    public void setAdresse_etablissement(String adresse_etablissement) {
        this.adresse_etablissement = adresse_etablissement;
    }

    public String getTel_gsm_etablissement() {
        return tel_gsm_etablissement;
    }

    public void setTel_gsm_etablissement(String tel_gsm_etablissement) {
        this.tel_gsm_etablissement = tel_gsm_etablissement;
    }

    public String getTel_fixe_etablissement() {
        return tel_fixe_etablissement;
    }

    public void setTel_fixe_etablissement(String tel_fixe_etablissement) {
        this.tel_fixe_etablissement = tel_fixe_etablissement;
    }

    public String getMot_passe_etablissement() {
        return mot_passe_etablissement;
    }

    public void setMot_passe_etablissement(String mot_passe_etablissement) {
        this.mot_passe_etablissement = mot_passe_etablissement;
    }

    public String getLogin_etablissement() {
        return login_etablissement;
    }

    public void setLogin_etablissement(String login_etablissement) {
        this.login_etablissement = login_etablissement;
    }

    @Override
    public String toString() {
        return "Etablissement [num_etablissement=" + num_etablissement + ", nom_etablissement=" + nom_etablissement
                + ", adresse_etablissement=" + adresse_etablissement + ", tel_gsm_etablissement="
                + tel_gsm_etablissement + ", tel_fixe_etablissement=" + tel_fixe_etablissement
                + ", mot_passe_etablissement=" + mot_passe_etablissement + ", login_etablissement="
                + login_etablissement + "]";
    }

}
