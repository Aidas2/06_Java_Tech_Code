package com.studio.records.dto;

public class SongPutDTO {

    private String title;
    private String album;
    private double length;
    private String mp3;

    public SongPutDTO(String title, String album, double length, String mp3) {
        this.title = title;
        this.album = album;
        this.length = length;
        this.mp3 = mp3;
    }

    public SongPutDTO() {
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
}
