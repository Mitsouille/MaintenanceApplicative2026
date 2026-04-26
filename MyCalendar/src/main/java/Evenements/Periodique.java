package Evenements;

public class Periodique extends Evenement{

    private Frequence frequence;
    public Periodique(DureeEvenement dureeEvenement, TitreEvenement titreEvenement, HeureDebut heureDebut, DateEvenement dateEvenement, Frequence frequence){
        super(dureeEvenement, titreEvenement, heureDebut, dateEvenement);
        this.frequence = frequence;
    }

    public Frequence getFrequence() {
        return frequence;
    }

    public void setFrequence(Frequence frequence) {
        this.frequence = frequence;
    }

    @Override
    public String getDescription() {
        return "";
    }
}
