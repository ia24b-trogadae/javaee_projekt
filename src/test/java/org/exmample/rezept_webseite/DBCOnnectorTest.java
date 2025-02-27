package org.exmample.rezept_webseite;

import org.example.rezept_webseite.DBConnector;

import java.sql.Connection;

public class DBCOnnectorTest{
    public static void main(String[] args) {
        Connection conn = DBConnector.getConnection();
        if (conn != null) {
            System.out.println("Connection successful!");
        } else {
            System.out.println("Connection failed.");
        }
    }
}

