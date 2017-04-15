package Models.Beans;

public class Entreprise {

    private int num_entreprise;
    private String nom_entreprise;
    private String tel_fixe_entreprise;
    private String email_entreprise;
    private String adresse_entreprise;
    private String mot_passe_entreprise;
    private String login_entreprise;
    private int statut;

    public Entreprise() {
    }

    public Entreprise(int num_entreprise, String nom_entreprise, String tel_fixe_entreprise, String email_entreprise,
            String adresse_entreprise, String mot_passe_entreprise, String login_entreprise, int statut) {
        super();
        this.num_entreprise = num_entreprise;
        this.nom_entreprise = nom_entreprise;
        this.tel_fixe_entreprise = tel_fixe_entreprise;
        this.email_entreprise = email_entreprise;
        this.adresse_entreprise = adresse_entreprise;
        this.mot_passe_entreprise = mot_passe_entreprise;
        this.login_entreprise = login_entreprise;
        this.statut = statut;
    }

    public int getNum_entreprise() {
        return num_entreprise;
    }

    public void setNum_entreprise(int num_entreprise) {
        this.num_entreprise = num_entreprise;
    }

    public String getNom_entreprise() {
        return nom_entreprise;
    }

    public void setNom_entreprise(String nom_entreprise) {
        this.nom_entreprise = nom_entreprise;
    }

    public String getTel_fixe_entreprise() {
        return tel_fixe_entreprise;
    }

    public void setTel_fixe_entreprise(String tel_fixe_entreprise) {
        this.tel_fixe_entreprise = tel_fixe_entreprise;
    }

    public String getEmail_entreprise() {
        return email_entreprise;
    }

    public void setEmail_entreprise(String email_entreprise) {
        this.email_entreprise = email_entreprise;
    }

    public String getAdresse_entreprise() {
        return adresse_entreprise;
    }

    public void setAdresse_entreprise(String adresse_entreprise) {
        this.adresse_entreprise = adresse_entreprise;
    }

    public String getMot_passe_entreprise() {
        return mot_passe_entreprise;
    }

    public void setMot_passe_entreprise(String mot_passe_entreprise) {
        this.mot_passe_entreprise = mot_passe_entreprise;
    }

    public String getLogin_entreprise() {
        return login_entreprise;
    }

    public void setLogin_entreprise(String login_entreprise) {
        this.login_entreprise = login_entreprise;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "Entreprise [num_entreprise=" + num_entreprise + ", nom_entreprise=" + nom_entreprise
                + ", tel_fixe_entreprise=" + tel_fixe_entreprise + ", email_entreprise=" + email_entreprise
                + ", adresse_entreprise=" + adresse_entreprise + ", mot_passe_entreprise=" + mot_passe_entreprise
                + ", login_entreprise=" + login_entreprise + ", statut=" + statut + "]";
    }

}
