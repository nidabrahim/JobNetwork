package Models.Beans;

import java.util.Date;

public class ExperiencePro {

    private int num_experience_pro;
    private String employeur_experience_pro;
    private String fonction;
    private Date date_debut;
    private Date date_fin;
    private Etudiant etudiant;

    public ExperiencePro() {
    }

    public ExperiencePro(int num_experience_pro, String employeur_experience_pro, String fonction, Date date_debut,
            Date date_fin, Etudiant etudiant) {
        super();
        this.num_experience_pro = num_experience_pro;
        this.employeur_experience_pro = employeur_experience_pro;
        this.fonction = fonction;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.etudiant = etudiant;
    }

    public int getNum_experience_pro() {
        return num_experience_pro;
    }

    public void setNum_experience_pro(int num_experience_pro) {
        this.num_experience_pro = num_experience_pro;
    }

    public String getEmployeur_experience_pro() {
        return employeur_experience_pro;
    }

    public void setEmployeur_experience_pro(String employeur_experience_pro) {
        this.employeur_experience_pro = employeur_experience_pro;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    @Override
    public String toString() {
        return "ExperiencePro [num_experience_pro=" + num_experience_pro + ", employeur_experience_pro="
                + employeur_experience_pro + ", fonction=" + fonction + ", date_debut=" + date_debut + ", date_fin="
                + date_fin + ", etudiant=" + etudiant + "]";
    }

}
