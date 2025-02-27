package org.example.rezept_webseite;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
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
        try {
            List<Rezept> rezepteListe = rezeptDAO.getAllRezepte();
            // Debugging: Prüfen, ob die Liste gefüllt wird
            System.out.println("Rezepte gefunden: " + rezepteListe.size());
            request.setAttribute("rezepteListe", rezepteListe);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (SQLException e) {
            response.sendRedirect("index.jsp?error=DatenbankFehler");
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