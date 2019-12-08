package com.studio.records.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;

    @Column(name ="title",unique = true)
    private String title;

    @Column(name = "album")
    private String album;

    @Column(name = "lenght")
    private double length;

    @Column(name = "mp3")
    private String mp3;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "performer_song",
            joinColumns = @JoinColumn(name = "song_id"), inverseJoinColumns = @JoinColumn(name = "performer_id"))
    private Set<Performer> performers = new HashSet<>();

    public Song(String title, String album, double length, String mp3, Set<Performer> performers) {
        this.title = title;
        this.album = album;
        this.length = length;
        this.mp3 = mp3;
        this.performers = performers;
    }

    public Song() {
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

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public String getMp3() {
        return mp3;
    }

    public void setMp3(String mp3) {
        this.mp3 = mp3;
    }

    public Set<Performer> getPerformers() {
        return performers;
    }

    public void setPerformers(Set<Performer> performers) {
        this.performers = performers;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", album='" + album + '\'' +
                ", length=" + length +
                ", mp3='" + mp3 + '\'' +
                ", performers=" + performers +
                '}';
    }
}
