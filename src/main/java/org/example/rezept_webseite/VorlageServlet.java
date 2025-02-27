package org.example.rezept_webseite;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/VorlageServlet")
public class VorlageServlet extends HttpServlet {
    private RezeptDAO rezeptDAO;

    @Override
    public void init() throws ServletException {
        try {
            Connection connection = DBConnector.getConnection();
            rezeptDAO = new RezeptDAO(connection);
        } catch (Exception e) {
            throw new ServletException("Datenbankverbindung fehlgeschlagen.", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rezeptIdParam = request.getParameter("id"); // Parameter "id" aus der URL lesen
        if (rezeptIdParam != null) {
            try {
                int rezeptId = Integer.parseInt(rezeptIdParam); // Konvertiere den Parameter in einen Integer
                Rezept rezept = rezeptDAO.getRezeptById(rezeptId); // Rezept aus der Datenbank abrufen

                if (rezept != null) {
                    request.setAttribute("rezept", rezept); // Rezept an die JSP-Seite weitergeben
                    request.getRequestDispatcher("vorlageWebseite.jsp").forward(request, response);
                } else {
                    response.sendRedirect("index.jsp?error=RezeptNichtGefunden"); // Fehler: Rezept nicht gefunden
                }
            } catch (NumberFormatException | SQLException e) {
                response.sendRedirect("index.jsp?error=UngültigeRezeptId"); // Fehler: Ungültige rezept_id
            }
        } else {
            response.sendRedirect("index.jsp?error=KeineRezeptId"); // Fehler: Keine rezept_id angegeben
        }
    }

    @Override
    public void destroy() {
        try {
            Connection connection = DBConnector.getConnection();
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}