package com.studio.records.entities;

import com.studio.records.configs.Category;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class RecordStudio implements Serializable {

    @Id
    @GeneratedValue(generator = "photo-uuid")
    @GenericGenerator(name = "photo-uuid", strategy = "uuid")
    @Column(name = "id")
    private String id;

    @Column(name = "title")
    private String title;

    @Column(name = "logo")
    private String logo;

    @Enumerated(value = EnumType.STRING)
    private Category category;

    @Column(name = "size")
    private double size;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.REFRESH})
    @JoinTable(name = "studio_performer", joinColumns = @JoinColumn(name = "studio_id"), inverseJoinColumns = @JoinColumn(name = "performer_id"))
    private Set<Performer> performers = new HashSet<>();

    public RecordStudio(String title, String logo, Category category, double size, Set<Performer> performers) {
        this.title = title;
        this.logo = logo;
        this.category = category;
        this.size = size;
        this.performers = performers;
    }

    public RecordStudio() {
    }

    public String getId() {
        return id;
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

    public Set<Performer> getPerformers() {
        return performers;
    }

    public void setPerformers(Set<Performer> performers) {
        this.performers = performers;
    }

    @Override
    public String toString() {
        return "RecordStudio{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", logo='" + logo + '\'' +
                ", category=" + category +
                ", size=" + size +
                ", performers=" + performers +
                '}';
    }
}
