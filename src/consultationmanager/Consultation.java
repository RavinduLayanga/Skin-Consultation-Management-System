package consultationmanager;

import java.time.LocalDate;
import java.time.LocalTime;

public class Consultation {
    private LocalDate date;
    private LocalTime time;
    private double cost;
    private String notes;
    private String relative;

    //Create setters
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setRelative(String relative) {
        this.relative = relative;
    }

    //Create Getters

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public double getCost() {
        return cost;
    }

    public String getNotes() {
        return notes;
    }

    public String getRelative() {
        return relative;
    }
}
