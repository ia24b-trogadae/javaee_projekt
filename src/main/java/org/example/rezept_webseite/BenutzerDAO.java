package org.example.rezept_webseite;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BenutzerDAO {
    private Connection connection;

    public BenutzerDAO(Connection connection) {
        this.connection = connection;
    }

    public void addBenutzer(String username, String email, String passwort) throws SQLException {
        String sql = "INSERT INTO Benutzer (username, email, passwort) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, email);
            stmt.setString(3, passwort);
            stmt.executeUpdate();
        }
    }

    public void deleteBenutzer(int id) throws SQLException {
        String sql = "DELETE FROM Benutzer WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public List<String> getAllBenutzer() throws SQLException {
        List<String> benutzerListe = new ArrayList<>();
        String sql = "SELECT * FROM Benutzer";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                benutzerListe.add(rs.getString("username"));
            }
        }
        return benutzerListe;
    }
}