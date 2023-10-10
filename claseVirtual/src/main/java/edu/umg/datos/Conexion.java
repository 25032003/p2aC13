package edu.umg.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {
    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/p2a?useSSL=false&serverTimezone=UTC";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "123456789";

    public Conexion() {
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/p2a?useSSL=false&serverTimezone=UTC", "root", "123456789");
    }

    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException var2) {
            var2.printStackTrace(System.out);
        }

    }

    public static void close(PreparedStatement stmt) {
        try {
            stmt.close();
        } catch (SQLException var2) {
            var2.printStackTrace(System.out);
        }

    }

    public static void close(Connection conn) {
        try {
            conn.close();
        } catch (SQLException var2) {
            var2.printStackTrace(System.out);
        }

    }
}