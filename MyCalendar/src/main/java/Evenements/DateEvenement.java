package Evenements;

import java.time.LocalDate;

public class DateEvenement {
    private LocalDate LocalDate;

    public DateEvenement(int annee, int mois, int jour){
        this.LocalDate = LocalDate.of(annee,mois,jour);
    }

    public LocalDate getLocalDate() {
        return LocalDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.LocalDate = LocalDate;
    }
}
