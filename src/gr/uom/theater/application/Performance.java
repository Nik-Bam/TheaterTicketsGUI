package gr.uom.theater.application;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

public class Performance {

    private String city;
    private int pricePerSeat;
    private SimpleStringProperty theater;
    private ObjectProperty<LocalDate> date;
    private ObjectProperty<LocalTime> time;
    private SimpleIntegerProperty availableTickets;

    public Performance(String city, String theater, LocalDate date, LocalTime time, int pricePerSeat) {
        this.city = city;
        this.pricePerSeat = pricePerSeat;
        this.theater = new SimpleStringProperty(theater);
        this.date = new SimpleObjectProperty<>(date);
        this.time = new SimpleObjectProperty<>(time);

        Random rand = new Random();
        availableTickets = new SimpleIntegerProperty(rand.nextInt(100 - 5) + 5);
    }

    public String getTheater() {
        return theater.get();
    }

    public SimpleStringProperty theaterProperty() {
        return theater;
    }

    public void setTheater(String theater) {
        this.theater.set(theater);
    }

    public LocalDate getDate() {
        return date.get();
    }

    public ObjectProperty<LocalDate> dateProperty() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date.set(date);
    }

    public LocalTime getTime() {
        return time.get();
    }

    public ObjectProperty<LocalTime> timeProperty() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time.set(time);
    }

    public int getAvailableTickets() {
        return availableTickets.get();
    }

    public SimpleIntegerProperty availableTicketsProperty() {
        return availableTickets;
    }

    public void setAvailableTickets(int availableTickets) {
        this.availableTickets.set(availableTickets);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPricePerSeat() {
        return pricePerSeat;
    }

    public void setPricePerSeat(int pricePerSeat) {
        this.pricePerSeat = pricePerSeat;
    }
}
