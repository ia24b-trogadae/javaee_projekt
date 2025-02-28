package org.example.rezept_webseite;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("register.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String passwort = request.getParameter("password");

        try (Connection connection = DBConnector.getConnection()) {
            if (connection == null) {
                response.sendRedirect("register.jsp?error=Datenbankverbindung fehlgeschlagen!");
                return;
            }

            if (userExists(connection, username, email)) {
                response.sendRedirect("register.jsp?error=Benutzername oder E-Mail existiert bereits!");
                return;
            }

            addUser(connection, username, email, passwort);
            response.sendRedirect("login.jsp?success=Registrierung erfolgreich! Bitte einloggen.");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("register.jsp?error=Fehler bei der Registrierung!");
        }
    }

    private boolean userExists(Connection connection, String username, String email) throws SQLException {
        String sql = "SELECT * FROM Benutzer WHERE username = ? OR email = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, email);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        }
    }

    private void addUser(Connection connection, String username, String email, String passwort) throws SQLException {
        String sql = "INSERT INTO Benutzer (username, email, passwort) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, email);
            stmt.setString(3, passwort);
            stmt.executeUpdate();
        }
    }
}
