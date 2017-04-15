package Models.Beans;

public class Criteres {

    private int num_critere;
    private OffreDeStage stage;

    public Criteres() {
    }

    public Criteres(int num_critere, OffreDeStage stage) {
        super();
        this.num_critere = num_critere;
        this.stage = stage;
    }

    public int getNum_critere() {
        return num_critere;
    }

    public void setNum_critere(int num_critere) {
        this.num_critere = num_critere;
    }

    public OffreDeStage getStage() {
        return stage;
    }

    public void setStage(OffreDeStage stage) {
        this.stage = stage;
    }

    @Override
    public String toString() {
        return "Criteres [num_critere=" + num_critere + ", stage=" + stage + "]";
    }

}
