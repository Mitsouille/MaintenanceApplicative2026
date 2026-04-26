package Evenements;

import java.time.LocalTime;

public class HeureDebut {
    private LocalTime localTime;

    public HeureDebut(int heure, int minute) {
        this.localTime = LocalTime.of(heure, minute, 0);
    }

    public LocalTime getLocalTime() {
        return localTime;
    }

    @Override
    public String toString() {
        return this.localTime.getHour() + ":" + this.localTime.getMinute();
    }

    public void setLocalTime(LocalTime localTime) {
        this.localTime = localTime;
    }
}
