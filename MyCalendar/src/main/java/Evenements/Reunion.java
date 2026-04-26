package Evenements;

import java.util.List;

public class Reunion extends Evenement{
    private List<Participant> participantList;
    private LieuReunion lieuReunion;
    public Reunion(DureeEvenement dureeEvenement, TitreEvenement titreEvenement, HeureDebut heureDebut, DateEvenement dateEvenement, LieuReunion lieuReunion, List<Participant> participants) {
        super(dureeEvenement, titreEvenement, heureDebut, dateEvenement);
        this.lieuReunion = lieuReunion;
        this.participantList = participants;
    }

    @Override
    public String getDescription() {
        //"Réunion : Event de test à Ici avec Toi, Lui"
        String participants = "";
        for(Participant p : participantList){
            participants = participants + p.getPrenom() + ",";
        }
        return "Réunion : " + this.getTitreEvenement() + " à " + this.getLieuReunion() + " avec " + participants;
    }

    public List<Participant> getParticipantList() {
        return participantList;
    }

    public void setParticipantList(List<Participant> participantList) {
        this.participantList = participantList;
    }

    public LieuReunion getLieuReunion() {
        return lieuReunion;
    }

    public void setLieuReunion(LieuReunion lieuReunion) {
        this.lieuReunion = lieuReunion;
    }
}
