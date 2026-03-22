package Book_Store_Management_System;

import java.sql.*;

public class DBConnection {
    private static final String url="jdbc:mysql://127.0.0.1:3306/bookstore_management";
    private static final String username="root";
    private static final String password="9689";
    // Main function
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
