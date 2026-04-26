package Evenements;

public abstract class Evenement {
    private DureeEvenement dureeEvenement;
    private TitreEvenement titreEvenement;
    private HeureDebut heureDebut;
    private DateEvenement dateEvenement;


    public Evenement(DureeEvenement dureeEvenement, TitreEvenement titreEvenement, HeureDebut heureDebut, DateEvenement dateEvenement){
        this.dureeEvenement = dureeEvenement;
        this.titreEvenement = titreEvenement;
        this.heureDebut = heureDebut;
        this.dateEvenement = dateEvenement;
    }

    public abstract String getDescription();


    public DureeEvenement getDureeEvenement() {
        return dureeEvenement;
    }

    public void setDureeEvenement(DureeEvenement dureeEvenement) {
        this.dureeEvenement = dureeEvenement;
    }

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
}
