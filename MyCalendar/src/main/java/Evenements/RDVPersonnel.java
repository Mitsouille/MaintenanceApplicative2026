package Evenements;

public class RDVPersonnel extends Evenement{

    public RDVPersonnel(DureeEvenement dureeEvenement, TitreEvenement titreEvenement, HeureDebut heureDebut, DateEvenement dateEvenement) {
        super(dureeEvenement, titreEvenement, heureDebut, dateEvenement);
    }

    @Override
    public String getDescription() {
        //RDV : Event de test à 2026-04-26T16:45
        return "RDV : " + this.getTitreEvenement() + " à " + this.getDateEvenement() + "T" + this.getHeureDebut().getHeure() + ":" + this.getHeureDebut().getMinute();
    }
}
