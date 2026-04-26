import Evenements.DateEvenement;
import Evenements.DureeEvenement;
import Evenements.Evenement;
import Evenements.Frequence;
import Evenements.HeureDebut;
import Evenements.LieuReunion;
import Evenements.Periodique;
import Evenements.Personne;
import Evenements.RDVPersonnel;
import Evenements.Reunion;
import Evenements.TitreEvenement;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CalendarManager {
    public List<Evenement> evenements;

    public CalendarManager() {
        this.evenements = new ArrayList<>();
    }

    public void ajouterReunion(DureeEvenement dureeEvenement, TitreEvenement titreEvenement, HeureDebut heureDebut, DateEvenement dateEvenement, Personne proprietaire, LieuReunion lieuReunion, List<Personne> participants){
        evenements.add(new Reunion(dureeEvenement, titreEvenement, heureDebut, dateEvenement, proprietaire, lieuReunion, participants));
    }

    public void ajouterPeriodique(TitreEvenement titreEvenement, HeureDebut heureDebut, DateEvenement dateEvenement, Personne proprietaire, Frequence frequence){
        evenements.add(new Periodique(titreEvenement, heureDebut, dateEvenement, proprietaire, frequence));
    }

    public void ajouterRdvPerso(TitreEvenement titreEvenement, DureeEvenement dureeEvenement, HeureDebut heureDebut, Personne proprietaire, DateEvenement dateEvenement){
        evenements.add(new RDVPersonnel(dureeEvenement, titreEvenement, heureDebut, proprietaire, dateEvenement));
    }

    public List<Evenement> eventsDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        List<Evenement> result = new ArrayList<>();

        for (Evenement e : evenements) {
            if(e.estEntre(debut, fin)){
            result.add(e);
            }
        }
        return result;
    }

    public boolean conflit(Evenement e1, Evenement e2) {
        LocalDateTime debutE1 = LocalDateTime.of(e1.getDateEvenement().getLocalDate(), e1.getHeureDebut().getLocalTime());
        LocalDateTime debutE2 = LocalDateTime.of(e2.getDateEvenement().getLocalDate(), e2.getHeureDebut().getLocalTime());

        LocalDateTime finE1 = LocalDateTime.of(e1.getDateEvenement().getLocalDate(), e1.getHeureDebut().getLocalTime().plusMinutes(e1.getDuree()));
        LocalDateTime finE2 = LocalDateTime.of(e2.getDateEvenement().getLocalDate(), e2.getHeureDebut().getLocalTime()).plusMinutes(e2.getDuree());
        return e2.estEntre(debutE1, finE1) || e1.estEntre(debutE2, finE2);
    }

    public void afficherEvenements(){
        for (Evenement e : evenements) {
            System.out.println(e.getDescription());
        }
    }

    public void supprimerEvent(int eventId){
        Evenement event = this.evenements.stream().filter(e -> e.getEventId() == eventId).findFirst()
                .orElseThrow(IllegalArgumentException::new);
        this.evenements.remove(event);
    }
}