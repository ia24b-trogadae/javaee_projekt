package org.example.rezept_webseite;

import java.sql.Timestamp;

public class Benutzer {
    private int benutzerId;
    private String username;
    private String passwort;
    private String email;
    private Timestamp erstellt;

    public Benutzer(int benutzerId, String username, String passwort, String email, Timestamp erstellt) {
        this.benutzerId = benutzerId;
        this.username = username;
        this.passwort = passwort;
        this.email = email;
        this.erstellt = erstellt;
    }

    public int getBenutzerId() {
        return benutzerId;
    }

    public void setBenutzerId(int benutzerId) {
        this.benutzerId = benutzerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getErstellt() {
        return erstellt;
    }

    public void setErstellt(Timestamp erstellt) {
        this.erstellt = erstellt;
    }
}