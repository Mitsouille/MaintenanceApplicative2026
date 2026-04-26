package Evenements;

public class Periodique extends Evenement{

    private Frequence frequence;
    public Periodique(TitreEvenement titreEvenement, HeureDebut heureDebut, DateEvenement dateEvenement, Personne proprietaire, Frequence frequence){
        super(titreEvenement, heureDebut, dateEvenement, proprietaire);
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
        //Événement périodique : Event de test tous les 3 jours
        return "Événement périodique : " + this.getDescription() + " tous les " + this.getFrequence().getFrequence() + " " + this.getFrequence();
    }
}
