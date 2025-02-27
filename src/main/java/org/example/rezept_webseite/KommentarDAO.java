package org.example.rezept_webseite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KommentarDAO {
    private Connection connection;

    public KommentarDAO(Connection connection) {
        this.connection = connection;
    }

    public void addKommentar(int benutzerId, int rezeptId, String text) throws SQLException {
        String sql = "INSERT INTO Kommentar (benutzer_id, rezept_id, text) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, benutzerId);
            stmt.setInt(2, rezeptId);
            stmt.setString(3, text);
            stmt.executeUpdate();
        }
    }

    public void deleteKommentar(int id) throws SQLException {
        String sql = "DELETE FROM Kommentar WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public List<String> getKommentareByRezept(int rezeptId) throws SQLException {
        List<String> kommentare = new ArrayList<>();
        String sql = "SELECT text FROM Kommentar WHERE rezept_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, rezeptId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    kommentare.add(rs.getString("text"));
                }
            }
        }
        return kommentare;
    }
}
