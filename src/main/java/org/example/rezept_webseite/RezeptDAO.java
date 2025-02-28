package org.example.rezept_webseite;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RezeptDAO {
    private Connection connection;

    public RezeptDAO(Connection connection) {
        this.connection = connection;
    }

    public void addRezept(Rezept rezept) throws SQLException {
        String sql = "INSERT INTO Rezept (titel, bild, farbe1, farbe2, farbe3, farbe4, emoji, zutaten, zubereitung) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, rezept.getTitel());
            statement.setString(2, rezept.getBild());
            statement.setString(3, rezept.getFarbe1());
            statement.setString(4, rezept.getFarbe2());
            statement.setString(5, rezept.getFarbe3());
            statement.setString(6, rezept.getFarbe4());
            statement.setString(7, rezept.getEmoji());
            statement.setString(8, rezept.getZutaten());
            statement.setString(9, rezept.getZubereitung());
            statement.executeUpdate();
        }
    }

    public Rezept getRezeptById(int rezeptId) throws SQLException {
        String sql = "SELECT * FROM Rezept WHERE rezept_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, rezeptId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Rezept(
                        resultSet.getInt("rezept_id"),
                        resultSet.getString("titel"),
                        resultSet.getString("bild"),
                        resultSet.getString("farbe1"),
                        resultSet.getString("farbe2"),
                        resultSet.getString("farbe3"),
                        resultSet.getString("farbe4"),
                        resultSet.getString("emoji"),
                        resultSet.getString("zutaten"),
                        resultSet.getString("zubereitung")
                );
            }
        }
        return null;
    }


    public List<Rezept> getAllRezepte() throws SQLException {
        List<Rezept> rezepte = new ArrayList<>();
        String sql = "SELECT * FROM Rezept";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                rezepte.add(new Rezept(
                        resultSet.getInt("rezept_id"),
                        resultSet.getString("titel"),
                        resultSet.getString("bild"),
                        resultSet.getString("farbe1"),
                        resultSet.getString("farbe2"),
                        resultSet.getString("farbe3"),
                        resultSet.getString("farbe4"),
                        resultSet.getString("emoji"),
                        resultSet.getString("zutaten"),
                        resultSet.getString("zubereitung")
                ));
            }
        }
        return rezepte;
    }

    public void updateRezept(Rezept rezept) throws SQLException {
        String sql = "UPDATE Rezept SET titel = ?, bild = ?, farbe1 = ?, farbe2 = ?, farbe3 = ?, farbe4 = ?, emoji = ?, zutaten = ?, zubereitung = ? WHERE rezept_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, rezept.getTitel());
            statement.setString(2, rezept.getBild());
            statement.setString(3, rezept.getFarbe1());
            statement.setString(4, rezept.getFarbe2());
            statement.setString(5, rezept.getFarbe3());
            statement.setString(6, rezept.getFarbe4());
            statement.setString(7, rezept.getEmoji());
            statement.setString(8, rezept.getZutaten());
            statement.setString(9, rezept.getZubereitung());
            statement.setInt(10, rezept.getRezeptId());
            statement.executeUpdate();
        }
    }

    public void deleteRezept(int rezeptId) throws SQLException {
        String sql = "DELETE FROM Rezept WHERE rezept_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, rezeptId);
            statement.executeUpdate();
        }
    }
}
