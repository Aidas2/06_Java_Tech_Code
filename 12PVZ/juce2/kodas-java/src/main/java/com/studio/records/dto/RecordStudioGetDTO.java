package com.studio.records.dto;

import com.studio.records.configs.Category;

public class RecordStudioGetDTO {
    private String title;
    private String logo;
    private Category category;
    private double size;

    public RecordStudioGetDTO(String title, String logo, Category category, double size) {
        this.title = title;
        this.logo = logo;
        this.category = category;
        this.size = size;
    }

    public RecordStudioGetDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}
