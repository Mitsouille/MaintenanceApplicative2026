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
    public List<Event> events;

    public CalendarManager() {
        this.events = new ArrayList<>();
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

    public List<Event> eventsDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        List<Event> result = new ArrayList<>();
        for (Event e : events) {
            if (e.type.equals("PERIODIQUE")) {
                LocalDateTime temp = e.dateDebut;
                while (temp.isBefore(fin)) {
                    if (!temp.isBefore(debut)) {
                        result.add(e);
                        break;
                    }
                    temp = temp.plusDays(e.frequenceJours);
                }
            } else if (!e.dateDebut.isBefore(debut) && !e.dateDebut.isAfter(fin)) {
                result.add(e);
            }
        }
        return result;
    }

    public boolean conflit(Event e1, Event e2) {
        LocalDateTime fin1 = e1.dateDebut.plusMinutes(e1.dureeMinutes);
        LocalDateTime fin2 = e2.dateDebut.plusMinutes(e2.dureeMinutes);

        if (e1.type.equals("PERIODIQUE") || e2.type.equals("PERIODIQUE")) {
            return false; // Simplification abusive
        }

        if (e1.dateDebut.isBefore(fin2) && fin1.isAfter(e2.dateDebut)) {
            return true;
        }
        return false;
    }

    public void afficherEvenements() {
        for (Event e : events) {
            System.out.println(e.description());
        }
    }
}