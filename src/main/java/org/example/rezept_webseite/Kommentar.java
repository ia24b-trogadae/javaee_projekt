package org.example.rezept_webseite;

import java.sql.Timestamp;

public class Kommentar {
    private int kommentarId;
    private int rating;
    private String kommentar;
    private int rezeptId;
    private int benutzerId;
    private Timestamp erstelltUm;

    public Kommentar(int kommentarId, int rating, String kommentar, int rezeptId, int benutzerId, Timestamp erstelltUm) {
        this.kommentarId = kommentarId;
        this.rating = rating;
        this.kommentar = kommentar;
        this.rezeptId = rezeptId;
        this.benutzerId = benutzerId;
        this.erstelltUm = erstelltUm;
    }

    public int getKommentarId() {
        return kommentarId;
    }

    public void setKommentarId(int kommentarId) {
        this.kommentarId = kommentarId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getKommentar() {
        return kommentar;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }

    public int getRezeptId() {
        return rezeptId;
    }

    public void setRezeptId(int rezeptId) {
        this.rezeptId = rezeptId;
    }

    public int getBenutzerId() {
        return benutzerId;
    }

    public void setBenutzerId(int benutzerId) {
        this.benutzerId = benutzerId;
    }

    public Timestamp getErstelltUm() {
        return erstelltUm;
    }

    public void setErstelltUm(Timestamp erstelltUm) {
        this.erstelltUm = erstelltUm;
    }
}