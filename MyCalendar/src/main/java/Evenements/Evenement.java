package Evenements;

public abstract class Evenement {
    private TitreEvenement titreEvenement;
    private HeureDebut heureDebut;
    private DateEvenement dateEvenement;
    private Personne proprietaire;


    public Evenement(TitreEvenement titreEvenement, HeureDebut heureDebut, DateEvenement dateEvenement, Personne proprietaire){
        this.titreEvenement = titreEvenement;
        this.heureDebut = heureDebut;
        this.dateEvenement = dateEvenement;
        this.proprietaire = proprietaire;
    }

    public abstract String getDescription();

    public TitreEvenement getTitreEvenement() {
        return titreEvenement;
    }

    public void setTitreEvenement(TitreEvenement titreEvenement) {
        this.titreEvenement = titreEvenement;
    }

    public HeureDebut getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(HeureDebut heureDebut) {
        this.heureDebut = heureDebut;
    }

    public DateEvenement getDateEvenement() {
        return dateEvenement;
    }

    public void setDateEvenement(DateEvenement dateEvenement) {
        this.dateEvenement = dateEvenement;
    }

    public Personne getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Personne proprietaire) {
        this.proprietaire = proprietaire;
    }
}
