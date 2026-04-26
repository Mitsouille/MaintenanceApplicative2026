
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventTest {
    @Test
    void creationRDVPersonnel_Test(){
        CalendarManager calendarManager = new CalendarManager();
        calendarManager.ajouterEvent("RDV_PERSONNEL", "Event de test", "Moi", LocalDateTime.of(2026, 4, 26, 16, 45), 50, "", "",0);
        assertEquals(1, calendarManager.events.size());
        assertEquals("RDV_PERSONNEL", calendarManager.events.get(0).type);
        assertEquals(2026, calendarManager.events.get(0).dateDebut.getYear());
        assertEquals(4, calendarManager.events.get(0).dateDebut.getMonth().getValue());
        assertEquals(26, calendarManager.events.get(0).dateDebut.getDayOfMonth());
        assertEquals(16, calendarManager.events.get(0).dateDebut.getHour());
        assertEquals(45, calendarManager.events.get(0).dateDebut.getMinute());
        assertEquals("Moi", calendarManager.events.get(0).proprietaire);
        assertEquals(50, calendarManager.events.get(0).dureeMinutes);
        assertEquals("", calendarManager.events.get(0).lieu);
        assertEquals("", calendarManager.events.get(0).participants);
        assertEquals(0, calendarManager.events.get(0).frequenceJours);
    }

    @Test
    void creationReunion_Test(){
        CalendarManager calendarManager = new CalendarManager();
        calendarManager.ajouterEvent("REUNION", "Event de test", "Moi", LocalDateTime.of(2026, 4, 26, 16, 45), 50, "Ici", "Toi, Lui",0);
        assertEquals(1, calendarManager.events.size());
        assertEquals("REUNION", calendarManager.events.get(0).type);
        assertEquals("Moi", calendarManager.events.get(0).proprietaire);
        assertEquals(50, calendarManager.events.get(0).dureeMinutes);
        assertEquals("Ici", calendarManager.events.get(0).lieu);
        assertEquals("Toi, Lui", calendarManager.events.get(0).participants);
        assertEquals(0, calendarManager.events.get(0).frequenceJours);
    }

    @Test
    void creationPeriodique_Test(){
        CalendarManager calendarManager = new CalendarManager();
        calendarManager.ajouterEvent("PERIODIQUE", "Event de test", "Moi", LocalDateTime.of(2026, 4, 26, 16, 45), 50, "Ici", "Toi, Lui",3);
        assertEquals(1, calendarManager.events.size());
        assertEquals("PERIODIQUE", calendarManager.events.get(0).type);
        assertEquals("Moi", calendarManager.events.get(0).proprietaire);
        assertEquals(50, calendarManager.events.get(0).dureeMinutes);
        assertEquals("Ici", calendarManager.events.get(0).lieu);
        assertEquals("Toi, Lui", calendarManager.events.get(0).participants);
        assertEquals(3, calendarManager.events.get(0).frequenceJours);
    }

    @Test
    void descriptionPeriodique_Test(){
        CalendarManager calendarManager = new CalendarManager();
        calendarManager.ajouterEvent("PERIODIQUE", "Event de test", "Moi", LocalDateTime.of(2026, 4, 26, 16, 45), 50, "Ici", "Toi, Lui",3);
        assertEquals(1, calendarManager.events.size());
        assertEquals("Événement périodique : Event de test tous les 3 jours", calendarManager.events.get(0).description());
    }

    @Test
    void descriptionRDVPersonnel_Test(){
        CalendarManager calendarManager = new CalendarManager();
        calendarManager.ajouterEvent("RDV_PERSONNEL", "Event de test", "Moi",LocalDateTime.of(2026, 4, 26, 16, 45), 50, "Ici", "Toi, Lui",3);
        assertEquals(1, calendarManager.events.size());
        assertEquals("RDV : Event de test à 2026-04-26T16:45", calendarManager.events.get(0).description());
    }

    @Test
    void descriptionReunion_Test(){
        CalendarManager calendarManager = new CalendarManager();
        calendarManager.ajouterEvent("REUNION", "Event de test", "Moi", LocalDateTime.of(2026, 4, 26, 16, 45), 50, "Ici", "Toi, Lui",3);
        assertEquals(1, calendarManager.events.size());
        assertEquals("Réunion : Event de test à Ici avec Toi, Lui", calendarManager.events.get(0).description());
    }

    @Test
    void detecterChevauchementTrue_Test(){
        CalendarManager calendarManager = new CalendarManager();
        calendarManager.ajouterEvent("REUNION", "Event de test", "Moi", LocalDateTime.of(2026, 4, 26, 16, 45), 50, "Ici", "Toi, Lui",3);
        calendarManager.ajouterEvent("RDV_PERSONNEL", "Event de test", "Moi",LocalDateTime.of(2026, 4, 26, 16, 45), 50, "Ici", "Toi, Lui",3);
        assertEquals(2, calendarManager.events.size());
        assertEquals(true, calendarManager.conflit(calendarManager.events.get(0), calendarManager.events.get(1)));
    }

    @Test
    void detecterChevauchementFalse_Test(){
        CalendarManager calendarManager = new CalendarManager();
        calendarManager.ajouterEvent("REUNION", "Event de test", "Moi", LocalDateTime.of(2026, 5, 26, 16, 45), 50, "Ici", "Toi, Lui",3);
        calendarManager.ajouterEvent("RDV_PERSONNEL", "Event de test", "Moi",LocalDateTime.of(2026, 4, 26, 16, 45), 50, "Ici", "Toi, Lui",3);
        assertEquals(2, calendarManager.events.size());
        assertEquals(false, calendarManager.conflit(calendarManager.events.get(0), calendarManager.events.get(1)));
    }

    @Test
    void obtenirListeEvenement_Test(){
        CalendarManager calendarManager = new CalendarManager();
        calendarManager.ajouterEvent("REUNION", "Event de test", "Moi", LocalDateTime.of(2026, 4, 26, 16, 45), 50, "Ici", "Toi, Lui",3);
        calendarManager.ajouterEvent("RDV_PERSONNEL", "Event de test", "Moi",LocalDateTime.of(2026, 5, 26, 16, 45), 50, "Ici", "Toi, Lui",3);
        calendarManager.ajouterEvent("RDV_PERSONNEL", "Event de test", "Moi",LocalDateTime.of(2026, 7, 26, 16, 45), 50, "Ici", "Toi, Lui",3);
        calendarManager.ajouterEvent("RDV_PERSONNEL", "Event de test", "Moi",LocalDateTime.of(2026, 12, 26, 16, 45), 50, "Ici", "Toi, Lui",3);
        List<Event> eventPeriode = new ArrayList<Event>();
        eventPeriode.add(calendarManager.events.get(1));
        eventPeriode.add(calendarManager.events.get(2));
        assertEquals(4, calendarManager.events.size());
        assertEquals(eventPeriode, calendarManager.eventsDansPeriode(LocalDateTime.of(2026, 4, 27, 16, 45), LocalDateTime.of(2026, 7, 27, 16, 45)));
    }
}
