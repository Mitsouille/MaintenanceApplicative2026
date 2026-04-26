package Evenements;

public class RDVPersonnel extends Evenement{

    private DureeEvenement dureeEvenement;

    public RDVPersonnel(DureeEvenement dureeEvenement, TitreEvenement titreEvenement, HeureDebut heureDebut, Personne proprietaire, DateEvenement dateEvenement) {
        super(titreEvenement, heureDebut, dateEvenement, proprietaire);
        this.dureeEvenement = dureeEvenement;

    }

    @Override
    public String getDescription() {
        //RDV : Event de test à 2026-04-26T16:45
        return "RDV : " + this.getTitreEvenement().getTitreEvenement() + " à " + this.getDateEvenement().getLocalDate() + "T" + this.getHeureDebut();
    }

    public DureeEvenement getDureeEvenement() {
        return dureeEvenement;
    }

    public void setDureeEvenement(DureeEvenement dureeEvenement) {
        this.dureeEvenement = dureeEvenement;
    }
}
