package org.example.rezept_webseite;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String passwort = request.getParameter("password");

        // Überprüfung der Login-Daten
        try {
            if (isValidUser(username, passwort)) {
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                response.sendRedirect("IndexServlet");
            } else {
                response.sendRedirect("login.jsp?error=Falscher Benutzername oder Passwort!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("login.jsp?error=Fehler bei der Anmeldung!");
        }
    }

    private boolean isValidUser(String username, String passwort) throws SQLException {
        String sql = "SELECT * FROM Benutzer WHERE username = ? AND passwort = ?";

        // Verbindung innerhalb der Methode aufbauen
        try (Connection connection = DBConnector.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            if (connection == null) {
                throw new SQLException("Datenbankverbindung fehlgeschlagen!");
            }

            stmt.setString(1, username);
            stmt.setString(2, passwort);

            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next(); // Falls ein Treffer existiert, ist der Login erfolgreich
            }
        }
    }
}
