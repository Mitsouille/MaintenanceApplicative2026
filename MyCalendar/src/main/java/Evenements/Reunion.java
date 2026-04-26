package Evenements;

import java.util.List;

public class Reunion extends Evenement{
    private List<Personne> participantList;
    private LieuReunion lieuReunion;
    private DureeEvenement dureeEvenement;
    public Reunion(DureeEvenement dureeEvenement, TitreEvenement titreEvenement, HeureDebut heureDebut, DateEvenement dateEvenement, Personne proprietaire, LieuReunion lieuReunion, List<Personne> participants) {
        super(titreEvenement, heureDebut, dateEvenement, proprietaire);
        this.lieuReunion = lieuReunion;
        this.participantList = participants;
        this.dureeEvenement = dureeEvenement;
    }

    @Override
    public String getDescription() {
        //"Réunion : Event de test à Ici avec Toi, Lui"
        String participants = "";
        for(Personne p : participantList){
            participants = participants + p.getPrenom() + ",";
        }
        return "Réunion : " + this.getTitreEvenement() + " à " + this.getLieuReunion() + " avec " + participants;
    }

    public DureeEvenement getDureeEvenement() {
        return dureeEvenement;
    }

    public void setDureeEvenement(DureeEvenement dureeEvenement) {
        this.dureeEvenement = dureeEvenement;
    }

    public List<Personne> getParticipantList() {
        return participantList;
    }

    public void setParticipantList(List<Personne> participantList) {
        this.participantList = participantList;
    }

    public LieuReunion getLieuReunion() {
        return lieuReunion;
    }

    public void setLieuReunion(LieuReunion lieuReunion) {
        this.lieuReunion = lieuReunion;
    }
}
