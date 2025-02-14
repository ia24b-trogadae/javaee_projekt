package org.example.rezept_webseite;

public class Rezept {
    private int rezeptId;
    private String titel;
    private String bild;
    private String farbe1;
    private String farbe2;
    private String farbe3;
    private String farbe4;
    private String emoji;
    private String zutaten;
    private String zubereitung;
    private int benutzerId;

    public Rezept(int rezeptId, String titel, String bild, String farbe1, String farbe2, String farbe3, String farbe4, String emoji, String zutaten, String zubereitung, int benutzerId) {
        this.rezeptId = rezeptId;
        this.titel = titel;
        this.bild = bild;
        this.farbe1 = farbe1;
        this.farbe2 = farbe2;
        this.farbe3 = farbe3;
        this.farbe4 = farbe4;
        this.emoji = emoji;
        this.zutaten = zutaten;
        this.zubereitung = zubereitung;
        this.benutzerId = benutzerId;
    }

    public int getRezeptId() {
        return rezeptId;
    }

    public void setRezeptId(int rezeptId) {
        this.rezeptId = rezeptId;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getBild() {
        return bild;
    }

    public void setBild(String bild) {
        this.bild = bild;
    }

    public String getFarbe1() {
        return farbe1;
    }

    public void setFarbe1(String farbe1) {
        this.farbe1 = farbe1;
    }

    public String getFarbe2() {
        return farbe2;
    }

    public void setFarbe2(String farbe2) {
        this.farbe2 = farbe2;
    }

    public String getFarbe3() {
        return farbe3;
    }

    public void setFarbe3(String farbe3) {
        this.farbe3 = farbe3;
    }

    public String getFarbe4() {
        return farbe4;
    }

    public void setFarbe4(String farbe4) {
        this.farbe4 = farbe4;
    }

    public String getEmoji() {
        return emoji;
    }

    public void setEmoji(String emoji) {
        this.emoji = emoji;
    }

    public String getZutaten() {
        return zutaten;
    }

    public void setZutaten(String zutaten) {
        this.zutaten = zutaten;
    }

    public String getZubereitung() {
        return zubereitung;
    }

    public void setZubereitung(String zubereitung) {
        this.zubereitung = zubereitung;
    }

    public int getBenutzerId() {
        return benutzerId;
    }

    public void setBenutzerId(int benutzerId) {
        this.benutzerId = benutzerId;
    }
}
