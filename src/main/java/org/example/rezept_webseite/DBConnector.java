package org.example.rezept_webseite;

import java.sql.*;

public class DBConnector {

    private static final String URL = "jdbc:mysql://localhost:3306/RezeptWebseite";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Fehler beim Herstellen der Datenbankverbindung!");
            e.printStackTrace();
            return null;
        }
    }

    public static void closeResources(Connection con, PreparedStatement stmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
