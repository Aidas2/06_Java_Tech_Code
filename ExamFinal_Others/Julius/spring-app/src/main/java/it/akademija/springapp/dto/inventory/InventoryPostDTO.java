package it.akademija.springapp.dto.inventory;

import java.time.LocalDate;

public class InventoryPostDTO {

    private String title;
    private Double weight;
    private Integer sector;
    private LocalDate date;

    public InventoryPostDTO() {
    }

    public InventoryPostDTO(String title, Double weight, Integer sector, LocalDate date) {
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
