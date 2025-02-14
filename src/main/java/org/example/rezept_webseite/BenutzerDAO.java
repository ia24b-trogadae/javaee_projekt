package org.example.rezept_webseite;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BenutzerDAO {
    private Connection connection;

    public BenutzerDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean createBenutzer(String username, String passwort, String email) throws SQLException {
        String query = "INSERT INTO Benutzer (username, passwort, email) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, passwort);
            statement.setString(3, email);
            return statement.executeUpdate() > 0;
        }
    }

    public Benutzer getBenutzerById(int benutzer_id) throws SQLException {
        String query = "SELECT * FROM Benutzer WHERE benutzer_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, benutzer_id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Benutzer(
                        resultSet.getInt("benutzer_id"),
                        resultSet.getString("username"),
                        resultSet.getString("passwort"),
                        resultSet.getString("email"),
                        resultSet.getTimestamp("erstellt")
                );
            }
        }
        return null;
    }

    public List<Benutzer> getAllBenutzer() throws SQLException {
        List<Benutzer> benutzerList = new ArrayList<>();
        String query = "SELECT * FROM Benutzer";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                benutzerList.add(new Benutzer(
                        resultSet.getInt("benutzer_id"),
                        resultSet.getString("username"),
                        resultSet.getString("passwort"),
                        resultSet.getString("email"),
                        resultSet.getTimestamp("erstellt")
                ));
            }
        }
        return benutzerList;
    }

    public boolean updateBenutzer(Benutzer benutzer) throws SQLException {
        String query = "UPDATE Benutzer SET username = ?, passwort = ?, email = ? WHERE benutzer_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, benutzer.getUsername());
            statement.setString(2, benutzer.getPasswort());
            statement.setString(3, benutzer.getEmail());
            statement.setInt(4, benutzer.getBenutzerId());
            return statement.executeUpdate() > 0;
        }
    }

    public boolean deleteBenutzer(int benutzer_id) throws SQLException {
        String query = "DELETE FROM Benutzer WHERE benutzer_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, benutzer_id);
            return statement.executeUpdate() > 0;
        }
    }
}