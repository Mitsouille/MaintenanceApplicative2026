package Evenements;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Periodique extends Evenement{

    private Frequence frequence;
    public Periodique(TitreEvenement titreEvenement, HeureDebut heureDebut, DateEvenement dateEvenement, Personne proprietaire, Frequence frequence){
        super(titreEvenement, heureDebut, dateEvenement, proprietaire);
        this.frequence = frequence;
    }

    public Frequence getFrequence() {
        return frequence;
    }

    public boolean estEntre(LocalDateTime debut, LocalDateTime fin){
        LocalDateTime localDateTime = LocalDateTime.of(this.getDateEvenement().getLocalDate(), this.getHeureDebut().getLocalTime());
        boolean res = false;
        while(localDateTime.isBefore(debut) || !localDateTime.isAfter(fin)){
            localDateTime = localDateTime.plusDays(frequence.getFrequence());
            if(localDateTime.isAfter(debut) && localDateTime.isBefore(fin)){
                res = true;
            }
        }
        return res;
    }

    public void setFrequence(Frequence frequence) {
        this.frequence = frequence;
    }

    @Override
    public String getDescription() {
        //Événement périodique : Event de test tous les 3 jours
        return "Événement périodique : " + this.getTitreEvenement().getTitreEvenement() + " tous les " + this.getFrequence().getFrequence() + " jours";
    }
}
