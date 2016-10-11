package gr.uom.theater.application;

import gr.uom.theater.resources.Data;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class Play {

    private int year;
    private String title;
    private ArrayList<Person> writers, directors, actors, musicians, costumes;
    private Image poster;
    private String summary;
    private ArrayList<Performance> performances;

    public Play(String title, int year) {
        this.title = title;
        this.year = year;

        writers = new ArrayList<>();
        directors = new ArrayList<>();
        actors = new ArrayList<>();
        musicians = new ArrayList<>();
        costumes = new ArrayList<>();
        performances = new ArrayList<>();

        poster = Data.NO_IMAGE;

        summary = "-";
    }

    @Override
    public String toString() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Person> getWriters() {
        return writers;
    }

    public void setWriters(ArrayList<Person> writers) {
        this.writers = writers;
    }

    public ArrayList<Person> getDirectors() {
        return directors;
    }

    public void setDirectors(ArrayList<Person> directors) {
        this.directors = directors;
    }

    public ArrayList<Person> getActors() {
        return actors;
    }

    public void setActors(ArrayList<Person> actors) {
        this.actors = actors;
    }

    public ArrayList<Person> getMusicians() {
        return musicians;
    }

    public void setMusicians(ArrayList<Person> musicians) {
        this.musicians = musicians;
    }

    public ArrayList<Person> getCostumes() {
        return costumes;
    }

    public void setCostumes(ArrayList<Person> costumes) {
        this.costumes = costumes;
    }

    public Image getPoster() {
        return poster;
    }

    public void setPoster(Image poster) {
        this.poster = poster;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public ArrayList<Performance> getPerformances() {
        return performances;
    }

    public ArrayList<Performance> getPerformances(String city) {
        return performances.stream().filter(p -> p.getCity().equals(Data.selectedCity)).collect(Collectors.toCollection(ArrayList::new));
    }

    public void setPerformances(ArrayList<Performance> performances) {
        this.performances = performances;
    }

    public void addWriters(Person... writers) {
        Collections.addAll(this.writers, writers);
    }

    public void addDirectors(Person... directors) {
        Collections.addAll(this.directors, directors);
    }

    public void addActors(Person... actors) {
        Collections.addAll(this.actors, actors);
    }

    public void addMusicians(Person... musicians) {
        Collections.addAll(this.musicians, musicians);
    }

    public void addCostumes(Person... costumes) {
        Collections.addAll(this.costumes, costumes);
    }

    public void addPerformances(Performance... performances) {
        Collections.addAll(this.performances, performances);
    }
}
