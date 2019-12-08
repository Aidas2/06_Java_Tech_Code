package it.akademija.springapp.dto.inventory;

import java.time.LocalDate;

public class InventoryGetDTO {

    private String id;
    private String title;
    private Double weight;
    private Integer sector;
    private LocalDate date;

    public InventoryGetDTO() {
    }

    public InventoryGetDTO(String id, String title, Double weight, Integer sector, LocalDate date) {
        this.id = id;
        this.title = title;
        this.weight = weight;
        this.sector = sector;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
