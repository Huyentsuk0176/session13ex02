package session13ex03.ra.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {


    private static final String URL =
            "jdbc:mysql://localhost:3306/module3_session13_ex01?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";


    private static final String USER = "root";
    private static final String PASSWORD = "YOUR_PASSWORD";
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("❌ Lỗi kết nối DB: " + e.getMessage());
            return null;
        }
    }


    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("❌ Lỗi đóng Connection: " + e.getMessage());
            }
        }
    }
}

