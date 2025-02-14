package org.example.rezept_webseite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RezeptDAO {
    private Connection connection;

    public RezeptDAO() {
        DBConnection dbConnection = new DBConnection();
        this.connection = dbConnection.getConnection();
    }

    public boolean createRezept(Rezept rezept) throws SQLException {
        String query = "INSERT INTO Rezept (titel, bild, farbe1, farbe2, farbe3, farbe4, emoji, zutaten, zubereitung, benutzer_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, rezept.getTitel());
            statement.setString(2, rezept.getBild());
            statement.setString(3, rezept.getFarbe1());
            statement.setString(4, rezept.getFarbe2());
            statement.setString(5, rezept.getFarbe3());
            statement.setString(6, rezept.getFarbe4());
            statement.setString(7, rezept.getEmoji());
            statement.setString(8, rezept.getZutaten());
            statement.setString(9, rezept.getZubereitung());
            statement.setInt(10, rezept.getBenutzerId());
            return statement.executeUpdate() > 0;
        }
    }

    public Rezept getRezeptById(int rezept_id) throws SQLException {
        String query = "SELECT * FROM Rezept WHERE rezept_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, rezept_id);
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
                        resultSet.getString("zubereitung"),
                        resultSet.getInt("benutzer_id")
                );
            }
        }
        return null;
    }

    public List<Rezept> getAllRezepte() throws SQLException {
        List<Rezept> rezepteList = new ArrayList<>();
        String query = "SELECT * FROM Rezept";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                rezepteList.add(new Rezept(
                        resultSet.getInt("rezept_id"),
                        resultSet.getString("titel"),
                        resultSet.getString("bild"),
                        resultSet.getString("farbe1"),
                        resultSet.getString("farbe2"),
                        resultSet.getString("farbe3"),
                        resultSet.getString("farbe4"),
                        resultSet.getString("emoji"),
                        resultSet.getString("zutaten"),
                        resultSet.getString("zubereitung"),
                        resultSet.getInt("benutzer_id")
                ));
            }
        }
        return rezepteList;
    }

    public boolean updateRezept(Rezept rezept) throws SQLException {
        String query = "UPDATE Rezept SET titel = ?, bild = ?, farbe1 = ?, farbe2 = ?, farbe3 = ?, farbe4 = ?, emoji = ?, zutaten = ?, zubereitung = ?, benutzer_id = ? WHERE rezept_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, rezept.getTitel());
            statement.setString(2, rezept.getBild());
            statement.setString(3, rezept.getFarbe1());
            statement.setString(4, rezept.getFarbe2());
            statement.setString(5, rezept.getFarbe3());
            statement.setString(6, rezept.getFarbe4());
            statement.setString(7, rezept.getEmoji());
            statement.setString(8, rezept.getZutaten());
            statement.setString(9, rezept.getZubereitung());
            statement.setInt(10, rezept.getBenutzerId());
            statement.setInt(11, rezept.getRezeptId());
            return statement.executeUpdate() > 0;
        }
    }

    public boolean deleteRezept(int rezept_id) throws SQLException {
        String query = "DELETE FROM Rezept WHERE rezept_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, rezept_id);
            return statement.executeUpdate() > 0;
        }
    }
}