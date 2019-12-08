package it.akademija.springapp.entity;

import javax.persistence.Entity;
import java.time.LocalDate;


@Entity
public class Inventory extends BaseEntity {

    private String title;
    private Double weight;
    private Integer sector;
    private LocalDate date;

    public Inventory() {
    }

    public Inventory(String title, Double weight, Integer sector, LocalDate date) {
        this.title = title;
        this.weight = weight;
        this.sector = sector;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getSector() {
        return sector;
    }

    public void setSector(Integer sector) {
        this.sector = sector;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
