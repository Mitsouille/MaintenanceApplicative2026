
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
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventTest {

    @Test
    void creationRDVPersonnel_Test_Refacto() {
        RDVPersonnel evenement = new RDVPersonnel(new DureeEvenement(5), new TitreEvenement("RDV de goat"),
                new HeureDebut(15, 15), new Personne("Laeticia"),
                new DateEvenement(2026, 5, 2));
        assertEquals(5, evenement.getDureeEvenement().getDuree());
        assertEquals("Laeticia", evenement.getProprietaire().getPrenom());
        assertEquals("RDV de goat", evenement.getTitreEvenement().getTitreEvenement());
        assertEquals(15, evenement.getHeureDebut().getLocalTime().getHour());
        assertEquals(15, evenement.getHeureDebut().getLocalTime().getMinute());
        LocalDateTime localDateTime = LocalDateTime.of(2026,5,2,0,0);
        assertEquals(localDateTime.getYear(), evenement.getDateEvenement().getLocalDate().getYear());
        assertEquals(localDateTime.getMonth(), evenement.getDateEvenement().getLocalDate().getMonth());
        assertEquals(localDateTime.getDayOfMonth(), evenement.getDateEvenement().getLocalDate().getDayOfMonth());
    }

    @Test
    void creationReunion_Test_Refacto() {
        Reunion evenement = new Reunion(new DureeEvenement(5), new TitreEvenement("RDV de goat"),
                new HeureDebut(15, 15), new DateEvenement(2026, 5, 2),
                new Personne("Laeticia"),
                new LieuReunion("Ici"), Arrays.asList(
                        new Personne("Patrick"),
                        new Personne("Noah")
        ));
        assertEquals(5, evenement.getDureeEvenement().getDuree());
        assertEquals("RDV de goat", evenement.getTitreEvenement().getTitreEvenement());
        assertEquals(15, evenement.getHeureDebut().getLocalTime().getHour());
        assertEquals(15, evenement.getHeureDebut().getLocalTime().getMinute());
        LocalDateTime localDateTime = LocalDateTime.of(2026,5,2,0,0);
        assertEquals(localDateTime.getYear(), evenement.getDateEvenement().getLocalDate().getYear());
        assertEquals(localDateTime.getMonth(), evenement.getDateEvenement().getLocalDate().getMonth());
        assertEquals(localDateTime.getDayOfMonth(), evenement.getDateEvenement().getLocalDate().getDayOfMonth());
        assertEquals("Laeticia", evenement.getProprietaire().getPrenom());
        assertEquals("Ici", evenement.getLieuReunion().getLieuReunion());
        assertEquals(2, evenement.getParticipantList().size());
        assertEquals("Patrick", evenement.getParticipantList().get(0).getPrenom());
        assertEquals("Noah", evenement.getParticipantList().get(1).getPrenom());
    }

    @Test
    void creationPeriodique_Test_Refacto() {
        Periodique evenement = new Periodique(new TitreEvenement("RDV de goat"),
                new HeureDebut(15, 15),
                new DateEvenement(2026, 5, 2), new Personne("Laeticia"), new Frequence(5));
        assertEquals("RDV de goat", evenement.getTitreEvenement().getTitreEvenement());
        assertEquals(15, evenement.getHeureDebut().getLocalTime().getHour());
        assertEquals(15, evenement.getHeureDebut().getLocalTime().getMinute());
        LocalDateTime localDateTime = LocalDateTime.of(2026,5,2,0,0);
        assertEquals(localDateTime.getYear(), evenement.getDateEvenement().getLocalDate().getYear());
        assertEquals(localDateTime.getMonth(), evenement.getDateEvenement().getLocalDate().getMonth());
        assertEquals(localDateTime.getDayOfMonth(), evenement.getDateEvenement().getLocalDate().getDayOfMonth());
        assertEquals("Laeticia", evenement.getProprietaire().getPrenom());
        assertEquals(5, evenement.getFrequence().getFrequence());
    }

    @Test
    void descriptionPeriodique_Test() {
        CalendarManager calendarManager = new CalendarManager();
        calendarManager.ajouterPeriodique(new TitreEvenement("Event de test"),
                new HeureDebut(16, 45), new DateEvenement(2016,4,26),
                new Personne("Laeticia"), new Frequence(3));
        assertEquals(1, calendarManager.evenements.size());
        assertEquals("Événement périodique : Event de test tous les 3 jours", calendarManager.evenements.get(0).getDescription());
    }

    @Test
    void descriptionRDVPersonnel_Test() {
        CalendarManager calendarManager = new CalendarManager();
        calendarManager.ajouterRdvPerso(new TitreEvenement("Event de test"), new DureeEvenement(50),
                new HeureDebut(16,45), new Personne("Laeticia"), new DateEvenement(2026, 4, 26));
        assertEquals(1, calendarManager.evenements.size());
        assertEquals("RDV : Event de test à 2026-04-26T16:45", calendarManager.evenements.get(0).getDescription());
    }

    @Test
    void descriptionReunion_Test() {
        CalendarManager calendarManager = new CalendarManager();
        calendarManager.ajouterReunion(new DureeEvenement(50),
                new TitreEvenement("Event de test"), new HeureDebut(16,45),
                new DateEvenement(2026, 4, 26), new Personne("Moi"), new LieuReunion("Ici"), Arrays.asList(
                        new Personne("Patrick"),
                        new Personne("Noah")
                ));
        assertEquals(1, calendarManager.evenements.size());
        assertEquals("Réunion : Event de test à Ici avec Patrick, Noah", calendarManager.evenements.get(0).getDescription());
    }

    @Test
    void detecterChevauchementTrue_Test() {
        CalendarManager calendarManager = new CalendarManager();
        calendarManager.ajouterReunion(new DureeEvenement(50),
                new TitreEvenement("Event de test"), new HeureDebut(16,47),
                new DateEvenement(2026, 4, 26), new Personne("Moi"), new LieuReunion("Ici"), Arrays.asList(
                        new Personne("Patrick"),
                        new Personne("Noah")
                ));
        calendarManager.ajouterRdvPerso(new TitreEvenement("Event de test"), new DureeEvenement(50),
                new HeureDebut(16,45), new Personne("Laeticia"), new DateEvenement(2026, 4, 26));
        assertEquals(2, calendarManager.evenements.size());
        assertEquals(true, calendarManager.conflit(calendarManager.evenements.get(0), calendarManager.evenements.get(1)));
    }

    @Test
    void detecterChevauchementFalse_Test() {
        CalendarManager calendarManager = new CalendarManager();
        calendarManager.ajouterReunion(new DureeEvenement(50),
                new TitreEvenement("Event de test"), new HeureDebut(16,45),
                new DateEvenement(2026, 2, 26), new Personne("Moi"), new LieuReunion("Ici"), Arrays.asList(
                        new Personne("Patrick"),
                        new Personne("Noah")
                ));
        calendarManager.ajouterPeriodique(new TitreEvenement("Event de test"),
                new HeureDebut(16, 45), new DateEvenement(2026,4,26),
                new Personne("Laeticia"), new Frequence(3));
        calendarManager.ajouterRdvPerso(new TitreEvenement("Event de test"), new DureeEvenement(50),
                new HeureDebut(16,45), new Personne("Laeticia"), new DateEvenement(2026, 5, 26));
        calendarManager.ajouterRdvPerso(new TitreEvenement("Event de test"), new DureeEvenement(50),
                new HeureDebut(16,45), new Personne("Laeticia"), new DateEvenement(2026, 9, 26));

        assertEquals(4, calendarManager.evenements.size());
        assertEquals(false, calendarManager.conflit(calendarManager.evenements.get(0), calendarManager.evenements.get(1)));
    }

    @Test
    void obtenirListeEvenement_Test() {
        CalendarManager calendarManager = new CalendarManager();
        List<Evenement> eventPeriode = new ArrayList<Evenement>();
        calendarManager.ajouterRdvPerso(new TitreEvenement("Event de test"), new DureeEvenement(50),
                new HeureDebut(16,45), new Personne("Laeticia"), new DateEvenement(2026, 3, 26));
        calendarManager.ajouterPeriodique(new TitreEvenement("Event de test"),
                new HeureDebut(16, 46), new DateEvenement(2026,4,27),
                new Personne("Laeticia"), new Frequence(3));
        calendarManager.ajouterRdvPerso(new TitreEvenement("Event de test"), new DureeEvenement(50),
                new HeureDebut(16,45), new Personne("Laeticia"), new DateEvenement(2026, 5, 26));
        calendarManager.ajouterRdvPerso(new TitreEvenement("Event de test"), new DureeEvenement(50),
                new HeureDebut(16,45), new Personne("Laeticia"), new DateEvenement(2026, 9, 26));
        eventPeriode.add(calendarManager.evenements.get(1));
        eventPeriode.add(calendarManager.evenements.get(2));
        assertEquals(4, calendarManager.evenements.size());
        assertEquals(eventPeriode, calendarManager.eventsDansPeriode(LocalDateTime.of(2026, 4, 27, 16, 45), LocalDateTime.of(2026, 7, 27, 16, 45)));
    }

    @Test
    void obtenirListeEvenementPeriodique_Test() {
        CalendarManager calendarManager = new CalendarManager();
        List<Evenement> eventPeriode = new ArrayList<Evenement>();
        calendarManager.ajouterPeriodique(new TitreEvenement("Event de test"),
                new HeureDebut(16, 46), new DateEvenement(2026,4,27),
                new Personne("Laeticia"), new Frequence(3));
        calendarManager.ajouterPeriodique(new TitreEvenement("Event de avant"),
                new HeureDebut(16, 46), new DateEvenement(2026,1,27),
                new Personne("Laeticia"), new Frequence(3));
        calendarManager.ajouterPeriodique(new TitreEvenement("Event de test après"),
                new HeureDebut(16, 46), new DateEvenement(2026,9,27),
                new Personne("Laeticia"), new Frequence(3));
        eventPeriode.add(calendarManager.evenements.get(0));
        eventPeriode.add(calendarManager.evenements.get(1));
        assertEquals(3, calendarManager.evenements.size());
        assertEquals(eventPeriode, calendarManager.eventsDansPeriode(LocalDateTime.of(2026, 4, 27, 16, 45), LocalDateTime.of(2026, 7, 27, 16, 45)));
    }

    @Test
    void supprimerEvenement(){
        CalendarManager calendarManager = new CalendarManager();
        List<Evenement> eventPeriode = new ArrayList<Evenement>();
        calendarManager.ajouterPeriodique(new TitreEvenement("Event de test"),
                new HeureDebut(16, 46), new DateEvenement(2026,4,27),
                new Personne("Laeticia"), new Frequence(3));
        calendarManager.ajouterPeriodique(new TitreEvenement("Event de avant"),
                new HeureDebut(16, 46), new DateEvenement(2026,1,27),
                new Personne("Laeticia"), new Frequence(3));
        calendarManager.ajouterPeriodique(new TitreEvenement("Event de test après"),
                new HeureDebut(16, 46), new DateEvenement(2026,9,27),
                new Personne("Laeticia"), new Frequence(3));
        eventPeriode.add(calendarManager.evenements.get(0));
        eventPeriode.add(calendarManager.evenements.get(1));
        assertEquals(3, calendarManager.evenements.size());
        calendarManager.supprimerEvent(2);
        assertEquals(2, calendarManager.evenements.size());
        assertEquals(0, calendarManager.evenements.get(0).getEventId());
        assertEquals(1, calendarManager.evenements.get(1).getEventId());


    }
}
