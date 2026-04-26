package Evenements;

public class Frequence {
    private int frequence;
    private String typeFrequence;

    public Frequence(int frequence, String typeFrequence) {
        this.frequence = frequence;
        this.typeFrequence = typeFrequence;
    }

    public int getFrequence() {
        return frequence;
    }

    public void setFrequence(int frequence) {
        this.frequence = frequence;
    }

    public String getTypeFrequence() {
        return typeFrequence;
    }

    public void setTypeFrequence(String typeFrequence) {
        this.typeFrequence = typeFrequence;
    }
}
