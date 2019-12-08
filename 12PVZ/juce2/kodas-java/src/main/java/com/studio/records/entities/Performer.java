package com.studio.records.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Performer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title",unique = true)
    private String title;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "genre")
    private String genre;

    @Column(name = "country")
    private String country;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "picture")
    private String picture;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "studio_performer",
            joinColumns = @JoinColumn(name = "performer_id"), inverseJoinColumns = @JoinColumn(name = "studio_id"))
    private Set<RecordStudio> recordStudios = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "performer_song",
            joinColumns = @JoinColumn(name = "performer_id"), inverseJoinColumns = @JoinColumn(name = "song_id"))
    private Set<Song> songs = new HashSet<>();

    public Performer(String title, String firstName, String lastName, String genre, String country, Date dob, String picture, Set<RecordStudio> recordStudios, Set<Song> songs) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.genre = genre;
        this.country = country;
        this.dob = dob;
        this.picture = picture;
        this.recordStudios = recordStudios;
        this.songs = songs;
    }

    public Performer() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Set<RecordStudio> getRecordStudios() {
        return recordStudios;
    }

    public void setRecordStudios(Set<RecordStudio> recordStudios) {
        this.recordStudios = recordStudios;
    }

    public Set<Song> getSongs() {
        return songs;
    }

    public void setSongs(Set<Song> songs) {
        this.songs = songs;
    }

    @Override
    public String toString() {
        return "PerformerService{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", genre='" + genre + '\'' +
                ", country='" + country + '\'' +
                ", dob=" + dob +
                ", picture='" + picture + '\'' +
                ", recordStudios=" + recordStudios +
                ", songs=" + songs +
                '}';
    }
}
