package session13_ex02.Database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

    // URL KẾT NỐI MYSQL
    private static final String URL =
            "jdbc:mysql://localhost:3306/module3_session13_ex01?useSSL=false&serverTimezone=UTC";

    // USER VÀ PASSWORD MÁY EM
    private static final String USER = "root";
    private static final String PASSWORD = "0311";

    // HÀM KẾT NỐI DB
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Không kết nối được database!");
        }
    }
}
