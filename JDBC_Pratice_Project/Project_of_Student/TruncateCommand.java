package JDBC_Project.Project_of_Student;

import java.sql.*;

public class TruncateCommand {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/student";
    private static final String username = "root";
    private static final String password = "9689";

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String query = "TRUNCATE TABLE students";
            statement.executeUpdate(query);
            System.out.println("Successfully Truncate Command");
            statement.close();
            connection.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
